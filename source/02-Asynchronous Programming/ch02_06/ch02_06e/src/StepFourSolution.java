import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class StepFourSolution {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Step 04
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Calculating the sum of even numbers ...");
            int sum = 0;
            for(int i = 0; i < 10; i++) {
                if(i%2 == 0) {
                    sum += i;
                }
            }
            System.out.println("Finished calculating the sum of even numbers");
            return sum;
        }).thenCombine(CompletableFuture.supplyAsync(() -> {
            System.out.println("Calculating the sum of squares ...");
            int sum = 0;
            for(int i = 0; i < 10; i++) {
                int square = i * i;
                sum += square;
            }
            System.out.println("Finished calculating the sum of squares");
            return sum;
        }),(res1, res2) -> res1 + res2);

        System.out.println("Sum of even numbers + Sum of squares = " + future.get());
    }
}
