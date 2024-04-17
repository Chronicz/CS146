import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];
        int[] edges = new int[numCourses];
        List<Integer> result = new ArrayList<>();

        for (int[] pair : prerequisites) {
            int course = pair[0];
            int prerequisite = pair[1];
            if (graph[prerequisite] == null) {
                graph[prerequisite] = new ArrayList<>();
            }
            graph[prerequisite].add(course);
            edges[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (edges[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();
            result.add(current);

            if (graph[current] != null) {
                for (int nextCourse : graph[current]) {
                    edges[nextCourse]--;
                    if (edges[nextCourse] == 0) {
                        queue.offer(nextCourse);
                    }
                }
            }
        }
        return result.size() == numCourses;
    }
}