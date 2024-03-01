import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class SumOfEvenTask implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("Calculating the sum of even numbers ...");
        int sum = 0;
        for(int i = 0; i < 10; i++) {
            if(i%2 == 0) {
                sum += i;
            }
            TimeUnit.SECONDS.sleep(2);
        }
        System.out.println("Finished calculating the sum of even numbers");
        return sum;
    }
}
