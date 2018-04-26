package DataStructure;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

/**
 * 우선순위 큐(PriorityQueue)
 *
 * [ 최소값/최대값 찾기 최적화 ]
 *
 * 일반적으로 Queue라는 자료구조는 '선입선출'(First-In, First-Out)의 대기열 규칙(queuing discipline)을 가지고 있다.
 * 말그대로 먼저들어온 놈이 먼저 나간다는 것이다.
 * 하지만 JAVA에서 제공하는 'PriorityQueue'는 우선순위를 결정하여 들어온 순서와 상관없이 그 우선순위가 높은 엘리먼트가 나가게 된다.
 */
public class FindMaxMinPriorityQueue {
    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue();
        IntStream.range(1, 100).map(it -> (int) (it * (Math.random() * 10 + 1))).peek(it -> System.out.print(it + " ")).forEach(it -> priorityQueue.offer((it)));
        System.out.println();
        System.out.println("최소값: " + priorityQueue.poll());
        System.out.println("최소값: " + priorityQueue.poll());
        System.out.println("최소값: " + priorityQueue.poll());


        PriorityQueue reversePriorityQueue = new PriorityQueue(Collections.reverseOrder());
        IntStream.range(1, 100).map(it -> (int) (it * (Math.random() * 10 + 1))).peek(it -> System.out.print(it + " ")).forEach(it -> reversePriorityQueue.offer((it)));
        System.out.println();
        System.out.println("최대값: " + reversePriorityQueue.poll());
        System.out.println("최대값: " + reversePriorityQueue.poll());
        System.out.println("최대값: " + reversePriorityQueue.poll());
    }
}
