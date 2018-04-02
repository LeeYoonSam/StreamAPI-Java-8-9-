package Iteration;

import java.util.Arrays;
import java.util.List;

/**
 * URL - https://howtodoinjava.com/java-8/java-8-tutorial-internal-vs-external-iteration/
 */
public class InternalExternalExample {
    public static void main(String[] args) {

        System.out.println("[ External iteration ]");
        externalIteration();
        System.out.println("-------------------------------");

        System.out.println("[ Internal iteration ]");
        internalIteration();
        System.out.println("-------------------------------");
    }

    /**
     * 일반 for 루프 사용
     *
     * 컬렉션에 지정된 순서대로 순차적으로 요소를 처리
     * 순서변경, 병렬처리, 지연 더 나은 성능을 제공 할 수 있는 관리기회 제한
     */
    public static void externalIteration() {
        List<String> alphabets = Arrays.asList(new String[]{"a","b","b","d"});

        for(String letter: alphabets){
            System.out.println(letter.toUpperCase());
        }
    }

    /**
     * Iterable 내부의 forEach 함수 사용
     *
     * 순차적으로하면 성능에 불리한 경우가 생길때의 대안으로 내부 반복을 사용
     * 클라이언트가 라이브러리에서 처리하도록 전체/일부 데이터 요소에 대해 실행해야하는 코드만 제공
     */
    public static void internalIteration() {
        List<String> alphabets = Arrays.asList(new String[]{"a","b","b","d"});
        alphabets.forEach(letter -> System.out.println(letter.toUpperCase()));
    }
}
