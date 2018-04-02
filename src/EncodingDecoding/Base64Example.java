package EncodingDecoding;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.stream.Collectors;

public class Base64Example {
    public static void main(String[] args) throws IOException {

        System.out.println("[ Base64 support from Java 8 ]");

        String encodedString = base64Encoding();

        base64Decoding(encodedString);

        System.out.println("-------------------------------");

        wrapToBase64();
    }

    public static String base64Encoding() {
        Base64.Encoder encoder = Base64.getEncoder();

        String normalString = "username:password";
        String encodedString = encoder.encodeToString(normalString.getBytes(StandardCharsets.UTF_8));

        System.out.println("encodedString: " + encodedString);

        return encodedString;
    }

    public static void base64Decoding(String encodedString) {
        Base64.Decoder decoder = Base64.getDecoder();

        byte[] decodedByteArray = decoder.decode(encodedString);
        System.out.println(new String(decodedByteArray));
    }

    public static void wrapToBase64() throws IOException {
        Path originalPath = Paths.get("./test.txt");
        Path targetPath = Paths.get("./copy.txt");

        Base64.Encoder mimeEncoder =  Base64.getMimeEncoder();

        try (OutputStream output = Files.newOutputStream(targetPath)) {
            Files.copy(originalPath, mimeEncoder.wrap(output));
            OutputStream encodedStream = mimeEncoder.wrap(output);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // 파일을 라인단위로 읽어와서 Collectors.joining()으로 다 합치기
        String copyValue = Files.lines(targetPath).peek(System.out::println).collect(Collectors.joining());
        base64Decoding(copyValue);
     }
}
