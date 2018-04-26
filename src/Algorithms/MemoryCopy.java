package Algorithms;

import java.util.Scanner;

import static java.lang.System.arraycopy;

public class MemoryCopy {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int v[] = new int[n];

        for(int i = 0; i < n; i ++) {
            v[i] = in.nextInt();
        }

        int dest = in.nextInt();
        int src = in.nextInt();
        int size = in.nextInt();

        memcpy(v, dest, src, size);

//        memcpy(v, 50, 0, -1); // may throw RuntimeException or do nothing
//        memcpy(v, 10, 20, 512);
//        memcpy(v, 20, 10, 512);
//        memcpy(v, 50, 0, 0); // may throw RuntimeException or do nothing
//        memcpy(v, 50, 0, 1);​

    }

    static void memcpy(int[] v, int dest, int src, int size) {

        if(size < 1) {
            for(int i = 0; i < v.length; i ++ ) {
                System.out.print(v[i] + " ");
            }
            System.out.println();
            throw new RuntimeException();
        }


        arraycopy(v, src, v, dest, size);

        for(int i = 0; i < v.length; i ++ ) {
            System.out.print(v[i] + " ");
        }

    }
}
