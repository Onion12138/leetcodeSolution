package graph;

import java.util.Arrays;

/**
 * @author onion
 * @date 2019/12/20 -3:53 下午
 */
public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int N, int K) {
        int[] distance = new int[N+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[K] = 0;
        for(int i=1;i<N;i++){
            for(int[] pair : times){
                int u = pair[0];
                int v = pair[1];
                int w = pair[2];
                if(distance[u] != Integer.MAX_VALUE && distance[u] + w < distance[v])
                    distance[v] = distance[u] + w;
            }
        }
        int ret = Arrays.stream(distance).skip(1).max().getAsInt();
        return ret == Integer.MAX_VALUE ? -1 :ret;
    }
}
