package grokkingalgorithms;

import java.util.HashMap;

public class CheckVoter {

    public static void main(String[] args) {
        HashMap<String, Boolean> voted = new HashMap<>();
        
        checkVoter(voted, "tom");
        checkVoter(voted, "mike");
        checkVoter(voted, "mike");
    }

    private static void checkVoter(HashMap<String, Boolean> voted, String name) {
        if (voted.containsKey(name)) {
            System.out.println("kick them out!");
        } else {
            voted.put(name, Boolean.TRUE);
            System.out.println("let them vote!");
        }
    }
}
