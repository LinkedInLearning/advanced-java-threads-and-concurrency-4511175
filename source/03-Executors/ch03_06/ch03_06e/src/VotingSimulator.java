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

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

        Runnable vote = () -> {
            Random random = new Random();
            int index = random.nextInt(3);
            Candidate candidate = candidateList.get(index);
            candidate.getVotes().add(1);
            noOfVotes++;
            System.out.println("Voted for " + candidate.getName());
        };

        Runnable count = () -> {
            for(Candidate c : candidateList) {
                System.out.println("Candidate  " + c.getName() + " has " + c.getVotes().size() + " votes");
            }
        };

        ScheduledFuture<?> scheduledFuture1 = scheduledExecutorService.scheduleAtFixedRate(vote, 0, 1, TimeUnit.SECONDS);

        scheduledExecutorService.scheduleWithFixedDelay(count, 5, 1, TimeUnit.SECONDS);


        while (noOfVotes != VOTERS) {
            TimeUnit.MILLISECONDS.sleep(100);
        }

        System.out.println("All voters have voted. Voting ended!");
        scheduledFuture1.cancel(true);

        try {
            if (!scheduledExecutorService.awaitTermination(1, TimeUnit.SECONDS)) {
                scheduledExecutorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            scheduledExecutorService.shutdownNow();
        }
    }


}
