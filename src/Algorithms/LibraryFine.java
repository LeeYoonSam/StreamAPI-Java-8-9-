package Algorithms;

import java.util.Scanner;

public class LibraryFine {
    final static int YEAR_OF_LIBRARY_FEE = 10000;
    final static int MONTH_OF_LIBRARY_FEE = 500;
    final static int DAY_OF_LIBRARY_FEE = 15;

    static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {

        int year;
        int month ;
        int day;

        if(y1 >= y2)
            year = (y1 - y2);
        else
            return 0;

        if(m1 >= m2)
            month = (m1 - m2);
        else {
            if(year > 0) {
                year --;
                month = (12 + m1) - m2;
            } else {
                return 0;
            }
        }

        if(d1 >= d2)
            day = (d1 - d2);
        else {
            if(month > 0) {
                month --;
                day = (31 + d1) - d2;
            } else {
                return 0;
            }
        }

        if(year > 0)
            return year * YEAR_OF_LIBRARY_FEE;
        else
            return  (month * MONTH_OF_LIBRARY_FEE) + (day * DAY_OF_LIBRARY_FEE);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int d1 = in.nextInt();
        int m1 = in.nextInt();
        int y1 = in.nextInt();
        int d2 = in.nextInt();
        int m2 = in.nextInt();
        int y2 = in.nextInt();
        int result = libraryFine(d1, m1, y1, d2, m2, y2);
        System.out.println(result);
        in.close();
    }

    /*
    2 7 1014
    1 1 1015

    6 6 2015
    9 6 2016
    */
}
