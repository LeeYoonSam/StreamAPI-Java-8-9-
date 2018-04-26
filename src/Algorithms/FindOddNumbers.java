package Algorithms;

import java.util.Arrays;
import java.util.stream.IntStream;

public class FindOddNumbers {
    public static void main(String[] args) {
        Arrays.stream(oddNumbers(3, 10)).forEach( it -> System.out.println(it));
    }

    /*
     * l~r 범위의 숫자 중에서 홀수만 출력하기
     */
    static int[] oddNumbers(int l, int r) {


        return IntStream.range(l, r + 1)
                .filter(i -> i % 2 == 1)
                .toArray();
    }

}
