package bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author onion
 * @date 2019/12/19 -8:44 下午
 */
public class ShortestPathBinaryMatrix {
    class Point{
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (grid[0][0] == 1 || grid[m-1][n-1] == 1)
            return -1;
        int[][] dir = {{1,-1},{1,0},{1,1},{0,-1},{0,1},{-1,-1},{-1,0},{-1,1}};
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));
        grid[0][0] = 1;
        int distance = 0;
        while (!queue.isEmpty()){
            distance ++;
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                Point point = queue.poll();
                int x = point.x;
                int y = point.y;
                if (x == m - 1 && y == n - 1)
                    return distance;
                for (int i = 0; i < 8; i++) {
                    int newX = x + dir[i][0];
                    int newY = y + dir[i][1];
                    if (newX < 0 || newY < 0 || newX >= n || newY >= n)
                        continue;
                    if(grid[newX][newY] == 1)
                        continue;
                    queue.add(new Point(newX, newY));
                    grid[newX][newY] = 1;
                }
            }
        }
        return -1;
    }
}
