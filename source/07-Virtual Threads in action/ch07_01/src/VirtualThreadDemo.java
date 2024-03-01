import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class VirtualThreadDemo {
    public static void main(String[] args) throws InterruptedException {

        Runnable task = () -> System.out.printf("Thread  "  + Thread.currentThread());

        Thread t1 = Thread.startVirtualThread(task);
        t1.join();

        System.out.println();

        Thread t2 = Thread.ofVirtual().unstarted(task);
        t2.start();
        t2.join();

        System.out.println();

        Runnable task2 = () -> System.out.println(Thread.currentThread().getName() + " created from builder is running a task");

        Thread.Builder builder = Thread.ofVirtual().name("Virtual Thread", 1);

        Thread builderT1 = builder.start(task2);
        Thread builderT2 = builder.start(task2);
        Thread builderT3 = builder.start(task2);
        Thread builderT4 = builder.start(task2);

        builderT1.join();
        builderT2.join();
        builderT3.join();
        builderT4.join();

        try (ExecutorService myExecutor = Executors.newVirtualThreadPerTaskExecutor()) {
            for(int i = 0; i < 100; i++) {
                Future<?> future = myExecutor.submit(() -> System.out.println("Running task"));
                future.get();
            }
            System.out.println("All tasks completed");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
