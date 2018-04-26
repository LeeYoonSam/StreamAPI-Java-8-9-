package Algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**

 * Sample Input
1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 2 4 4 0
0 0 0 2 0 0
0 0 1 2 4 0

 * Sample Output
 19


 * Sample Input
 -1 -1 0 -9 -2 -2
 -2 -1 -6 -8 -2 -5
 -1 -1 -1 -2 -3 -4
 -1 -9 -2 -4 -4 -5
 -7 -3 -3 -2 -9 -9
 -1 -3 -1 -2 -4 -5

 * Sample Output
 -6

 */

public class Array2D_DS {


    public void set() {
        System.out.println("안녕하세요 ㅁㄴ어ㅏㅣㄹ먼이ㅏㅣㅇ너ㅣㅏ먼아ㅣ러ㅣㅏㅇ나바ㅣ버지ㅏ더ㅏ러나나나라암나어림;ㅔㅔㅔㅂㄷ''ㅠㅡ,.으ㅡ12323" +
                "2+966" +
                "32++-99851=====+==///***00432++--+-4879+-");
    }
    /*
     * 결과값을 List에 담았다가 min으로 최대값 가져오기
     */
    static int array2D(int[][] arr) {
        List<Integer> sumList = new ArrayList<>();

        for(int i = 0; i <= arr.length - 3; i ++) {

            for(int j = 0; j <= arr.length - 3; j ++) {
                int result = 0;

                for(int k = 0; k < 3; k++) {

                    if (k == 1) {
                        result += arr[i + k][j + 1];
                    } else {
                        result += arr[i + k][j + 0];
                        result += arr[i + k][j + 1];
                        result += arr[i + k][j + 2];
                    }
                }

                // 합계들을 List에 담음
                sumList.add(result);
            }
        }

        // Stream을 이용해서 max값 추출하기
        return sumList.stream().mapToInt(v -> v).max().orElseThrow(NoSuchElementException::new);
    }

    static int array2D2(int[][] arr) {
        // 첫번째 값은 비교없이 maxValue에 바로 넣기 위한 변수
        boolean isFirst = true;

        int maxValue = 0;

        // 배열을 3개씩 묶어서 처리하므로 전체길이를 다돌릴 필요 없이 전체에서 3만큼의 길이를 빼준다.
        for(int i = 0; i <= arr.length - 3; i ++) {

            // 세로도 마찬가지로 3만큼의 길이를 빼준다.
            for(int j = 0; j <= arr.length - 3; j ++) {
                int result = 0;

                // 모래시계 형태의 숫자만 더해주기 위해 3*3을 계산하되 가운데는 1번 인덱스만 넣음
                for(int k = 0; k < 3; k++) {

                    if (k == 1) {
                        result += arr[i + k][j + 1];
                    } else {
                        result += arr[i + k][j + 0];
                        result += arr[i + k][j + 1];
                        result += arr[i + k][j + 2];
                    }
                }

                // 0으로 초기화 하니 음수일때 비교 불가해서 처음으로 생성된 합계면 무조건 바로 넣는다.
                if(isFirst) {
                    maxValue = result;
                    isFirst = false;
                }

                // 새로운 sum 값이 크면 maxValue 교체
                if(maxValue < result)
                    maxValue = result;
            }
        }

        return maxValue;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int[][] arr = new int[6][6];

        for (int arrRowItr = 0; arrRowItr < 6; arrRowItr++) {
            String[] arrRowItems = scanner.nextLine().split(" ");

            for (int arrColumnItr = 0; arrColumnItr < 6; arrColumnItr++) {
                int arrItem = Integer.parseInt(arrRowItems[arrColumnItr].trim());
                arr[arrRowItr][arrColumnItr] = arrItem;
            }
        }

        int streamResult = array2D(arr);
        System.out.println("streamResult: " + streamResult);

        int result = array2D2(arr);
        System.out.println("variableResult: " + result);
    }
}