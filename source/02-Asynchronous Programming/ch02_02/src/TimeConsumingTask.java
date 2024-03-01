import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class TimeConsumingTask implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("Accessing data over the network...");
        TimeUnit.SECONDS.sleep(4);
        return "Accessing data finished";
    }
}
