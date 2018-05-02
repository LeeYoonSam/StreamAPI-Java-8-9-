package DesignPattern.SingletonPattern;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingletonTest {

    public static void main(String[] args) throws InterruptedException {
        // ExecutorService 인터페이스 구현객체 Executors 정적메서드를 통해 최대 스레드 개수가 2인 스레드 풀 생성
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Singleton singleton = Singleton.getInstance();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                singleton.plusStart(100);

                System.out.println(singleton.getStart());
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                singleton.plusStart(200);

                System.out.println(singleton.getStart());
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                singleton.plusStart(300);

                System.out.println(singleton.getStart());
            }
        });

        // ExecutorService를 활용한 쓰레드풀
        executorService.execute(thread3);
        executorService.execute(thread);
        executorService.execute(thread2);

        executorService.shutdown();


//        thread.start();
//        thread2.start();
//        thread3.start();

        Thread.sleep(1000);
        System.out.println("Last: " + singleton.getStart());
    }

    static class Singleton {

        private int start = 0;

        public static Singleton getInstance() {
            return LazyHolder.INSTANCE;
        }

        private static class LazyHolder {
            private static final Singleton INSTANCE = new Singleton();
        }

        private void plusStart(int num) {
            start = num;
        }

        private int getStart() {
            return start;
        }
    }
}
