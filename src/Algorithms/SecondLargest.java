package Algorithms;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 정수 배열(int array)이 주어지면 두번째로 큰 값을 프린트하시오.
 *
 * 예제)
 * Input: [10, 5, 4, 3, -1]
 * Output: 5
 *
 * Input [3, 3, 3]
 * Output: Does not exist.
 */
public class SecondLargest {

    public static final String NOT_EXIST_MESSAGE = "Does not exist.";
    public String findSecondLargest(String[] numbers) {

        try {
            int[] nums = Arrays.stream(numbers).mapToInt(value -> Integer.parseInt(value)).toArray();


            // 첫번째 두번째 인자는 바로 넣기
            int max = nums[0];
            int second = nums[1];

            for(int i = 2; i < nums.length; i++) {
                // 현재 비교 하고 있는 숫자
                int current = nums[i];

                // 최대값 보다 큰지 확인
                if(max < current) {

                    // 최대값 보다 크면 비교 값 변경
                    current = max;
                    max = nums[i];
                }

                // 임의의 2번째 큰수와 비교해서 더 큰수를 넣는다.
                if(second < current)
                    second = current;
            }

            // 제일 큰수와 두번째 큰수가 같다면 리스트가 2개 이하거나 같은 숫자의 반복으로 판단
            if(max == second) {
                return NOT_EXIST_MESSAGE;
            }
            // 인자가 2개일때 max, second를 바로 넣기때문에 2개의 인자만 받았을때라고 판단하고
            else if(max < second) {
                return Integer.toString(max);
            }
            // 두번째로 큰수 리턴
            else {
                return Integer.toString(second);
            }
        } catch (Exception e) {
            // max / second 에 넣을때 값이 없거나 짧은 배열일때 바로 메시지 전달
            return NOT_EXIST_MESSAGE;
        }
    }

    public void showResult(String result) {
        System.out.println(result);
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String[] numbers = in.nextLine().split(" ");

        SecondLargest secondLargest = new SecondLargest();

        // 결과값 받아옴
        String result = secondLargest.findSecondLargest(numbers);

        // 결과값 Ouput 표시
        secondLargest.showResult(result);

    }
}
