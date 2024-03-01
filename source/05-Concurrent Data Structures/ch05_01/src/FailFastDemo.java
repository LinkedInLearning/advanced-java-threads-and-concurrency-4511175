import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class FailFastDemo {
    private List<Integer> list = new ArrayList<>();

    public FailFastDemo() {
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }
    }

    public void iterateList() {
        Thread thread1 = new Thread(()-> {
            ListIterator<Integer> iterator = list.listIterator();
            while (iterator.hasNext()) {
                Integer number = iterator.next();
                System.out.println(number);
            }
        });

        thread1.start();
    }

    public void modifyList() {
        Thread thread2 = new Thread(()-> {
                for (int i = 1000; i < 2000; i++) {
                    list.add(i);
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
