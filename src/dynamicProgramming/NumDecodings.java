package dynamicProgramming;

/**
 * @author onion
 * @date 2019/12/9 -9:27 下午
 */
public class NumDecodings {
    public int numDecodings(String s) {
        int n = s.length();
        if(n == 0 || s.charAt(0) == '0')
            return 0;
        int []dp = new int[n+1];
        dp[0] = 1;
        for(int i=1;i<=n;i++){
            if(s.charAt(i-1)!='0')
                dp[i] = dp[i-1];
            if(i > 1 && s.charAt(i-2) == '1' )
                dp[i] += dp[i-2];
            if(i > 1 && s.charAt(i-2) == '2' && s.charAt(i-1) <= '6')
                dp[i] += dp[i-2];
        }
        return dp[n];
    }
}
