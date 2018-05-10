package Algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 정수(int)가 주어지면, 팰린드롬(palindrome)인지 알아내시오. 팰린드롬이란, 앞에서부터 읽으나 뒤에서부터 읽으나 같은 단어를 말합니다. 단, 정수를 문자열로 바꾸면 안됩니다.
 *
 * 예제)
 * Input: 12345
 *
 * Output: False
 *
 *
 *
 * Input: -101
 *
 * Output: False
 *
 *
 *
 * Input: 11111
 *
 * Output: True
 *
 *
 *
 * Input: 12421
 *
 * ﻿Output: True
 *
 */
public class Palindrome {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String inputString = in.nextLine();

        usingArray(inputString);
        usingSubstring(inputString);

        if(strictPalindrome(inputString))
            System.out.println("True");
        else
            System.out.println("False");


        try {
            System.out.println(isPalindrome(Integer.parseInt(inputString)));
        } catch (Exception e){}

    }

    static void usingArray(String inputString) {
        List<Integer> input = new ArrayList<>();
        for(int i = 0; i < inputString.length(); i ++) {
            try {
                input.add(Integer.parseInt(String.valueOf(inputString.charAt(i))));
            } catch (Exception e) {
                System.out.println("False");
                return;
            }
        }

        // 입력받은 문자열이 짝수일때 그냥 실패처리
        if(input.size() % 2 == 0) {
            System.out.println("False");
            return;
        }

        // 가운데 자리 구하기
        int mid = input.size() / 2;
        int midIndex = mid + 1;

        // 왼쪽 결과값, 오른쪽 결과값 담을 배열
        int[] result1 = new int[midIndex];
        int[] result2 = new int[midIndex];

        // 배열의 반만큼만 반복문 실행
        for(int i = 0; i < midIndex; i ++) {
            result1[i] = input.get(i);
            result2[i] = input.get(input.size() - 1 - i);
        }

        // 왼쪽, 오른쪽 값 비교해서 팰린드룸이 되는지 확인
        boolean isEquals = true;
        for(int i = 0; i < midIndex ; i++ ) {
            if(result1[i] != result2[i])
                isEquals = false;
        }

        if(isEquals)
            System.out.println("True");
        else
            System.out.println("False");
    }

    static void usingSubstring(String inputString) {

        //  입력받은 값의 가운데를 구함
        int midIndex = inputString.length() / 2;

        // 처음부터 가운데까지 문자열 자르기
        String leftString = inputString.substring(0, midIndex + 1);

        // 가운데부터 끝까지 문자열 자르고 StringBuilder를 이용해서 reverse 시키기
        String rightString = new StringBuilder().append(inputString.substring(midIndex, inputString.length())).reverse().toString();

        // 문자열 같은지 비교
        if(leftString.equals(rightString))
            System.out.println("True");
        else
            System.out.println("False");
    }

    /*
    풀이 답안 가져옴

    시간 복잡도: O(log n) // 숫자의 길이만큼 반복
    공간 복잡도: O(1)
     */
    static boolean isPalindrome(int input) {
        if(input < 0 || (input % 10 == 0 && input != 0)) {
            return false;
        }

        int revertedHalf = 0;

        // while을 사용하여 1의 자리를 구한 후 10으로 나누어 1의자리 삭제
        while(input > revertedHalf) {
            revertedHalf = revertedHalf * 10 + input % 10;
            input /= 10;
        }

        return input == revertedHalf || input == revertedHalf/10;
    }

    static String reverse(final String s) {
        final StringBuilder builder = new StringBuilder(s.length());
        for(int i = s.length() -1; i >= 0; i--) {
            builder.append(s.charAt(i));
        }

        return builder.toString();
    }

    static boolean isPalindrome2(final String s) {
        final String toCheck = s.toLowerCase();

        int left = 0;
        int right = toCheck.length() - 1;

        while (left <= right) {
            while (left < toCheck.charAt(left)) {
                left ++;
            }

            while (right > 0 && !Character.isLetter(toCheck.charAt(right))) {
                right --;
            }

            if(left > toCheck.length() || right < 0) {
                return false;
            }

            if(toCheck.charAt(left) != toCheck.charAt(right)) {
                return false;
            }

            left ++;
            right --;
        }

        return true;
    }

    static boolean strictPalindrome(final String s) {
        return s.equals(reverse(s));
    }
}
