package graph;

import java.util.*;

/**
 * 有向带权邻接表
 */
public class DirectedWeightedAdjacencyList {
    int size;
    List<HashMap<Integer, Integer>> list;

    public DirectedWeightedAdjacencyList(int size) {
        this.size = size;
        list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(new HashMap<>());
        }
    }

    public boolean add(int from, int to, int weight) {
        if (from >= size || to >= size) return false;
        Map<Integer, Integer> map = list.get(from);

        if (map.containsKey(to)) {
            return false;
        }
        list.get(from).put(to, weight);
        return true;
    }

    public boolean remove(int from, int to) {
        if (from >= size || to >= size) return false;
        if (list.get(from) == null) return false;
        if (!list.get(from).containsKey(to)) return false;
        list.get(from).remove(to);
        return true;
    }

    public int getWeight(int from, int to) {
        if (list.get(from) == null) return -1;
        return list.get(from).getOrDefault(to, -1);
    }

    public boolean hasConnectionBetweenTwoNode(int from, int to) {
        return list.get(from).containsKey(to);
    }

    // find out whether is that this graph has circle connection by dfs algorithm
    public boolean hasCircleConnection() {
        List<Map<Integer, Boolean>> visited = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            visited.add(new HashMap<>());
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!visited.get(i).getOrDefault(j, false) && list.get(i).containsKey(j)) {
                    boolean result = hadCircleConnection(i, j, visited);
                    if (result) return true;
                }
            }
        }
        return false;
    }

    private boolean hadCircleConnection(int from, int to, List<Map<Integer, Boolean>> visited) {
        // the algorithm had visited this node before, so this graph has circle connection.
        if (visited.get(from).getOrDefault(to, false)) return true;

        visited.get(from).put(to, true);
        if (list.get(from).keySet().size() == 0) return false;

        for (Integer key : list.get(to).keySet()) {
            boolean result = hadCircleConnection(to, key, visited);
            if (result) return true;
        }
        return false;
    }

    public int getShortestDistanceBetweenTwoNode(int from, int to) {
        // TODO
        return 0;
    }

    // 单源最短路径算法
    public int[] getDistanceFromOneNodeToAllNode(int from) {
        // TODO
        return new int[]{};
    }
}
