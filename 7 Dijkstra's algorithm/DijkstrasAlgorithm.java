package grokkingalgorithms;

import java.util.ArrayList;
import java.util.HashMap;

public class DijkstrasAlgorithm {

    private static ArrayList<String> processed = new ArrayList<String>();

    public static void main(String[] args) {
        HashMap<String, HashMap<String, Double>> graph = new HashMap<>();

        graph.put("start", new HashMap<>());
        graph.get("start").put("a", 6.0);
        graph.get("start").put("b", 2.0);

        graph.put("a", new HashMap<>());
        graph.get("a").put("fin", 1.0);

        graph.put("b", new HashMap<>());
        graph.get("b").put("a", 3.0);
        graph.get("b").put("fin", 5.0);

        graph.put("fin", new HashMap<>());

        HashMap<String, Double> costs = new HashMap<>();
        costs.put("a", 6.0);
        costs.put("b", 2.0);
        costs.put("fin", Double.POSITIVE_INFINITY);
        System.out.println("Cost to go to the finish node: " + costs.get("fin"));

        HashMap<String, String> parents = new HashMap<>();
        parents.put("a", "start");
        parents.put("b", "start");
        parents.put("fin", null);

        String node = findLowestCostNode(costs);
        while (node != null) {
            Double cost = costs.get(node);
            HashMap<String, Double> neighbors = graph.get(node);
            for (String n : neighbors.keySet()) {
                Double newCost = cost + neighbors.get(n);
                if (newCost < costs.get(n)) {
                    costs.put(n, newCost);
                    parents.put(n, node);
                }
            }
            processed.add(node);
            node = findLowestCostNode(costs);
        }

        System.out.println("Cost to go to the finish node: " + costs.get("fin"));
        System.out.print("Path to go to the finish node: ");

        String parent = parents.get("fin");
        System.out.print("fin <-- ");
        while (parent != "start") {
            System.out.print(parent + " <-- ");
            parent = parents.get(parent);
        }
        System.out.println("start");
    }

    private static String findLowestCostNode(HashMap<String, Double> costs) {
        String lowestCostNode = null;
        Double lowestCost = Double.POSITIVE_INFINITY;
        for (HashMap.Entry<String, Double> entry : costs.entrySet()) {
            String node = entry.getKey();
            Double cost = entry.getValue();
            if (cost < lowestCost && !processed.contains(node)) {
                lowestCost = cost;
                lowestCostNode = node;
            }
        }

        return lowestCostNode;
    }
}
