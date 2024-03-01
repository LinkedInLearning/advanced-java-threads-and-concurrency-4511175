import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapUseDemo {

    ConcurrentHashMap<Integer, String> productMap = new ConcurrentHashMap<>();

    public ConcurrentHashMapUseDemo() {
        productMap.put(100,"TV");
        productMap.put(101,"Laptop");
        productMap.put(102,"Blender");
        productMap.put(103,"Cooker");
    }

    public void iterateMap() {
        Thread thread1 = new Thread(()-> {
            Iterator<Integer> iterator = productMap.keySet().iterator();
            while (iterator.hasNext()) {
                System.out.println(productMap.get(iterator.next()));
            }
        });

        thread1.start();
        System.out.println();
    }

    public void modifyMap() {
        Thread thread2 = new Thread(()-> {
            for(int key : productMap.keySet()) {
                if(key == 102)
                    productMap.remove(key);
            }
        });

        thread2.start();
    }


    public static void main(String[] args) {
        ConcurrentHashMapUseDemo demo = new ConcurrentHashMapUseDemo();
        demo.iterateMap();
        demo.modifyMap();
        demo.iterateMap();
    }
}
