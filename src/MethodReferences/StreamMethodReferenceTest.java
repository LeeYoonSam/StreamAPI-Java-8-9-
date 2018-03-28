package MethodReferences;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamMethodReferenceTest {

    /**
     * URL - https://howtodoinjava.com/java-8/lambda-method-references-example/
     */

    public static void main(String[] args) {
        // Test - reference2InstanceMethod
        reference2InstanceMethod(0);
        reference2InstanceMethod(1);
        reference2InstanceMethod(2);

        // Test - reference2Constructor
        reference2Constructor();

    }

    public static void reference2InstanceMethod(int type) {
        List<String> strings = Arrays
                .asList("how", "to", "do", "in", "java", "dot", "com");

        switch (type) {
            case 0:
                List<String> sorted2 = strings
                        .stream()
                        .sorted((s1, s2) -> s1.compareTo(s2))
                        .collect(Collectors.toList());

                System.out.println(sorted2);
                break;

                // Java 8 - Method references
            case 1:
                List<String> sorted = strings
                        .stream()
                        .sorted( String::compareTo)
                        .collect(Collectors.toList());

                System.out.println(sorted);
                break;

            case 2:
                // java 9 - Comparator.naturalOrder()
                List<String> sorted3 = strings
                        .stream()
                        .sorted(Comparator.naturalOrder())
                        .collect(Collectors.toList());

                System.out.println(sorted3);
                break;
        }
    }

    public static void reference2Constructor() {
        List<Integer> integers = IntStream
                .range(1, 100)
                .boxed()
                .collect(Collectors.toCollection( ArrayList::new ));
//              .collect(Collectors.toList());

        Optional<Integer> max = integers.stream().reduce(Math::max);

        max.ifPresent(System.out::println);
    }


}
