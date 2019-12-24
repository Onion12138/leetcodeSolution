package deap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author onion
 * @date 2019/12/24 -8:17 上午
 */
public class TrapRainWater {
    class Node implements Comparable<Node>{
        int height;
        int x;
        int y;
        public Node(int height, int x, int y) {
            this.height = height;
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(Node node) {
            return height - node.height;
        }
    }
    public int trapRainWater(int[][] heightMap) {
        int ret = 0;
        int m = heightMap.length;
        if (m == 0)
            return 0;
        int n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] dir = {{1,0},{-1,0},{0,-1},{0,1}};
        Queue<Node> queue = new PriorityQueue<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0 || i == m - 1 || j == n - 1){
                    visited[i][j] = true;
                    queue.add(new Node(heightMap[i][j], i, j));
                }
            }
        }
        int maxHeight = Integer.MIN_VALUE;
        while (!queue.isEmpty()){
            Node node = queue.poll();
            int h = node.height;
            int x = node.x;
            int y = node.y;
            maxHeight = Math.max(h,maxHeight);
            for (int i = 0; i < 4; i++) {
                int newX = x + dir[i][0];
                int newY = y + dir[i][1];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && !visited[newX][newY]){
                    if (heightMap[newX][newY] < maxHeight)
                        ret += maxHeight - heightMap[newX][newY];
                    queue.add(new Node(heightMap[newX][newY], newX, newY));
                    visited[newX][newY] = true;
                }
            }
        }
        return ret;
    }
}
