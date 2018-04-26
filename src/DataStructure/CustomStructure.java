package DataStructure;


import java.util.*;

class QueueSupport<T> {

    // 최소값 계산용 우선순위 큐 사용
    PriorityQueue<T> priorityQueue = new PriorityQueue<>();

    // 기본적인 큐 구현
    class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node<T> first;
    private Node<T> last;

    public void push(T item) {

        // 우선순위큐 삽입
        priorityQueue.offer(item);

        // 노드 생성
        Node<T> t = new Node<>(item);

        // 마지막 노드 변경
        if(last != null) {
            last.next = t;
        }

        last = t;
        if(first == null) {
            first = last;
        }
    }

    public T shift() {
        if(first == null) {
            throw new NoSuchElementException();
        }

        T data = first.data;
        // 우선순위큐 같이 삭제
        priorityQueue.remove(data);

        first = first.next;

        if(first == null) {
            last = null;
        }

        return data;
    }

    public T peek() {
        if(first == null) {
            throw new NoSuchElementException();
        }

        return first.data;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public T min() {
        // 현재 큐에서 최소값 가져오기
        return priorityQueue.peek();

        // poll을 사용하니 아직 최소값이 shift 되지 않았는데 다음 최소값을 불러옴
//        return priorityQueue.poll();
    }

}


public class CustomStructure {
    public static void main(String[] args) {

        QueueSupport<Integer> q = new QueueSupport<Integer>();
        q.push(10);
        q.push(2);
        q.push(4);
        q.push(45);
        q.push(1);
        q.push(2);
        q.push(7);
        q.push(9);

        System.out.println("min: " + q.min());
        System.out.println(q.shift());
        System.out.println("min: " + q.min());
        System.out.println(q.shift());
        System.out.println("min: " + q.min());
        System.out.println(q.peek());
        System.out.println(q.shift());
        System.out.println(q.isEmpty());
        System.out.println(q.shift());
        System.out.println(q.isEmpty());
        System.out.println(q.peek());
        System.out.println(q.shift());
        System.out.println("min: " + q.min());
        System.out.println(q.shift());
        System.out.println("min: " + q.min());
        System.out.println(q.shift());
        System.out.println(q.shift());
        System.out.println(q.shift()); // first가 없을때 만들어놓은 NoSuchElementException 표시

    }
}
