import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {

    public class Edge {
        int u;
        int v;
        int cost;

        public Edge(int u, int v, int cost) {
            this.u = u;
            this.v = v;
            this.cost = cost;
        }
    }

    public class Union {
        int[] parent;
        int[] rank;

        public Union(int n) {
            parent = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int i) {
            while (i != parent[i]) {
                parent[i] = parent[parent[i]];
                i = parent[i];
            }
            return i;
        }

        public boolean union(int x, int y) {
            int r1 = find(x);
            int r2 = find(y);
            if (r1 == r2) {
                return false;
            }
            if (rank[r1] > rank[r2]) {
                parent[r2] = r1;
                rank[r1] += rank[r2];
            } else {
                parent[r1] = r2;
                rank[r2] += rank[r1];
            }
            return true;
        }

    }

    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        // Your code here
        PriorityQueue<Edge> queue = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        Union uf = new Union(n + 1);
        int minCost = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            Edge newEdge = new Edge(0, i, wells[i - 1]);
            queue.add(newEdge);
        }

        for (int[] pipe : pipes) {
            Edge newEdge = new Edge(pipe[0], pipe[1], pipe[2]);
            queue.add(newEdge);
        }

        while (!queue.isEmpty() && count < n + 1) {
            Edge curr = queue.poll();
            int x = curr.u;
            int y = curr.v;
            int z = curr.cost;
            boolean united = uf.union(x, y);
            if (united) {
                count++;
                minCost += z;
            }
        }
        return minCost;
    }
}
