package greedyAlgorithm;

import java.util.Arrays;

/**
 * @author onion
 * @date 2019/12/13 -12:36 下午
 */
public class EraseOverlapIntervals {
    //dp,转化为LIS问题
    public int eraseOverlapIntervalsDp(int[][] intervals) {
        if (intervals.length == 0)
            return 0;
        Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        int []dp = new int[intervals.length];
        int ret = 1;
        for (int i = 1; i < intervals.length; i++) {
            for (int j = 0; j < i; j++) {
                if (intervals[i][0] >= intervals[j][1]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            ret = Math.max(ret,dp[i]);
        }
        return intervals.length - ret;
    }
    //贪心算法：按照区间结尾排序，每次选择结尾最早的，且和前一个区间不重叠的区间。效率更高
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0)
            return 0;
        Arrays.sort(intervals, (a, b) -> a[1] != b[1] ? a[1] - b[1] : a[0] - b[0]);
        int res = 1;
        int pre = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= intervals[pre][1]){
                res ++;
                pre = i;
            }
        }
        return intervals.length - res;
    }
}
