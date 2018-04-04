package Join;

import java.time.ZoneId;

/**
 * URL - https://howtodoinjava.com/java-8/java-8-string-join-csv-example/
 *
 * 문자열 조합 에제
 */
public class JoinStringExample {

    public static void main(String[] args) {
        System.out.println("[ String concatenation (CSV) with join() ]");
        concatenationJoin();
        System.out.println("-------------------------------");
    }

    public static void concatenationJoin() {
        String joined = String.join("/", "usr", "local", "bin");
        System.out.println(joined);

        System.out.println("-------- Available ZoneId --------");
        String ids = String.join(", ", ZoneId.getAvailableZoneIds());
        System.out.println(ids);
    }
}
