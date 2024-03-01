import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutureDemo3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Combining two independent features

        // Retrieve number of points from a remote database call
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Accessing customer loyalty points data over the network...");
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 200;
        }).thenCombine(CompletableFuture.supplyAsync(() -> {
            // Calculate points based on day
            LocalDate today = LocalDate.now();
            DayOfWeek dayOfWeek = today.getDayOfWeek();
            if(dayOfWeek.equals(DayOfWeek.WEDNESDAY)) {
                return 5;
            } else if(dayOfWeek.equals(DayOfWeek.SATURDAY) || dayOfWeek.equals(DayOfWeek.SUNDAY)) {
                return 10;
            }
            return 0;
           }), (res1, res2) -> res1 + res2);


        System.out.println("Total points " + future.get());
    }
}
