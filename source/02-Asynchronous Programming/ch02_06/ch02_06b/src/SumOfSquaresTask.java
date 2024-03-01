import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class SumOfSquaresTask implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("Calculating the sum of squares ...");
        int sum = 0;
        for(int i = 0; i < 10; i++) {
            int square = i * i;
            sum += square;
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println("Finished calculating the sum of squares");
        return sum;
    }
}
