import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class VirtualThreadPerformance2 {
    public static void main(String[] args) throws InterruptedException {

        Runnable blockingTask = () -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("This is a blocking task");
        };

        long startTime = System.nanoTime();

//        try (ExecutorService executor = Executors.newFixedThreadPool(100)) {
//            for(int i = 0; i < 10_000; i++) {
//                executor.submit(blockingTask);
//            }
//        }

        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for(int i = 0; i < 10_000; i++) {
                executor.submit(blockingTask);
            }
        }

        long elapsedTime = System.nanoTime() - startTime;
        System.out.println("Total elapsed time : " + (elapsedTime/1000000)/1000 + " seconds");

    }
}
