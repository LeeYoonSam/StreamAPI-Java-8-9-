package DesignPattern.SingletonPattern;

public class SingletonTest {

    public static void main(String[] args) throws InterruptedException {
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

        Thread.sleep(1000);
        thread.start();
        thread2.start();
        thread3.start();

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
