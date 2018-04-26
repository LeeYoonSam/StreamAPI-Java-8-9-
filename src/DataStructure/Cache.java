package DataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;


class LRUCache<K,V> {

    private LinkedHashMap<K, V> LRU_CACHE;

    public LRUCache(int maxSize) {
        LRU_CACHE = new LinkedHashMap<K, V>();

//        LRU_CACHE = new LinkedHashMap<K, V>(maxSize, 0.75f, true) {
//            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
//                return size() > maxSize;
//            }
//        };
    }

    public synchronized  final V add(K key, V value) {
        if(key == null || value == null) {
            throw new NullPointerException("key == null || value == null");
        }

        V previous = LRU_CACHE.put(key, value);


        return previous;
    } // 자료구조에 key, value에 해당하는 항목을 추가한다.

    public synchronized final V get(K key) {
        if(key == null) {
            return (V) "-1";
        }

        V previous = LRU_CACHE.get(key);
        if(previous != null)
            return previous;

        if(previous != null) {
            LRU_CACHE.put(key, previous);
        }

        return (V) "-1";
    }

    public V remove(K key) {
        if(key == null) {
            return (V) "-1";
        }

        V item = LRU_CACHE.remove(key);

        return item;
    } // key에 해당하는 항목을 찾아 그 value를 반환하고 항목을 자료구조에서 제거. 항목이 없는 경우 Exception

    public void evict() {

        // 마지막 아이템 추출
        Map.Entry<K, V> toEvict = LRU_CACHE.entrySet().iterator().next();

        if(toEvict == null) {
            return;
        }

        K key = toEvict.getKey();

        LRU_CACHE.remove(key);

    } // add나 get된지 오래된 항목을 자료구조에서 제거
}

public class Cache {

    final static String CMD_EVICT = "evict";
    final static String CMD_ADD = "add";
    final static String CMD_GET = "get";
    final static String CMD_REMOVE = "remove";
    final static String CMD_EXIT = "exit";

    public static void main(String[]args) throws Exception {

        LRUCache<String, String> cache = new LRUCache<>(5);
        cache.add("1","2");
        cache.add("2","4");
        cache.get("2");
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while (true) {
            String input = br.readLine();
            String[] cmd = input.split(" ");

            switch (cmd[0]) {
                case CMD_EVICT:
                    cache.evict();
                    break;

                case CMD_ADD:
                    System.out.println("cmd[2]: " + cmd[2]);
                    cache.add(cmd[1], cmd[2]);
                    break;

                case CMD_GET:
                    cache.get(cmd[1]);
                    System.out.println("cmd[1]: " + cmd[1]);
                    break;

                case CMD_REMOVE:
                    cache.remove(cmd[1]);
                    break;

                case CMD_EXIT:
                    return;
            }

        }

    }

    /*

    입력
입력의 각 줄은 자료구조를 조작하는 명령을 나타낸다.  각 명령에 파라메터가 있는 경우 명령어 뒤에 공백으로 구분하여 파라메터가 전달 된다.  (정의 되지 않은 명령어가 입력 되면 무시하고 새로운 명령을 입력 받는다.)

evict : 위에 설명된 evict operation을 수행한다.
add : 위에 설명된 add operation을 수행한다. 인자의 첫번째는 key, 두번째는 value를 나타낸다.
get : 첫번째 인자의 값을 key로 사용하여 위에 설명된 get operation을 수행한다. 획득한 결과를 출력한다. 항목이 없거나 예외가 발생 되는 경우 '-1'을 출력 한다.
remove :  첫번째 인자의 값을 key로 사용해서 remove operation을 수행한다. 획득한 결과를 출력한다. 항목이 없거나 예외가 발생 되는 경우 '-1'을 출력 한다.
exit : 더 이상 새로운 입력을 받지 않고 결과를 출력 하고 종료한다.
아래와 같은 형태로 입력 값이 전달 될 수 있다.

add 5 3
add 1 2
get 5
evict
get 1
remove 5
exit
출력
명령어 처리 결과를 출력한다. 결과의 한줄에 하나의 명령의 처리 결과가 표현 된다.
위의 입력 예제에서는 아래와 같은 결과가 출력 될 수 있다.

3
-1
3


     */





}
