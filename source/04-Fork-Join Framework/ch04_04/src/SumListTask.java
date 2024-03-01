import java.util.List;
import java.util.concurrent.RecursiveTask;

public class SumListTask extends RecursiveTask<Long> {
    private List<Long> numbers;
    private static final int THRESHOLD = 5;

    public SumListTask(List<Long> numbers) {
        this.numbers = numbers;
    }

    @Override
    protected Long compute() {
        if(numbers.size() <= THRESHOLD) {
            long sum = computeDirectly();
            System.out.format("Sum of %s: %d\n", numbers.toString(), sum);
            return sum;
        } else {
            int mid = numbers.size() / 2;
            SumListTask subTask1 = new SumListTask(numbers.subList(0, mid));
            SumListTask subTask2 = new SumListTask(numbers.subList(mid, numbers.size()));

            invokeAll(subTask1, subTask2);

            return subTask1.join() + subTask2.join();
        }
    }

    protected long computeDirectly() {
        long sum = 0;
        for (Long n: numbers) {
            sum += n;
        }
        return sum;
    }
}
