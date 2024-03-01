import java.util.ArrayList;
import java.util.List;

public class Candidate {

    private String name;
    private List<Integer> votes = new ArrayList<>();

    public Candidate(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getVotes() {
        return votes;
    }
}
