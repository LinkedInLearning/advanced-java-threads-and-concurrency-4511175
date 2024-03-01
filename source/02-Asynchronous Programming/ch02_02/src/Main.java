import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        long startTime = System.nanoTime();
        Future<String> future1 = executorService.submit(new TimeConsumingTask());
        Future<String> future2 = executorService.submit(new OtherTask());

        while (!future1.isDone() && !future2.isDone()) {
            System.out.println("Reading and processing not yet finished.");
            // Simulating another task
            TimeUnit.SECONDS.sleep(1);
        }

        System.out.println(future1.get());
        System.out.println(future2.get());

        long elapsedTime = System.nanoTime() - startTime;
        System.out.println("Both tasks finished in " + (elapsedTime/1000000)/1000 + " seconds");

        executorService.shutdown();
    }
}
