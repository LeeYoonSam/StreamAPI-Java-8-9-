package RegularExpression;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Pattern으로 정규식 패턴을 만들고 Predicate로 필터링 하기
 *
 * URL - https://howtodoinjava.com/java-8/regex-predicate-using-pattern-compile/
 */
public class RegexExample {

    public static void main(String[] args) {
        System.out.println("[ Convert Regex to Predicate ]");
        regexPredicate();
        System.out.println("-------------------------------");

        System.out.println("[ Using Regex using Pattern.matcher() ]");
        patternMatcher();
        System.out.println("-------------------------------");

        PriorityQueue<Integer> dd = new PriorityQueue<>();
    }

    // Pattern.compile().asPredicate()
    public static void regexPredicate() {
        Predicate<String> emailFilter = Pattern.compile("^(.+)@example.com$").asPredicate();

        List<String> emails = Arrays.asList("alex@example.com", "bob@yahoo.com",
                "cat@google.com", "david@example.com");

        // emailFilter 에서 작성한 predicate를 사용한 정규식 표현 필터
        List<String> desiredEmails = emails.stream()
                .filter(emailFilter)
                .collect(Collectors.toList());

        System.out.println(desiredEmails);
    }

    // Pattern.matcher()
    public static void patternMatcher() {
        Pattern pattern = Pattern.compile("^(.+)@example.com$");

        List<String> emails = Arrays.asList("alex@example.com", "bob@yahoo.com",
                "cat@google.com", "david@example.com");

        for(String email : emails) {
            Matcher matcher = pattern.matcher(email);

            if(matcher.matches()) {
                System.out.println(email);
            }
        }
    }

}
