package main.graphs;

import org.junit.Test;

import java.util.*;

public class CourseScheduleIV_1462 {


    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {


        List<Boolean> result = new ArrayList<>();

        boolean[][] memoization = new boolean[numCourses][numCourses];


        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            int from = prerequisites[i][0];
            int to = prerequisites[i][1];
            graph.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
            indegree[to]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i=0;i<numCourses;i++) {
            if (indegree[i] == 0)
                queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int course = queue.poll();
            List<Integer> adjacent = graph.getOrDefault(course, new ArrayList<>());
            for (int adj : adjacent) {
                memoization[course][adj] = true;
                /**If you are at course that means you are done processing the prerequisites
                 * If i is prereq of course that means you processed i and came to course
                 * 1 → 2 → 0 tp sort 1, 2, 0
                 * memo[1][2] = true
                 * memo[1][0] = true
                 */
                for (int i = 0; i < numCourses; i++) {
                    if (memoization[i][course]) {
                        memoization[i][adj] = true;
                    }
                }
                indegree[adj]--;
                if (indegree[adj] == 0)
                    queue.offer(adj);
            }
        }

        for (int[] q : queries) {
            result.add(memoization[q[0]][q[1]]);
        }


        return result;

    }


    @Test
    public void test() {
        int numCourses = 3;
        int[][] prerequisites = {{1, 2}, {1, 0}, {2, 0}};
        int[][] queries = {{1, 0}, {1, 2}};
        checkIfPrerequisite(numCourses, prerequisites, queries);
    }
}
