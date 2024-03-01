import java.util.List;
import java.util.concurrent.RecursiveAction;

public class SumListAction extends RecursiveAction {
    private List<Long> numbers;
    private static final int THRESHOLD = 5;

    public SumListAction(List<Long> numbers) {
        this.numbers = numbers;
    }

    @Override
    protected void compute() {
        if(numbers.size() <= THRESHOLD) {
            long sum = computeDirectly();
            System.out.format("Sum of %s: %d\n", numbers.toString(), sum);
        } else {
            int mid = numbers.size() / 2;
            SumListAction subTask1 = new SumListAction(numbers.subList(0, mid));
            SumListAction subTask2 = new SumListAction(numbers.subList(mid, numbers.size()));

            invokeAll(subTask1, subTask2);
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
