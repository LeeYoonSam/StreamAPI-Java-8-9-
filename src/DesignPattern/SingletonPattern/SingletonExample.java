package DesignPattern.SingletonPattern;

/**
 * LazyHolder
 *
 * 이 이디엄에 대해서 설명을 하자면 객체가 필요할 때로 초기화를 미루는 것이다.
 * Lazy Initialization이라고도 한다. Singleton 클래스에는 LazyHolder 클래스의 변수가 없기 때문에 Singleton 클래스 로딩 시 LazyHolder 클래스를 초기화하지 않는다.
 * LazyHolder 클래스는 Singleton 클래스의 getInstance() 메서드에서 LazyHolder.INSTANCE를 참조하는 순간 Class가 로딩되며 초기화가 진행된다.
 * Class를 로딩하고 초기화하는 시점은 thread-safe를 보장하기 때문에 volatile이나 synchronized 같은 키워드가 없어도 thread-safe 하면서 성능도 보장하는 아주 훌륭한 이디엄이라고 할 수 있다.
 * 현재까지 LazyHolder에 대해서 문제점은 나타나지 않고 있다.
 * 혹시나 Multi Thread 환경에서 Singleton을 고려하고 있다면 LazyHolder 기법을 이용하자.
 */
public class SingletonExample {
    public static SingletonExample getInstance() {
        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final SingletonExample INSTANCE = new SingletonExample();
    }

}
