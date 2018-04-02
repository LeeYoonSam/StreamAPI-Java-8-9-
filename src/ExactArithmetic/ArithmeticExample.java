package ExactArithmetic;

public class ArithmeticExample {

    public static void main(String[] args) {

        System.out.println("[ (add|substract|multiply|increment|decrement|negate)Exact methods ]");
//        exactMultiply();
//        exactAdd();
        System.out.println("-------------------------------");

        System.out.println("[ floorMod and floorDiv methods ]");
        exactFloorModDiv();
        System.out.println("-------------------------------");

        System.out.println("[ toIntExact method ]");
        exactToInt();
        System.out.println("-------------------------------");

        System.out.println("[ nextDown method ]");
        exactNextDown();
        System.out.println("-------------------------------");
    }

    public static void exactMultiply() {
        // 일반적인 곱하기 - 틀린 답 표시
        System.out.println(100000 * 100000);

        // multiplyExact 사용 - integer 최대값 초가 에러 발생
        System.out.println(Math.multiplyExact(100000, 100000));
    }

    public static void exactAdd() {

        // 일반적인 더하기 - 틀린 답 표시
        System.out.println( Integer.MAX_VALUE + Integer.MAX_VALUE );

        // addExact 사용 - integer 최대값 초가 에러 발생
        System.out.println(Math.addExact( Integer.MAX_VALUE, Integer.MAX_VALUE ));
    }

    // 나머지, 나누기 예제
    public static void exactFloorModDiv() {
        System.out.println("-------- 음수일때 정확하지 않음 -------");
        System.out.println( 10 % 2);
        System.out.println( 11 % 2);
        System.out.println( -15 % 2);
        System.out.println( -16 % 2);

        System.out.println("\n-------- floorMod로 정확하게 표시 -------");
        System.out.println(Math.floorMod(10, 2));
        System.out.println(Math.floorMod(11, 2));
        System.out.println(Math.floorMod(-15, 2));
        System.out.println(Math.floorMod(-16, 2));

        System.out.println("\n-------- 음수일때 정확하지 않음 -------");
        System.out.println( (10+3) % 12 );
        System.out.println( (5+6) % 12 );
        System.out.println( (10-27) % 12 );

        System.out.println("\n-------- floorMod로 정확하게 표시 -------");
        System.out.println(Math.floorMod(10+3, 12));
        System.out.println(Math.floorMod(5+6, 12));
        System.out.println(Math.floorMod(10-27, 12));
    }

    public static void exactToInt() {
        System.out.println( Long.MAX_VALUE );
        System.out.println( (int)Long.MAX_VALUE );
        System.out.println( Math.toIntExact(10_00_00_000) );
//        System.out.println( Math.toIntExact(Long.MAX_VALUE) );  // integer overflow
    }

    /**
     * Math.nextUp()은 Java6 이후에 이미 존재
     * Math.netDown()만 Java8에 추가 되었다.
     */
    public static void exactNextDown() {
        System.out.println(Math.nextDown(100));
        System.out.println(Math.nextDown(100.365));
    }
}
