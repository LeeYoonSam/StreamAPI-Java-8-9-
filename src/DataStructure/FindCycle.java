package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * n 개의 정점으로 이루어진 임의의 directed graph X가 주어졌을 때, 이 그래프 X 안에서 크기 m인 cycle 을 찾아 출력하는 프로그램을 작성하시오. 하나의 정점을 여러번 방문할 수 있다. cycle이 여러 개 있는 경우,
 * 그 중에서 아무거나 출력해도 좋다. method signature는 다음과 같다.
 *
 * void findCycle(boolean[][] graph, int m) {}
 *
 * cycle이 있는 경우 :
 * 첫 줄에 1을 출력하고, 다음 줄에 정점의 번호를 출력한다. i번째 정점에서 i+1번째 정점으로 이동 가능해야 하며, 마지막 정점에서 첫번째 정점으로 이동 가능해야 한다.
 *
 * 1
 * 0 3 2 6 5
 *
 * cycle이 없는 경우 : 0
 */



class GraphNode {

    Node[] nodes;

    GraphNode(int size) {
        nodes = new Node[size];

        for(int i = 0; i < size; i ++) {
            nodes[i] = new Node(i);
        }
    }

    class Node {
        int data;
        // 각 노드를 연결하기 위해 LinkedList 사용
        LinkedList<Node> adjacent;
        boolean marked;
        int markCount;

        Node(int data) {
            this.data = data;
            this.marked = false;
            adjacent = new LinkedList<>();
            markCount = 0;
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

                n.markCount ++;
            }
        }

        if(Arrays.stream(nodes).filter(node -> node.markCount > 1).count() < 1) {
            System.out.println("0");
        } else {
            System.out.println("1");
//            Arrays.stream(nodes).forEach(node ->  System.out.print(String.format("node: %s count: %s", node.data, node.markCount) + " | "));
//            System.out.println();
            Arrays.stream(nodes).filter(node -> node.markCount > 1).forEach(it -> System.out.print(it.data + " "));
        }
    }
}

public class FindCycle {
    /*
        Adjacency Matrix(인접 행렬) - 2차원 배열로 인접 관계 표시

                          |  0   1   2   3
                        ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
             0          0 |  0   1   1   1
           / | \        1 |  1   0   0   0
          1  |  2       2 |  1   0   0   1
             | /        3 |  1   0   1   0
             3
     */

    static void findCycle(boolean[][] graph, int m) {

        // 인접 행렬을 그래프로 변경
        GraphNode graphNode = new GraphNode(m);

        for(int i = 0; i < m; i ++) {
            for(int j = 0; j < m; j ++) {
                if(graph[i][j])
                    // 인접행렬 추가
                    graphNode.addEdge(i, j);
            }
        }

        // dfs 검색시작
        graphNode.dfs();
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(n);

        boolean adjacencyMatrix[][] = new boolean[n][n];

        String input;
        for(int i = 0; i < n; i ++) {
            input = br.readLine();

            for (int j = 0; j < input.length(); j++) {
                adjacencyMatrix[i][j] = Character.digit(input.charAt(j), 9) == 1? true: false;
            }
        }

        int cycleLen = Integer.parseInt(br.readLine());
        System.out.println(cycleLen);







//        Scanner in = new Scanner(System.in);
//
//
//        int n = 0;
//        if(in.hasNextInt()) {
//            n = in.nextInt();
//        }
//
//        boolean adjacencyMatrix[][] = new boolean[n][n];
//
//        for(int i = 0; i < n; i ++) {
//            for(int j = 0; j < n; j ++) {
//                if(in.hasNextInt()) {
//                    adjacencyMatrix[i][j] = in.nextInt() == 1? true: false;
//                }
//            }
//        }
//
//
//        int cycleLen = 0;
//        if(in.hasNextInt()) {
//            cycleLen = in.nextInt();
//        }
//
//        in.close();
//
////        boolean[][] adjacencyMatrix = new boolean[][] {
////                {false, true, true, true},
////                {true, false, false, false},
////                {true, false, false, true},
////                {true, false, true, false}  };
//
        findCycle(adjacencyMatrix, cycleLen);

    }

    /*
            4
            0111
            1000
            1000
            0010
            4
    이것은 아래와 같은 실행을 의도 하는 것이다.

    boolean[][] graph = {
            {false,true,true,true},
            {true,false,false,false},
            {true,false,false,false},
            {false,false,true,false}
    };
    findCycle(graph, 3);
    */
}


