package Algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 문제의 입력값은 각 언어의 표준입력(stdin) 함수를, 출력값은 표준출력(stdout) 함수를 사용해주세요.

 [ 양의 정수를 입력 받고 그 수의 약수를 모두 출력하는 프로그램을 작성하십시오. ]

 # 입력
 양의 정수

 # 출력
 입력된 수의 약수를 공백으로 구분하여 출력



 입/출력 예시
 ⋇ 입출력 형식을 잘 지켜주세요.
 ␣ : 공백↵ : 줄바꿈

 보기 입력 1
 > 20
 출력 1
 > 1 2 4 5 10 20

 보기 입력 2
 > 100
 출력 2
 > 1 2 4 5 10 20 25 50 100


 */
public class AliquotTest {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();


        // 소인수분해 구한 후 정렬하기 위해 리스트 사용
        List<Integer> aliquotList = new ArrayList<>();

        /**
         * 소인수 분해 사용
         * 정확하게 나오려면 리스트에 담아서 정렬까지 해야함
         */

        System.out.println("소인수분해 사용");

        // 1은 무조건 출력
//        System.out.print(1 + " ");

        aliquotList.add(1);
        aliquotList.add(input);

        // 소인수 분해 이용
        for (int division = 2; division * division <= input; ++division) {

            // 입력 받은 값을 2부터 시작해서 1씩 증가시키며 나눠서 0이 나올때를 찾는다.
            if (input % division == 0) {

                // 나눠서 0이되는 값 찾아서 출력
                int temp = input/division;
//                System.out.print(division + " ");
                aliquotList.add(division);

                //  남아있는 값고 나눈 값이 다르면 출력
                if (temp != division) {
//                    System.out.print(temp + " ");
                    aliquotList.add(temp);
                }
            }
        }

        // 스트림을 사용해서 오름차순 정렬 / joining을 사용해서 아이템사이에 공백 추가
        String result = aliquotList.stream().sorted().map(num -> String.valueOf(num)).collect(Collectors.joining(" "));
        System.out.println(result);

        // 마지막에 입력받은 수 출력
//        System.out.print(input);

        // 스트림대신 콜렉션으로 정렬 후 for in문으로 출력하기
//        Collections.sort(aliquotList);
//        for(int num: aliquotList) {
//            System.out.print(num + " ");
//        }


        /**
         * 일반적인 for 문 사용
         */
        System.out.println("\n일반적인 포문 사용");

        // 1은 무조건 출력
        System.out.print(1 + " ");

        for(int i = 2; i < input; i ++) {
            if(input % i == 0) {
                System.out.print(i + " ");
            }
        }

        // 마지막에 입력받은 수 출력
        System.out.print(input);
    }
}
