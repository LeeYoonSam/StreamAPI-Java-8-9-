package Lines;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Stream;

public class LinesExample {
    public static void main(String[] args) throws IOException {

        System.out.println("[ Normal IO operation till java 7 ]");
        readLinesUsingFileReader();
        System.out.println("-----------------------------------------");


        System.out.println("[ Read file lazily as stream of lines ]");
        readStreamOfLinesUsingFiles();
        System.out.println("-----------------------------------------");


        System.out.println("[ Read file as stream of lines with try-with-resources ]");
        readStreamOfLinesUsingFilesWithTryBlock();
        System.out.println("-----------------------------------------");


    }




    // Normal IO operation till java 7
    private static void readLinesUsingFileReader() throws IOException {
        File file = new File("./src/Lines/data.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while((line = br.readLine()) != null){
            if(line.contains("password")){
                System.out.println(line);
            }
        }
        br.close();
        fr.close();
    }

    // Read file lazily as stream of lines
    private static void readStreamOfLinesUsingFiles() throws IOException {
        Stream<String> lines = Files.lines(Paths.get("./src/Lines/data.txt"));
        Optional<String> hasPassword = lines.filter(s -> s.contains("password")).findFirst();

        if(hasPassword.isPresent()) {
            System.out.println(hasPassword.get());
        }

        lines.close();
    }

    private static void readStreamOfLinesUsingFilesWithTryBlock() throws IOException {
        Path path = Paths.get("./src/Lines/data.txt");

        //The stream hence file will also be closed here
        try(Stream<String> lines = Files.lines(path)) {
            Optional<String> hasPassword = lines.filter(s -> s.contains("password")).findFirst();

            if(hasPassword.isPresent()) {
                System.out.println(hasPassword.get());
            }
        }

        //When filteredLines is closed, it closes underlying stream as well as underlying file.
        try(Stream<String> filteredLines = Files.lines(path).filter(s -> s.contains("password"))){
            Optional<String> hasPassword = filteredLines.findFirst();

            if(hasPassword.isPresent()){
                System.out.println(hasPassword.get());
            }
        }

        try(Stream<String> filteredLines = Files.lines(path)
                .onClose( () -> System.out.println("File closed"))
                .filter(s -> s.contains("Password"))) {

            Optional<String> hasPassword = filteredLines.findFirst();

            if(hasPassword.isPresent()) {
                System.out.println(hasPassword.get());
            }
        }


    }
}
