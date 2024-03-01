import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapCreateDemo {
    public static void main(String[] args) {
        /*
        Creates a new empty map with a default capacity of 16
        i.e. the internal HashTable size is 16 segments.
        a default load factor 0.75 and a concurrency level of 16.
         */
        ConcurrentHashMap<Integer, String> productMap1 = new ConcurrentHashMap<>();
        /*
        Crates a new empty map with the specified capacity
        i.e. table size accommodating the specified number of segments
        without the need to dynamically resize,
        the default load factor and a concurrency level of 16.
         */

        ConcurrentHashMap<Integer, String> productMap2 = new ConcurrentHashMap<>(10);

        /*
         Creates a new empty map with the specified capacity and specified load factor.
         and has a default concurrency level of 16.
        */

        ConcurrentHashMap<Integer, String> productMap3 = new ConcurrentHashMap<>(10, 0.85f);

        /*
        Creates a new empty map with the specified capacity, load Factor,
        and concurrency level - and number of concurrently updating threads
         */

        ConcurrentHashMap<Integer, String> productMap4 =
                new ConcurrentHashMap<>(10, 0.85f, 10);
    }
}
