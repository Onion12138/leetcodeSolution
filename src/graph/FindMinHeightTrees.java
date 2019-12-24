package graph;

import java.util.*;

/**
 * @author onion
 * @date 2019/12/24 -8:41 上午
 * 拓扑排序
 */
public class FindMinHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        TreeSet<Integer>[] graph = new TreeSet[n];
        List<Integer> ret = new ArrayList<>();
        if (n == 0) {
            ret.add(0);
            return ret;
        }
        for (int i = 0; i < n; i++) {
            graph[i] = new TreeSet<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (graph[i].size() == 1){
                queue.add(i);
            }
        }
        while (n > 2) {
            int size = queue.size();
            n -= size;
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                for (int adj : graph[cur]) {
                    graph[adj].remove(cur);
                    if (graph[adj].size() == 1) {
                        queue.add(adj);
                    }
                }
            }
        }
        ret.addAll(queue);
        return ret;
    }
}
