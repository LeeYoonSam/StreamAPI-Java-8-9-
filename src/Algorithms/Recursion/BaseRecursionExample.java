package Algorithms.Recursion;

/**
 * Resucrsion(재귀함수)
 *
 * 자기 자신을 호출하는 함수
 */
public class BaseRecursionExample {
    public static void main(String[] args) {

        System.out.println("[ Base Recursion ]");
        func2(3);

        System.out.println("[ Factorial ]");
        System.out.println(factorial(4));

        System.out.println("[ Fibonacci ]");
        System.out.println(fibonacci(10));

        System.out.println("[ Euclid Method ]");
        System.out.println(gcd(10, 10));
        System.out.println(gcdSimple(10, 10));

    }

    // 무한 호출
    public static void func() {
        System.out.println("Hello..");
        func();
    }

    public static void func2(int k) {
        if(k <= 0)
            return;
        else {
            System.out.println("Hello..");
            func2(k -1);
        }
    }

    // 팩토리얼
    public static int factorial(int n) {
        if(n == 0)
            return 1;
        else
            return n * factorial(n - 1);
    }

    // 피보나치
    public static int fibonacci(int n) {
        if(n < 2)
            return n;
        else
            return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // 최대 공약수
    public static int gcd(int m, int n) {
        if (m < n) {
            int tmp = m; m = n; n = tmp;    // swap m and n
        }

        if(m % n == 0)
            return n;
        else
            return gcd(n, m%n);
    }

    // 최대 공약수
    public static int gcdSimple(int m, int n) {
        if (m == 0)
            return n;
        else
            return gcdSimple(m, m % n);
    }
}
