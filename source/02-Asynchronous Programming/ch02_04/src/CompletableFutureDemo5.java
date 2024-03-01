import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutureDemo5 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String customerCode = "";

        // Retrieve number of points from a remote database call
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            if(customerCode.isEmpty()) {
                throw new IllegalArgumentException("Customer code can not be empty");
            } else {
                System.out.println("Accessing customer loyalty points data over the network...");
                try {
                    TimeUnit.SECONDS.sleep(4);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return 200;
            }
        }).exceptionally(ex -> {
            System.out.println("There was an exception - " + ex.getMessage());
            return -1;
        });


        System.out.println("Total points " + future.get());

    }
}
