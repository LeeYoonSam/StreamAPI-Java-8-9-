package Join;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * URL - https://howtodoinjava.com/java-8/java-8-join-string-array-example/
 */
public class JoinArrayExample {
    public static void main(String[] args) {
        System.out.println("[ join(CharSequence delimiter, CharSequence… elements) ]");
        joinMultipleStrings();
        System.out.println("-------------------------------");


        System.out.println("[ join(CharSequence delimiter, Iterable elements) ]");
        joinArrayStrings();
        System.out.println("-------------------------------");


        System.out.println("[ Using StringJoiner for formatted output ]");
        usingStringJoiner();
        System.out.println("-------------------------------");


        System.out.println("[ Join String Array using StringUtils.join() method – Apache Commons Lang]");
        usingStringUtils();
        System.out.println("-------------------------------");
    }

    public static void joinMultipleStrings() {
        // 구분자, join 할 엘리먼트
        String joinedString = String.join(", ", "How", "To", "Do", "In", "Java");
        System.out.println(joinedString);
    }

    public static void joinArrayStrings() {
        List<String> strList = Arrays.asList("How", "To", "Do", "In", "Java");

        String joinedString = String.join(", ", strList);
        System.out.println(joinedString);

        String[] strArray = { "How", "To", "Do", "In", "Java" };
        joinedString = String.join(", ", strArray);
        System.out.println(joinedString);
    }

    /**
     * Using StringJoiner for formatted output
     */
    public static void usingStringJoiner() {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        joiner.add("How").add("To").add("Do").add("In").add("Java");
        System.out.println(joiner);


        System.out.println("---------- Collectors.joining() -----------");

        List<String> numbers = Arrays.asList("How", "To", "Do", "In", "Java");
        String joinedString = numbers.stream().collect(Collectors.joining(", ", "[", "]"));
        System.out.println(joinedString);
    }

    public static void usingStringUtils() {
        String[] strArray = { "How", "To", "Do", "In", "Java" };

//        String joinedString = StringUtils.join(strArray);
//        System.out.println(joinedString);
//
//        String joinedString2 = StringUtils.join(strArray, ",");
//        System.out.println(joinedString2);
    }
}
