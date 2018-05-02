package Algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * 정수 n이 주어지면, n개의 여는 괄호 "("와 n개의 단는 괄호")"로 만들 수 있는 괄호 조합을 모두 구하시오.(시간 복잡도 제한 없음)
 *
 * input: 1
 * output: ["()"]
 *
 * input: 2
 * output: ["(())", "()()"]
 *
 * input: 3
 * output: ["((()))", "(())()", "()(())", "(()())", "()()()"]
 *
 * 주로 조합을 구하거나 답의 양이 많을 경우는 재귀함수를 사용하면 된다.
 * empty string 부터 시작하여 "("를 더하고 재귀함수를 부르고, ")"를 더하고 재귀함수를 부르면 된다.
 * 중요한건 현재 몇개의 여는 괄호를 사용했는지, 몇개의 닫는 괄호를 사용했는지 알아야 한다.
 * 재귀함수에 주어진 문자열이 (n*2) 길이를 가진다면 알맞는 괄호 조합이니 리스트에 추가
 * ex) input 2: 2*2 = 4 -> (()),()() 두 가지 경우 모두 4개의 괄호 조합이다. 여닫는 괄호() 1세트당 length가 2이니 *2로 계산
 *
 */
public class ParenthesisPairsTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        List<java.lang.String> ans = parenthesisPairs(input);
        System.out.println(ans);
    }

    public static List<String> parenthesisPairs(int n) {
        List<java.lang.String> ans = new ArrayList<>();
        recurse(ans, "", 0, 0, n);
        return ans;
    }

    public static void recurse(List<String> ans, String cur, int open, int close, int n) {
        if(cur.length() == n * 2) {
            ans.add(cur);
            return;
        }

        if(open < n) {
            recurse(ans, cur + "(", open + 1, close, n);
        }

        if(close < open) {
            recurse(ans, cur + ")", open, close + 1, n);
        }
    }
}
