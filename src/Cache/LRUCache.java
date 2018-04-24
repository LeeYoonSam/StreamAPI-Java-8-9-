package Cache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> {
    private final LinkedHashMap<K, V> map;

    private int size;
    private int maxSize;
    private int putCount;
    private int createCount;
    private int evictionCount;
    private int hitCount;
    private int missCount;

    public LRUCache(int maxSize) {
        if (maxSize <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.maxSize = maxSize;
        this.map = new LinkedHashMap<>(0, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > maxSize;
            }
        };
    }

    public synchronized final V get(K key) {
        if(key == null) {
            throw new NullPointerException("key == null");
        }

        V result = map.get(key);

        // 키에 해당하는 값을 찾음
        if(result != null) {
            hitCount ++;
            return result;
        }

        // 키에 해당하는 값이 없으면 미스 추가
        missCount ++;

        result = create(key);

        if(result != null) {
            createCount ++;

            size += safeSizeOf(key, result);
            map.put(key, result);
            trimToSize(maxSize);
        }

        return result;
    }

    public synchronized  final V put(K key, V value) {
        if(key == null || value == null) {
            throw new NullPointerException("key == null || value == null");
        }

        putCount ++;

        size += safeSizeOf(key, value);
        V previous = map.put(key, value);
        if(previous != null) {
            size -= safeSizeOf(key, previous);
        }

        trimToSize(maxSize);
        return previous;
    }

    private void trimToSize(int maxSize) {
        while(size > maxSize && !map.isEmpty()) {
            // 마지막 아이템 추출
            Map.Entry<K, V> toEvict = map.entrySet().iterator().next();

            if(toEvict == null) {
                break;
            }

            K key = toEvict.getKey();
            V value = toEvict.getValue();

            map.remove(key);
            size -= safeSizeOf(key, value);
            evictionCount ++;

            entryEvicted(key, value);

        }
    }

    public final V remove(K key) {
        if(key == null) {
            throw new NullPointerException("key == null");
        }

        V previous = map.remove(key);
        if (previous != null) {
            size -= safeSizeOf(key, previous);
        }

        return previous;
    }

    private int safeSizeOf(K key, V value) {
        int result = sizeOf(key, value);

        if(result < 0) {
            throw new IllegalStateException("Negative size: " + key + "=" + value);
        }

        return result;
    }
    protected void entryEvicted(K key, V value) {}

    protected V create(K key) {
        return null;
    }

    protected int sizeOf(K key, V value) {
        return 1;
    }

    public synchronized  final void evictAll() {
        trimToSize(-1);
    }

    public synchronized  final int size() {
        return size;
    }

    public synchronized final int smaxSze() {
        return maxSize;
    }

    public synchronized final int hitCount() {
        return hitCount;
    }
    /**
     * Returns the number of times {@link #get} returned null or required a new
     * value to be created.
     */
    public synchronized final int missCount() {
        return missCount;
    }
    /**
     * Returns the number of times {@link #create(Object)} returned a value.
     */
    public synchronized final int createCount() {
        return createCount;
    }
    /**
     * Returns the number of times {@link #put} was called.
     */
    public synchronized final int putCount() {
        return putCount;
    }
    /**
     * Returns the number of values that have been evicted.
     */
    public synchronized final int evictionCount() {
        return evictionCount;
    }
    /**
     * Returns a copy of the current contents of the cache, ordered from least
     * recently accessed to most recently accessed.
     */
    public synchronized final Map<K, V> snapshot() {
        return new LinkedHashMap<>(map);
    }
    @Override public synchronized final String toString() {
        int accesses = hitCount + missCount;
        int hitPercent = accesses != 0 ? (100 * hitCount / accesses) : 0;
        return String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]",
                maxSize, hitCount, missCount, hitPercent);
    }
}
