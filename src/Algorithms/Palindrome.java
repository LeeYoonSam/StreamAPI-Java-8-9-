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
}
