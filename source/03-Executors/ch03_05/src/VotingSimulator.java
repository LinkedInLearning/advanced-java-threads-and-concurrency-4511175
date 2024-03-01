import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class VotingSimulator {

    private static int noOfVotes = 0;
    private static final int VOTERS = 25;

    public static void main(String[] args) throws InterruptedException {
        Candidate candidate1 = new Candidate("C1");
        Candidate candidate2 = new Candidate("C2");
        Candidate candidate3 = new Candidate("C3");

        List<Candidate> candidateList = new ArrayList<>();
        candidateList.add(candidate1);
        candidateList.add(candidate2);
        candidateList.add(candidate3);

        // Write code here to create two tasks - voting & counting and execute them using a scheduled executor service


        // This code is for continuing voting until the number of votes reaches the number of voters
        while (noOfVotes != VOTERS) {
            TimeUnit.MILLISECONDS.sleep(100);
        }

        // Printing that the voting is ending as all voters have voted
        System.out.println("All voters have voted. Ending voting....");
        // Write code here to cancel the voting task

        /* Write code here to wait for a maximum of 1 second until all tasks have completed execution
           i.e. this is done to give enough time for the counting task to execute, before shutting down the executor.
           Hint: use the  awaitTermination() method */

    }


}
