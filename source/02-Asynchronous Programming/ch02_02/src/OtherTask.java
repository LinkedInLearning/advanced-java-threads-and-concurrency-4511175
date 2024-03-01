import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class OtherTask implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("Processing data...");
        TimeUnit.SECONDS.sleep(1);
        return "Data processing finished";
    }
}
