package Algorithms;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/array-left-rotation/problem
 *

 Sample Input
 5 4
 1 2 3 4 5
 Sample Output
 5 1 2 3 4

 */
public class LeftRotation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] nd = scan.nextLine().split(" ");

        // 배열 갯수
        int n = Integer.parseInt(nd[0].trim());

        // Left 회전수
        int d = Integer.parseInt(nd[1].trim());

        int[] a = new int[n];

        String[] aItems = scan.nextLine().split(" ");

        // n 길이의 배열 생성
        for (int aItr = 0; aItr < n; aItr++) {
            int aItem = Integer.parseInt(aItems[aItr].trim());
            a[aItr] = aItem;
        }


        int[] result = new int[n];

        System.arraycopy(a, d, result, 0, n-d);
        System.arraycopy(a, 0, result, n-d, n - (n-d));

        Arrays.stream(result).forEach(it -> System.out.print(it + " "));


        // Todo: 이코드를 사용하니 숫자가 많아졌을때 timeout 발생!!
//        // d 만큼 Left 회전 시키기
//        for(int i = 0; i < d; i ++) {
//            int temp = a[n];
//
//            for(int j = 1; j < a.length; j ++){
//               a[j-1] = a[j];
//            }
//
//            a[arSize] = temp;
//        }
    }
}
