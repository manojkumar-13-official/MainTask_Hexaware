package LogisticsAndDeliveryWindow;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class LogisticsNetwork {

    private Map<String, List<String>> networks = new HashMap<>();

    // Add an undirected route (edge) between two hubs
    public void addRoute(String hubA, String hubB) {
        networks.putIfAbsent(hubA, new ArrayList<>());
        networks.putIfAbsent(hubB, new ArrayList<>());
        networks.get(hubA).add(hubB);
        networks.get(hubB).add(hubA);
    }

    // 1. BFS: Find route with the fewest hops between start and end hub
    public List<String> findShortestPathBFS(String start, String target) {
        Queue<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        Map<String, String> parentMap = new HashMap<>();

        queue.add(start);
        visited.add(start);

        boolean pathFound = false;

        while (!queue.isEmpty()) {
            String current = queue.poll();

            if (current.equals(target)) {
                pathFound = true;
                break;
            }

            for (String neighbor : networks.getOrDefault(current, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    parentMap.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }

        List<String> path = new ArrayList<>();
        if (!pathFound) {
            return path;
        }

        String curr = target;
        while (curr != null) {
            path.add(curr);
            curr = parentMap.get(curr);
        }
        Collections.reverse(path);
        return path;
    }

    // 2. DFS: List all hubs reachable from central depot
    public Set<String> getReachableHubsDFS(String centralDepot) {
        Set<String> visited = new HashSet<>();
        dfsTraversal(centralDepot, visited);
        return visited;
    }

    private void dfsTraversal(String current, Set<String> visited) {
        visited.add(current);

        for (String neighbor : networks.getOrDefault(current, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                dfsTraversal(neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        LogisticsNetwork logiMap = new LogisticsNetwork();

        logiMap.addRoute("DEPOT", "DEL");
        logiMap.addRoute("DEPOT", "BOM");
        logiMap.addRoute("DEL", "BLR");
        logiMap.addRoute("DEL", "CCU");
        logiMap.addRoute("BOM", "PNQ");
        logiMap.addRoute("BOM", "HYD");
        logiMap.addRoute("BLR", "MAA");
        logiMap.addRoute("CCU", "GHY");
        logiMap.addRoute("HYD", "MAA");
        logiMap.addRoute("MAA", "COK");

        // BFS Demonstration: Shortest route by fewest hops
        String startHub = "DEL";
        String endHub = "MAA";
        List<String> shortestRoute = logiMap.findShortestPathBFS(startHub, endHub);
        System.out.println("Fewest Hops Route from " + startHub + " to " + endHub + ": " + shortestRoute);

        // DFS Demonstration: Reachable hubs from central depot
        String centralDepot = "DEPOT";
        Set<String> reachableHubs = logiMap.getReachableHubsDFS(centralDepot);
        System.out.println("Hubs reachable from " + centralDepot + ": " + reachableHubs);
    }
}
