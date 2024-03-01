import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListUseDemo {
    CopyOnWriteArrayList<String> copyOnWriteList = new CopyOnWriteArrayList<>();

    public CopyOnWriteArrayListUseDemo() {
        copyOnWriteList.add("Sam");
        copyOnWriteList.add("John");
        copyOnWriteList.add("Bob");
        copyOnWriteList.add("Pat");
    }

    public void iterateList() {
        Thread thread1 = new Thread(()-> {
            ListIterator<String> iterator = copyOnWriteList.listIterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        });

        thread1.start();
    }

    public void modifyList() {
        Thread thread2 = new Thread(()-> {
            for(int i = 0; i < copyOnWriteList.size(); i++) {
                if(i == 2)
                    copyOnWriteList.remove(i);
            }
        });

        thread2.start();
    }


    public static void main(String[] args) {
        CopyOnWriteArrayListUseDemo demo = new CopyOnWriteArrayListUseDemo();

        demo.iterateList();
        demo.modifyList();
        demo.iterateList();
    }

}
