package dynamicProgramming;

import java.util.Arrays;

/**
 * @author onion
 * @date 2019/11/22 -6:44 下午
 */
public class IntegerBreak {
    private int [] memo;
    public int integerBreak(int n) {
        memo = new int[n+1];
        Arrays.fill(memo, -1);
        return breakInteger(n);
    }
    private int breakInteger(int n){
        if(memo[n] != -1)
            return memo[n];
        int max = 0;
        for(int i = 1; i < n; i ++){
            max = Math.max(max,Math.max(i*(n-i), i*breakInteger(n-i)));
        }
        return memo[n] = max;
    }
}
