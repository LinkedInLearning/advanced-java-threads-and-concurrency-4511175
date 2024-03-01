import java.util.concurrent.*;

public class ExecutorDemoOne {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService.execute(new Runnable() {
            public void run() {
                String threadName = Thread.currentThread().getName();
                System.out.println(threadName + " executing the task");
            }
        });

        executorService.shutdown();
    }
}
