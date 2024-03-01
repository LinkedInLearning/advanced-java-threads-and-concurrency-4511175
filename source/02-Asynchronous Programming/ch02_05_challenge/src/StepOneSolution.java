import java.util.concurrent.*;

public class StepOneSolution {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // Write code for the Task 01 solution here

        long startTime = System.nanoTime();

        // Place your solution code here

        long elapsedTime = System.nanoTime() - startTime;
        System.out.println("Both tasks finished in " + (elapsedTime/1000000)/1000 + " seconds");

        // Don't forget to shut down the executor service once you are done
    }
}
