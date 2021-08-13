package grokkingalgorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
    
    public static void main(String[] args) {
        HashMap<String, String[]> graph = new HashMap<>();
        
        graph.put("you", new String[]{"alice", "bob", "claire"});
        graph.put("bob", new String[]{"anuj", "peggy"});
        graph.put("alice", new String[]{"peggy"});
        graph.put("claire", new String[]{"thom", "jonny"});
        graph.put("anuj", new String[]{});
        graph.put("peggy", new String[]{});
        graph.put("thom", new String[]{});
        graph.put("jonny", new String[]{});
        
        search(graph);
    }
    
    private static boolean search(HashMap<String, String[]> graph) {
        Queue<String> searchQueue = new LinkedList<>();
        
        for (int i = 0; i < graph.get("you").length; i++) {
            searchQueue.add(graph.get("you")[i]);
        }
        
        ArrayList<String> searched = new ArrayList<String>();
        
        while (!searchQueue.isEmpty()) {
            String person = searchQueue.remove();
            if (!searched.contains(person)) {
                if (personIsSeller(person)) {
                    System.out.println(person + " is a mango seller!");
                    
                    return true;
                } else {
                    for (int i = 0; i < graph.get(person).length; i++) {
                        searchQueue.add(graph.get(person)[i]);
                    }
                    searched.add(person);
                }
            }
        }
        
        return false;
    }
    
    private static boolean personIsSeller(String name) {
        return name.charAt(name.length() - 1) == 'm';
    }
}
