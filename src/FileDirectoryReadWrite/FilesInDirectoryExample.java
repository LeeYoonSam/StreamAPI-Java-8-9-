package FileDirectoryReadWrite;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * URL - https://howtodoinjava.com/java-8/java-8-list-all-files-example/
 */
public class FilesInDirectoryExample {
    public static void main(String[] args) throws IOException {

        System.out.println("[ List all files and sub-directories using Files.list() ]");
        getFilesList();
        System.out.println("-------------------------------");


        System.out.println("[ List files and sub-directories with Files.newDirectoryStream() ]");
        getNewDirectoryStream();
        System.out.println("-------------------------------");


        System.out.println("[ Find all hidden files in directory ]");
        findHiddenFiles();
    }

    public static void getFilesList() throws IOException {
        Files.list(Paths.get("."))
                .forEach(System.out::println);

        System.out.println("---------- using filter ---------");

        Files.list(Paths.get("."))
                .filter(Files::isRegularFile)
                .forEach(System.out::println);
    }

    public static void getNewDirectoryStream() throws IOException {
        Files.newDirectoryStream(Paths.get("."))
                .forEach(System.out::println);


        System.out.println("---------- use path filter as second argument. ---------");
        Files.newDirectoryStream(Paths.get("."), path -> path.toFile().isFile())
                .forEach(System.out::println);


        System.out.println("---------- get files of certain extension only ---------");
        Files.newDirectoryStream(Paths.get("./src/Lines"),
                path -> path.toString().endsWith(".java"))
                .forEach(System.out::println);
    }

    public static void findHiddenFiles() {
        File[] files = new File(".").listFiles(file -> file.isHidden());
        // or
        File[] files2 = new File(".").listFiles(File::isHidden);

        Arrays.stream(files2).forEach(System.out::println);
    }
}
