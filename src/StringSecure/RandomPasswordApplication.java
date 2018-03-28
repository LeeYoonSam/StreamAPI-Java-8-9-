package StringSecure;

import java.security.SecureRandom;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomPasswordApplication {
    private static final List<String> CHARACTER_TABLE = List.of(
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
            "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
            "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
            "_", "-", "$", "@", "#", "&", "%", "/", "\\", "?",
            "*", "+", "!", ".", ",", ";", "~", "'", "\"", "<", ">"
    );

    public static void main(String[] args) {
        IntStream.range(8, 15)
                .boxed()
                .map(RandomPasswordApplication::createpassword)
                .map(password -> String.format("Password [length=%d] is %s", password.length(), password))
                .forEach(System.out::println);
    }

    public static String createpassword(int length) {
        final StrongPassword strongess = new StrongPassword.Builder()
                .minimumNumberOfDigits(1)
                .minimumNumberOfSpecialCharacters(1)
                .minimumNumberOfCapitalLetters(1)
                .minimumLength(length)
                .build();

        // takeWhile - java9
        return new SecureRandom()
                .ints(0, CHARACTER_TABLE.size())
                .boxed()
                .map( CHARACTER_TABLE::get )
                .takeWhile(strongess::isWeek)
                .collect(Collectors.joining());
    }
}
