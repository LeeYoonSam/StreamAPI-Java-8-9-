package Algorithms;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 정수 배열(int array)이 주어지면 0이 아닌 정수 순서를 유지하며 모든 0을 배열 오른쪽 끝으로 옮기시오.
 * 단, 시간복잡도는 O(n), 공간복잡도는 O(1)여야 합니다.
 *
 * ex)
 * Input: [0, 5, 0, 3, -1]
 * Output: [5, 3, -1, 0, 0]
 *
 * Input: [3, 0, 3]
 * Output: [3, 3, 0]
 */
public class ZeroRightAlign {

    public ArrayList<Integer> moveZero(ArrayList<Integer> list) {
        ArrayList<Integer> result = new ArrayList<>();

        int front = 0;
        for(int num: list) {
            if(num == 0) {
                result.add(num);
            } else {
                result.add(front, num);
                front ++;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String[] inputAry = input.split(" ");

        ArrayList<Integer> list = new ArrayList<>();
        for(String num : inputAry) {
            list.add(Integer.parseInt(num));
        }

        System.out.println("Input: " + list);

        ZeroRightAlign zeroRightAlign = new ZeroRightAlign();
        System.out.println("Output: " + zeroRightAlign.moveZero(list));
    }
}
