import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

import static java.util.stream.Collectors.toList;

public class RecursiveTaskMain {
    public static void main(String[] args) {
        Random random = new Random();
        List<Long> data = random
                .longs(10, 1, 5)
                .boxed()
                .collect(toList());

        ForkJoinPool pool = new ForkJoinPool();
        SumListTask task = new SumListTask(data);
        System.out.println("Sum: " + pool.invoke(task));

    }
}
