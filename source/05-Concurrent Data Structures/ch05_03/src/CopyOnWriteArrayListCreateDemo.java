import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListCreateDemo {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Sam", "John", "Bob");
        CopyOnWriteArrayList<String> copyOnWriteList = new CopyOnWriteArrayList<>(list);

        System.out.println("Before modifying: " + copyOnWriteList);

        Iterator<String> iterator1 = copyOnWriteList.iterator();

        // Modify list
        copyOnWriteList.add("Pat");
        System.out.println("After modifying: " + copyOnWriteList);

        Iterator<String> iterator2 = copyOnWriteList.iterator();

        System.out.println("Elements from Iterator1 :");
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }

        System.out.println("Elements from Iterator2 :");
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }
    }
}
