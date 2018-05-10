package Algorithms;

import java.util.ArrayList;
import java.util.Scanner;

public class FizzBuzz {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int input = in.nextInt();

        System.out.println("기본적인 구현");
        System.out.println(fizzBuzz(input));
        System.out.println();

        System.out.println("추상화된 구현");
        System.out.println(fizzBuzz2(input));
    }

    // 기본적인 구현
    static ArrayList<String> fizzBuzz(int input) {
        final ArrayList<String> toReturn = new ArrayList<>();

        for(int i = 1; i <= input; i ++) {
            if(i % 15 == 0)
                toReturn.add("FizzBuzz");
            else if(i % 3 == 0)
                toReturn.add("Fizz");
            else if(i % 5 == 0)
                toReturn.add("Buzz");
            else
                toReturn.add(Integer.toString(i));
        }

        return toReturn;
    }

    // 추상화된 구현
    static ArrayList<String> fizzBuzz2(int input) {
        final ArrayList<String> toReturn = new ArrayList<>();

        for(int i = 1; i <= input; i ++) {
            // 3과 5 각각 한번씩 나누어봄, 이렇게하면 15의 배수일때 따로 체크안해도 FizzBuzz가 출력된다.
            final String word = toWord(3, i, "Fizz") + toWord(5, i, "Buzz");

            if(word.isEmpty())
                toReturn.add(Integer.toString(i));
            else
                toReturn.add(word);
        }

        return toReturn;
    }

    static String toWord(final int divisor, final int value, final String word) {
        return value % divisor == 0 ? word : "";
    }
}
