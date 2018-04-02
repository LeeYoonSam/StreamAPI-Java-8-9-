package Stream;

import java.util.stream.IntStream;

/**
 * 루핑(looping) - 요소 전체를 반복
 * peek() - 중간 처리 메소드, forEach() - 최종 처리 메소드
 *
 * peek()는 메소드 중간 처리 단계에서 전체 요소를 루핑하면서 추가적인 작업을 하기 위해 사용
 * 최종 처리 메소드는 아니므로 최종 처리 메소드를 사용해야 한다.
 */
public class PeekExample {

    public static void main(String[] args) {
        incorrectExample();

        correctExample();
    }

    // peek()는 최종 처리 메소드가 아니므로 아래 예제는 스트림이 작동하지 않는다.
    public static void incorrectExample() {
        IntStream stream = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        stream.filter(number -> number % 2 == 0)
                .peek(System.out::println);
    }

    public static void correctExample() {
        IntStream stream = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println("Sum: " + stream.filter(number -> number % 2 == 0)
                .peek(System.out::println)
                .sum());
    }
}
