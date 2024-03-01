import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;


public class NumberMagic {
    static int number = 0;
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Scanner myObj = new Scanner(System.in);
        boolean flag;

        do {
            System.out.print("Enter an integer number: ");
            try {
                number = Integer.parseInt(myObj.nextLine());
                flag = false;
            } catch (NumberFormatException e) {
                System.out.println("Not a valid integer");
                flag = true;
            }
        } while(flag);

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Callable<String> findSqrt = () -> {
            double sqrt = Math.sqrt(number);
            return  "Square Root of " + number + " is: " + sqrt;
        };

        Callable<String> findFactorial = () -> {
            BigInteger result = BigInteger.ONE;
            for (int i = 2; i <= number; i++)
                result = result.multiply(BigInteger.valueOf(i));

            return "Factorial of " + number + " is: " + result;
        };

        Callable<String> toBinary = () -> {
            String binary = Integer.toBinaryString(number);
            return number + " in binary: " + binary;
        };

        List<Callable<String>> callableTasks = new ArrayList<>();
        callableTasks.add(findSqrt);
        callableTasks.add(findFactorial);
        callableTasks.add(toBinary);

        List<Future<String>> futures = executorService.invokeAll(callableTasks);


        for(Future<String> future:futures) {
            System.out.println(future.get());
        }

        executorService.shutdown();


    }
}
