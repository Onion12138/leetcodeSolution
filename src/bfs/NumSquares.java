package bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author onion
 * @date 2019/12/21 -6:58 下午
 */
public class NumSquares {
    public int numSquares(int n) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        queue.add(0);
        int layer = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int cur = queue.poll();
                if (cur == n){
                    return layer;
                }
                for (int i = 1; cur + i * i <= n; i++) {
                    if (!visited[cur+i*i]){
                        queue.add(cur + i * i);
                        visited[cur+i*i] = true;
                    }
                }
            }
            layer ++;
        }
        return layer;
    }
}
