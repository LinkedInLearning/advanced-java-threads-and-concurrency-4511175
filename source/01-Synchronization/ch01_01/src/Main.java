public class Main {

    public static void main(String[] args) {

//        Step 1
//        MyRunnable myRunnable1 = new MyRunnable();
//        Thread thread1 = new Thread(myRunnable1, "Thread1");
//
//        MyRunnable myRunnable2 = new MyRunnable();
//        Thread thread2 = new Thread(myRunnable2, "Thread2");
//
//        thread1.start();
//        thread2.start();

//        Step 2
        MyRunnable myRunnable = new MyRunnable();
        Thread thread1 = new Thread(myRunnable, "Thread1");
        Thread thread2 = new Thread(myRunnable, "Thread2");

        thread1.start();
        thread2.start();

    }
}
