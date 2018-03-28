package Stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * URL - https://howtodoinjava.com/java-8/java-8-tutorial-streams-by-examples/
 */

public class StreamBuilders {
    public static void main(String[] args) {
        streamOf();
        System.out.println("-------------------------------");

        streamOfInteger();
        System.out.println("-------------------------------");

        streamSomeList();
        System.out.println("-------------------------------");

//        streamGenerate();
//        System.out.println("-------------------------------");

        streamChars();
        System.out.println("-------------------------------");

        convertStream2List();
        System.out.println("-------------------------------");

        convertStream2Array();
        System.out.println("-------------------------------");

        streamCore();
        System.out.println("-------------------------------");

        streamParallelism();
        System.out.println("-------------------------------");
    }


    public static void streamOf() {
        Stream<Integer> stream = Stream.of(1,2,3,4,5,6,7,8,9);
        stream.forEach(item -> System.out.println(item));
    }

    public static void streamOfInteger() {
        Stream<Integer> stream = Stream.of(new Integer[] {1,2,3,4,5,6,7,8,9});
        stream.forEach(item -> System.out.println(item));
    }

    public static void streamSomeList() {
        List<Integer> list = getBaseDate();

        Stream<Integer> stream = list.stream();
        stream.forEach(item -> System.out.println(item));
    }

    // date to infinite repeat
    public static void streamGenerate() {
        Stream<Date> stream = Stream.generate( () -> new Date());
        stream.forEach(item -> System.out.println(item));
    }

    public static void streamChars() {
        IntStream stream = "12345_abcdefg".chars();
        stream.forEach(item -> System.out.println(item));

        System.out.println("-------------------------------");
        // OR

        Stream<String> stream2 = Stream.of("A$B$C".split("\\$"));
        stream2.forEach(item -> System.out.println(item));
    }

    public static void convertStream2List() {
        List<Integer> list = getBaseDate();
        Stream<Integer> stream = list.stream();

        List<Integer> evenNubersList = stream
                .filter( i -> i % 2 == 0)
                .collect(Collectors.toList());

        System.out.println(evenNubersList);
    }

    public static void convertStream2Array() {
        List<Integer> list = getBaseDate();

        Stream<Integer> stream = list.stream();
        Integer[] evenNumbersArr = stream
                .filter(i -> i % 2 == 0)
                .toArray(Integer[]::new);

        System.out.println(evenNumbersArr);
        System.out.println("Length: " + evenNumbersArr.length);

        Arrays.stream(evenNumbersArr).forEach(System.out::println);
    }

    public static List<Integer> getBaseDate() {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 10; i ++) {
            list.add(i);
        }

        return list;
    }

    public static void streamCore() {

        List<String> memberNames = new ArrayList<>();
        memberNames.add("Amitabh");
        memberNames.add("Shekhar");
        memberNames.add("Aman");
        memberNames.add("Rahul");
        memberNames.add("Shahrukh");
        memberNames.add("Salman");
        memberNames.add("Yana");
        memberNames.add("Lokesh");

        System.out.println("< Intermediate operations >\n");

        System.out.println("[ filter - startWith 'A' ]");
        memberNames.stream().filter( name -> name.startsWith("A")).forEach(System.out::println);

        System.out.println("[ map - startWith 'A' -> toUpperCase ]");
        memberNames.stream().filter(name -> name.startsWith("A")).map(name -> name.toUpperCase()).forEach(System.out::println);

        System.out.println("[ sorted - toUpperCase ]");
        memberNames.stream().sorted().map(name -> name.toUpperCase()).forEach(System.out::println);


        System.out.println("=======================");
        System.out.println("< Terminal operations >\n");

        System.out.println("[ forEach() ]");
        memberNames.forEach(System.out::println);

        System.out.println("[ collect() ]");
        List<String> memNamesInUppercase = memberNames.stream().map(name -> name.toUpperCase()).collect(Collectors.toList());
        System.out.println(memNamesInUppercase);

        System.out.println("[ match() ]");

        // 이름이 A로 시작하는 스트림이 하나라도 있는가?
        boolean matchedResult = memberNames.stream()
                .anyMatch( (name) -> name.startsWith("A"));
        System.out.println(matchedResult);

        // 스트림의 이름이 전부다 A로 시작하는가?
        matchedResult = memberNames.stream()
                .allMatch( (name) -> name.startsWith("A"));
        System.out.println(matchedResult);

        // 이름이 A로 시작하는 스트림이 없는가?
        matchedResult = memberNames.stream()
                .noneMatch( (name) -> name.startsWith("A"));
        System.out.println(matchedResult);

        System.out.println("[ count() ]");
        long totalMatched = memberNames.stream()
                .filter( (name) -> name.startsWith("A"))
                .count();

        System.out.println(totalMatched);

        System.out.println("[ reduce() ]");
        // 스트림을 하나로 줄임
        Optional<String> reduced = memberNames.stream()
                .reduce( (name1, name2) -> name1 + "#" + name2);

        reduced.ifPresent(System.out::println);


        System.out.println("=======================");
        System.out.println("< Short-circuit operations >\n");

        System.out.println("[ anyMatch() ]");
        boolean matched = memberNames.stream()
                .anyMatch( (name) -> name.startsWith("A"));

        System.out.println(matched);

        System.out.println("[ findFirst() ]");
        // L로 시작하는 이름의 첫번째 출력
        String firstMatchedName = memberNames.stream()
                .filter( (name) -> name.startsWith("L"))
                .findFirst().get();

        System.out.println(firstMatchedName);
    }

    public static void streamParallelism() {
        List<Integer> list = getBaseDate();

        Stream<Integer> stream = list.parallelStream();
        Integer[] evenNumbersArr = stream.filter( i -> i % 2 == 0).toArray(Integer[]::new);

        System.out.println(evenNumbersArr);
        System.out.println("Length: " + evenNumbersArr.length);

        Arrays.stream(evenNumbersArr).forEach(System.out::println);
    }

}
