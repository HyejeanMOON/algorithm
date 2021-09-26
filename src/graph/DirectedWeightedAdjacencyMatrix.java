package graph;

import java.util.Arrays;

/**
 * 有向带权邻接矩阵
 */
public class DirectedWeightedAdjacencyMatrix {
    int size;
    int[][] matrix;

    public DirectedWeightedAdjacencyMatrix(int size) {
        this.size = size;
        this.matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            Arrays.fill(matrix[i], -1);
        }
    }

    public boolean add(int from, int to, int weight) {
        if (from >= size || to >= size) return false;
        if (matrix[from][to] != -1) return false;

        matrix[from][to] = weight;
        return true;
    }

    public boolean remove(int from, int to) {
        if (from >= size || to >= size) return false;
        if (matrix[from][to] != -1) return false;

        matrix[from][to] = -1;
        return true;
    }

    public int getWeight(int from, int to) {
        return matrix[from][to];
    }

    public boolean hasConnectionBetweenTwoNode(int from, int to) {
        return matrix[from][to] != -1;
    }

    // find out whether is that this graph has circle connection by dfs algorithm
    public boolean hasCircleConnection() {
        boolean[][] hadVisited = new boolean[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix[i][j] != -1 && !hadVisited[i][j]) {
                    if (hasCircleConnection(i, j, hadVisited)) return true;
                }
            }
        }
        return false;
    }

    private boolean hasCircleConnection(int from, int to, boolean[][] hadVisited) {
        if (hadVisited[from][to]) {
            // if the program access the node twice, we could think this graph has circle connection.
            return true;
        }
        hadVisited[from][to] = true;
        for (int j = 0; j < size; j++) {
            if (matrix[to][j] == -1) continue;
            boolean result = hasCircleConnection(to, j, hadVisited);
            if (result) return true;
        }
        return false;
    }

    // 两点之间的最短路径， 可以直接套用单源路径算法
    public int getShortestDistanceBetweenTwoNode(int from, int to) {
        if ((from >= size || from < 0) && (to >= size || to < 0)) throw new IllegalArgumentException();
        int[] distance = getDistanceFromOneNodeToAllNode(from);

        return distance[to];
    }

    // 单源最短路径算法， dijkstra(迪杰斯特拉)算法， 根本的算法思想还是DFS
    // 时间复杂度O(size^2), 空间复杂度O(size^2+size)
    // 这个算法有一个限制，即距离（权重）必须为正，这样在距离想加的时候能正确的运转
    public int[] getDistanceFromOneNodeToAllNode(int from) {
        if (from >= size || from < 0) throw new IllegalArgumentException();
        boolean[][] hasVisited = new boolean[size][size];
        int[] distance = new int[size];
        for (boolean[] visited : hasVisited) {
            Arrays.fill(visited, false);
        }
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[from] = 0;

        getDistanceFromOneNodeToAllNode(from, hasVisited, distance);

        System.out.println(Arrays.toString(distance));

        return distance;
    }

    private void getDistanceFromOneNodeToAllNode(int from, boolean[][] hasVisited, int[] distance) {
        for (int i = 0; i < size; i++) {
            if (!hasVisited[from][i] && matrix[from][i] != -1 && from != i) {
                hasVisited[from][i] = true;
                distance[i] = Math.min(distance[i], distance[from] + matrix[from][i]);
                getDistanceFromOneNodeToAllNode(i, hasVisited, distance);
            }
        }
    }
}
