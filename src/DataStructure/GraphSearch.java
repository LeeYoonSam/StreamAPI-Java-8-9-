package DataStructure;

import java.util.LinkedList;
import java.util.Stack;


class Graph {
    class Node {
        int data;
        // 각 노드를 연결하기 위해 LinkedList 사용
        LinkedList<Node> adjacent;
        boolean marked;

        Node(int data) {
            this.data = data;
            this.marked = false;
            adjacent = new LinkedList<>();
        }
    }

    Node[] nodes;
    Graph(int size) {
        nodes = new Node[size];

        for(int i = 0; i < size; i ++) {
            nodes[i] = new Node(i);
        }
    }

    void addEdge(int i1, int i2) {
        Node n1 = nodes[i1];
        Node n2 = nodes[i2];

        if(!n1.adjacent.contains(n2)) {
            n1.adjacent.add(n2);
        }

        if(!n2.adjacent.contains(n1)) {
            n2.adjacent.add(n1);
        }
    }

    void dfs() {
        dfs(0);
    }

    /**
     * DFS(Depth First Search) - 깊이 우선 검색 알고리즘(Stack 사용)
     */
    void dfs(int index) {
        // 제일 처음 호출된 Root Node 꺼내서 스택에 푸시
        Node root = nodes[index];
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        // 스택에 쌓인 아이템은 마크
        root.marked = true;

        // 스택이 비어있을때까지 실행
        while(!stack.isEmpty()) {

            // 스택에서 노드를 꺼낸다
            Node r = stack.pop();

            // 스택에서 꺼낸 노드의 인접노드를 반복한다.
            for (Node n: r.adjacent) {
                // 스택에 담긴적이 없는 노드일때 스택에 쌓기
                if(!n.marked) {
                    n.marked = true;
                    stack.push(n);
                }
            }

            // 노드에 연결된 노드가 스택에 다쌓이면 visit로 처리(다시 스택에 쌓일수 없음)
            visit(r);

        }
    }

    /**
     * DFS Recursion(깊이우선검색 - 재귀방법)
     */
    void dfsR(Node r) {
        if(r == null) return;

        // 먼저 마크하고 visit 처리
        r.marked = true;
        visit(r);

        // 현재 노드의 인접 노드를 반복
        for(Node node: r.adjacent) {

            // marked 안된 노드 재귀호출
            if(!node.marked)
                dfsR(node);
        }
    }

    void dfsR(int index) {
        dfsR(nodes[index]);
    }

    void dfsR() {
        dfsR(0);
    }

    void visit(Node r) {
        System.out.print(r.data + " ");
    }
}

public class GraphSearch {
    public static void main(String[] args) {

        Graph graphDfs = new Graph(7);
        graphDfs.addEdge(0, 1);
        graphDfs.addEdge(0, 2);
        graphDfs.addEdge(1, 3);
        graphDfs.addEdge(2, 4);
        graphDfs.addEdge(2, 5);
        graphDfs.addEdge(4, 5);
        graphDfs.addEdge(4, 6);
        graphDfs.dfs();

        System.out.println();

        Graph graphRecursion = new Graph(7);
        graphRecursion.addEdge(0, 1);
        graphRecursion.addEdge(0, 2);
        graphRecursion.addEdge(1, 3);
        graphRecursion.addEdge(2, 4);
        graphRecursion.addEdge(2, 5);
        graphRecursion.addEdge(4, 5);
        graphRecursion.addEdge(4, 6);
        graphRecursion.dfsR();
    }
}
