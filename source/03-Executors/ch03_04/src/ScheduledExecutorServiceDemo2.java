import java.time.LocalDateTime;
import java.util.concurrent.*;

public class ScheduledExecutorServiceDemo2 {
    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

        Runnable task1 = () -> {
            count++;
            System.out.println("Counting " + count + " at " + LocalDateTime.now());
        };

        ScheduledFuture<?> scheduledFuture = scheduledExecutorService.scheduleAtFixedRate(task1, 5, 1, TimeUnit.SECONDS);

        while (count != 5) {
            TimeUnit.MILLISECONDS.sleep(100);
        }

        System.out.println("Count is 5, cancel the scheduledFuture!");
        scheduledFuture.cancel(true);
        scheduledExecutorService.shutdown();

    }
}
