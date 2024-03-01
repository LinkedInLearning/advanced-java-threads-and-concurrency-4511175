import java.time.LocalDateTime;
import java.util.concurrent.*;

public class ScheduledExecutorServiceDemo1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

        Runnable task = () -> {
            System.out.println("Executing Task 1 at " + LocalDateTime.now());
        };

        ScheduledFuture<?> future = scheduledExecutorService.schedule(task, 5, TimeUnit.SECONDS);

        System.out.println(future.get());

        scheduledExecutorService.shutdown();


    }
}
