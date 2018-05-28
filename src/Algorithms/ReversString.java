package Algorithms;

import java.util.Scanner;

/**
 * 주어진 String에 모든 단어를 거꾸로 하시오.
 *
 * ex)
 * Input: "abc 123 apple"
 * Output: "cba 321 elppa"
 */
public class ReversString {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String inputText = in.nextLine();

        // 스페이스단위로 잘라서 배열 만들기
        String[] wordAry = inputText.split(" ");
        System.out.println(convertToReverse(wordAry));

    }

    // 전달받은 배열을 돌면서 배열 길이 만큼 " " 공백 표시
    public static String convertToReverse(String[] wordAry) {
        StringBuilder strBuilder = new StringBuilder();

        for(String word : wordAry) {
            strBuilder.append(getReverseString(word)).append(" ");
        }

        return strBuilder.toString();
    }

    // 문자열 뒤집기
    public static String getReverseString(String text) {
        StringBuilder strBuilder = new StringBuilder();

        for(int i = text.length()-1; i >= 0; i --) {
            strBuilder.append(text.charAt(i));
        }

        return strBuilder.toString();
    }
}
