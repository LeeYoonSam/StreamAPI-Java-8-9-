package Algorithms;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/arrays-ds/problem
 *
 An array is a type of data structure that stores elements of the same type in a contiguous block of memory. In an array, , of size , each memory location has some unique index,  (where ), that can be referenced as  (you may also see it written as ).
 Given an array, , of  integers, print each element in reverse order as a single line of space-separated integers.
 Note: If you've already solved our C++ domain's Arrays Introduction challenge, you may want to skip this.

 */
public class ReverseIntArray {
    static int[] reverseArray(int[] a) {

        int[] result = new int[a.length];

        // 배열 자리 교체
        for(int i = 0; i < a.length; i ++) {
            result[i] = a[(a.length -1) - i];
        }

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int arrCount = Integer.parseInt(scanner.nextLine().trim());

        int[] arr = new int[arrCount];

        String[] arrItems = scanner.nextLine().split(" ");

        for (int arrItr = 0; arrItr < arrCount; arrItr++) {
            int arrItem = Integer.parseInt(arrItems[arrItr].trim());
            arr[arrItr] = arrItem;
        }

        Arrays.stream(reverseArray(arr)).forEach(it -> System.out.print(it + " "));
    }

}
