import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;

import static java.util.stream.Collectors.toList;

public class MultiplesCalculatorMain {
    public static void main(String[] args) {
        int listSize = 0;
        int divisor = 0;
        int threshold = 0;

        Scanner input1 = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        Scanner input3 = new Scanner(System.in);
        boolean flag;

        String GREEN = "\u001B[32m";
        String BLUE = "\u001B[34m";
        String RED = "\u001B[31m";
        String RESET = "\u001B[0m";

        System.out.println(GREEN + "Enter list size, divisor and a threshold value to calculate the number of " +
                "multiples in a list of random integers." + RESET);

        do {
            System.out.print(BLUE + "List size (< 10 million): " + RESET);
            try {
                listSize = Integer.parseInt(input1.nextLine());
                flag = !(listSize <= 10_000_000);
            } catch (NumberFormatException e) {
                System.out.println(RED + "Not a valid integer" + RESET);
                flag = true;
            }
        } while(flag);

        do {
            System.out.print(BLUE + "Divisor (between 1 & 10): " + RESET);
            try {
                divisor = Integer.parseInt(input2.nextLine());
                flag = !(divisor <= 10);
            } catch (NumberFormatException e) {
                System.out.println(RED + "Not a valid integer" + RESET);
                flag = true;
            }
        } while(flag);

        do {
            System.out.print(BLUE + "Threshold: " + RESET);
            try {
                threshold = Integer.parseInt(input3.nextLine());
                flag = false;
            } catch (NumberFormatException e) {
                System.out.println(RED + "Not a valid integer" + RESET);
                flag = true;
            }
        } while(flag);

        Random random = new Random();
        List<Integer> data = random
                .ints(listSize, 1, 100)
                .boxed()
                .collect(toList());

        MultiplesCalculator.multipleOf = divisor;
        MultiplesCalculator.threshold = threshold;
        ForkJoinPool pool = new ForkJoinPool();
        MultiplesCalculator task = new MultiplesCalculator(data);
        System.out.println("Total number of Multiples: " + pool.invoke(task));

    }
}
