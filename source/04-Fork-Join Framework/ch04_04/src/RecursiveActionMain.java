import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;

import static java.util.stream.Collectors.toList;

public class RecursiveActionMain {

    public static void main(String[] args) {

        Random random = new Random();
        List<Long> data = random
                .longs(11, 1, 5)
                .boxed()
                .collect(toList());

        ForkJoinPool pool = new ForkJoinPool();
        SumListAction task = new SumListAction(data);
        pool.invoke(task);

    }
}
