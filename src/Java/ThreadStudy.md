# Thread

## Locks and Conditions

* synchronized block(or method)

* monitor object
    * lock/unlock의 대상 개념
        * 모든 객체가 monitor가 될 수 있음

    * java.lang.Object의 wait, notify, notifyAll
        * lock을 획득한 monitor 객체에 대해 condition 기능 사용하는 API



## notify / notifiyAll



## Hotspot JVM에서 lock 구현

* 2-word object header(array인 경우는 3-word)

    * 1st word: mark word
        * used by sync and gc, caches hashCode
            * 2bit를 sync stat로 사용(monitor object)
                * 01 unlocked, 00 light-weight locked, 10 heavy-weight locked, 11 marked for GC

    * 2nd word: metadata word



## park/unpark 모델(JDK5)
* java.util.concurrent.locks.LockSupport
    * public static void park();
    * public static void unpark(Thread thread);



## Java Memory Model
* Atomicity
    * Java에서 long과 double을 제외한 모든 data field에 대한 update는 atomic
    * volatile로 선언되면 모든 field update가 atomic

* Visibillity
    * 한 쓰레드가 종료할 때에는 메모리에 flush가 되므로 Thread.join을 통해 기다리는 쓰레드는 해당 종료 쓰레드의 write를 모두 읽을 수 있다.

* Ordering
    * lock혹은 volatile을 제외하면 컴파일러에 의해 어떤 reodering도 가능(물론 같은 쓰레드 내에서는 동일한 효과가 있어야 함)


## Double-checked Locking
* 엄격해진 JVM의 volatile 정의로 DCL이 동작
    - 리오더링 문제

* Lazy Initialization Holder를 사용하면 volatile도 불필요(static field는 visibility가 보장)



## final field

* construct 보다 {}가 먼저 호출

### 클래스
* 상속 할 수 없음

### 메소드
* 오버로딩 할 수 없음

### 필드
* 변경 할 수 없음(상수랑은 조금 다른개념)


## ThreadLocal
- 쓰레드별 정보를 담기위해 사용하는것

* thread 객체에 threadLocals라는 ThreadLocalMap을 들고 있음
    * 별도의 Overhead는 없으며, access할 때에도 lock을 전혀 쓰지 않음
    * WeakReference를 쓰고 있어서 Momory 부족 현상이 있을 때 정보가 소실될 수 있음
        * WeakReference - 참조하는 곳이 없으면 메모리 해제

* InheritedThreadLocal
    * thread 객체에 inheritableThreadLocals라는 ThreadLocalMap을 들고 있다.
    * 생성할 때 parent thread의 inheritableThreadLocals 정보를 모두 복사하여 childe의 inherited thread local에 넣어줌


