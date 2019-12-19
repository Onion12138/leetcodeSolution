package bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author onion
 * @date 2019/12/19 -9:15 下午
 */
public class ShortestPath {
    class Point{
        int x;
        int y;
        int z;
        public Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};
        boolean[][][] visited = new boolean[m][n][k+1];
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0, 0));
        visited[0][0][0] = true;
        int distance = 0;
        while (!queue.isEmpty()){
            distance ++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point point = queue.poll();
                int x = point.x;
                int y = point.y;
                int z = point.z;
                visited[x][y][z] = true;
                if (x == m - 1 && y == n - 1)
                    return distance - 1;
                for (int j = 0; j < 4; j++) {
                    int newX = x + dir[j][0];
                    int newY = y + dir[j][1];
                    int newZ = z;
                    if (newX < 0 || newY < 0 || newX >= m || newY >= n)
                        continue;
                    if (visited[newX][newY][newZ])
                        continue;
                    if (grid[newX][newY] == 1){
                        if (z < k){
                            newZ  = z + 1;
                        }else{
                            continue;
                        }
                    }
                    if (!visited[newX][newY][newZ]){
                        visited[newX][newY][newZ] = true;
                        queue.add(new Point(newX, newY, newZ));
                    }
                }
            }
        }
        return -1;
    }
}
