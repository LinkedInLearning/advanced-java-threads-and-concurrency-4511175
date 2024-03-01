import java.util.List;

public class MultiplesCalculator {
    private List<Integer> numbers;
    public static int threshold;
    public static int multipleOf;

    public MultiplesCalculator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    /* Override the compute() method with the implementation for calculating multiples here
       i.e. divide and conquer mechanism based on the threshold value
     */

    protected int computeDirectly() {
        int count = 0;
        for (Integer n: numbers) {
            if (n % multipleOf == 0) {
                count +=1;
            }
        }
        return count;
    }

}
