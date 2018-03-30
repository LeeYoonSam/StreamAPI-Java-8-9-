package FileDirectoryReadWrite;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * URL - https://howtodoinjava.com/java-8/java-8-write-to-file-example/
 */
public class FilesWriteExample {
    public static void main(String[] args) throws IOException {
        System.out.println("[ Write to file using BufferedWriter ]");
        writeFileBufferedWriter();
        System.out.println("-------------------------------");


        System.out.println("[ Write to file using Files.write() ]");
        writeFilesWrite();
        System.out.println("-------------------------------");
    }

    public static void writeFileBufferedWriter() throws IOException {

        Path path = Paths.get("./writeFileBufferedWriter.txt");

        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write("Hello World!!");
            writer.append("\nGood Bye");
        }
    }

    public static void writeFilesWrite() throws IOException {
        Path path = Paths.get("./writeFilesWrite.txt");

        // make new File - Default
        String content = "Hello World";
        Files.write(path, content.getBytes());

        // append to exist file
        content = "\nGood Bye";
        Files.write(path, content.getBytes(), StandardOpenOption.APPEND);

        /**
         * < StandardOpenOption >
         * READ
         * WRITE
         * APPEND
         * TRUNCATE_EXISTING
         * CREATE
         * CREATE_NEW
         * DELETE_ON_CLOSE
         * SPARSE
         * SYNC
         * DSYNC
         *
         */
    }
}
