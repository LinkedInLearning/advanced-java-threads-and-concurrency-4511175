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

        /* Write code here to create the 3 tasks:
            1. calculating the square root
            2. calculating the factorial, of the given number
            3.represent the number in binary form
            and execute them using an executor service
            Hint: you've seen 4 task execution methods during demos.
                  Decide which task execution method is suitable in this case. */
    }
}
