import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class FailFastDemo {
    private List<String> list = new ArrayList<>();

    public FailFastDemo() {
        list.add("Sam");
        list.add("John");
        list.add("Bob");
        list.add("Pat");
    }

    public void iterateList() {
        Thread thread1 = new Thread(()-> {
            ListIterator<String> iterator = list.listIterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        });

        thread1.start();
    }

    public void modifyList() {
        Thread thread2 = new Thread(()-> {
            for(int i = 0; i < list.size(); i++) {
                if(i == 2)
                    list.remove(i);
            }
        });

        thread2.start();
    }

    public static void main(String[] args) {
        FailFastDemo demo = new FailFastDemo();

        demo.iterateList();
        demo.modifyList();
    }
}
