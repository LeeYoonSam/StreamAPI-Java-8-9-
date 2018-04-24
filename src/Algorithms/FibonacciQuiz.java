package Algorithms;

import java.util.stream.Stream;

/**
 * 피보나치는 0, 1로 시작
 * 다음정수는 앞의 두 피보나치 수의 합
 * 정수 n이 주어지고 n보다 작은 모든 짝수의 피보나치 수의 합을 구하라
 */
public class FibonacciQuiz {
    public static void main(String[] args) {

        System.out.println("Fibonacci Even sum: " + fibonacciEvenSum(12));
        System.out.println("fibonacciEvenSumStream: " + fibonacciEvenSumStream(12));
    }

    // while 문으로 구현
    public static int fibonacciEvenSum(int n) {
        int before = 1;
        int after = 2;
        int nextNum = 0;
        int sum = 2;

        while (nextNum < n) {
            nextNum = before + after;

            before = after;
            after = nextNum;

            if(nextNum < n) {
                System.out.println(nextNum);

                if(nextNum % 2 == 0)
                    sum += nextNum;
            }
        }

        return sum;
    }

    // stream으로 구현
    public static int fibonacciEvenSumStream(int series) {
        return Stream.iterate(new int[]{0, 1}, s -> new int[]{s[1], s[0] + s[1]})
                .limit(series)
                .map(n -> n[0])
                .filter(n -> n < series)
                .filter(n -> n % 2 == 0)
                .reduce((a,b) -> a + b)
                .get();
    }
}
