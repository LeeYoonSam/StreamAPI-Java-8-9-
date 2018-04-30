package DataStructure;

import java.util.LinkedList;

/**
 * https://www.youtube.com/watch?v=Vi0hauJemxA
 *
 * 해시함수로 해시코드를 생성하고 그 해시코드로 인덱스를 가져와서 값에 접근하는 자료구조
 * F(key) 해시함수 -> HashCode -> Index -> Value
 *
 * #블록체인에서 공공장부를 비교할때 해시테이블 사용
 *  - 모든 사용자의 모든 거래장부는 원본으로 비교하면 개인정보 노출 및 방대한양
 *  - 그정보를 해시코드로 만들어서 배포, 사람들은 해시코드만 비교
 *  - 속도가 빠름
 *
 * ** 좋은 해시알고리즘을 만드는것이 가장 큰 관건 **
 *
 * 장점 : 해시코드 자체가 배열의 인덱스를 사용해서 다이렉트로 접근할수 있어서 빠르다.
 * 단점 : Collision(충돌)
 *  - 해시함수의 알고리즘에 따라 공간효율 변화 해시알고리즘에 인덱스를 잘배분하는것이 좋은 알고리즘
 *  - 검색시간 O(1) 인데 하나의 인덱스에 몰리면 O(n)이 된다.
 *
 */

class HashTable {
    class Node {
        String key;
        String value;

        public Node(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    LinkedList<Node>[] datas;

    public HashTable(int size) {
        datas = new LinkedList[size];
    }

    // 해사일고리즘 해시코드 생성
    int getHashCode(String key) {
        int hashcode = 0;

        for (char c: key.toCharArray()) {
            hashcode += c;
        }

        return hashcode;
    }

    // 해시코드를 인덱스 번호로 변환
    int convertToIndex(int hashcode) {
        return hashcode % datas.length;
    }

    Node searchKey(LinkedList<Node> list, String key) {
        if(list == null) return null;

        for(Node node: list) {
            if( node.key.equals(key) ) {
                return node;
            }
        }

        return null;
    }

    void put(String key, String value) {
        // key에 맞는 해시코드 생성
        int hashcode = getHashCode(key);

        // 생성된 해시코드로 index 구하기
        int index = convertToIndex(hashcode);

        // 전체 링크드리스트 데이터에서 인덱스에 해당하는 리스트 가져옴
        LinkedList<Node> list = datas[index];

        // 리스트가 존재하지 않으면 초기화 하고 리스트를 넣어준다.
        if(list == null) {
            list = new LinkedList<>();
            datas[index] = list;
        }

        // 키에 해당하는 node 가져온다
        Node node = searchKey(list, key);

        // 노드가 없으면 생성된 list 마지막에 해당 키,값을 추가한다.
        if(node == null) {
            list.addLast(new Node(key, value));
        } else {
            // 기존에 존재하는 노드면 값만 변경해준다.
            node.setValue(value);
        }
    }

    String get(String key) {
        int hashcode = getHashCode(key);
        int index = convertToIndex(hashcode);
        LinkedList<Node> list = datas[index];
        Node node = searchKey(list, key);

        // 노드가 없으면 해당 인덱스 리스트에서는 데이터가 없음. 노드가 존재하면 값을 리턴
        return node == null ? "Not found" : node.value;
    }
}

public class HashTableExample {

    public static void main(String[] args) {
        HashTable hashTable = new HashTable(3);
        hashTable.put("sung", "She is pretty");
        hashTable.put("jin", "She is a model");
        hashTable.put("hee", "She is an angel");
        hashTable.put("min", "She is cute");

        // update
        hashTable.put("sung","She is beautiful");

        System.out.println(hashTable.get("sung"));
        System.out.println(hashTable.get("jin"));
        System.out.println(hashTable.get("hee"));
        System.out.println(hashTable.get("min"));

        // not found
        System.out.println(hashTable.get("jae"));
    }
}
