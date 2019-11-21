package dynamicProgramming;

/**
 * @author onion
 * @date 2019/11/21 -1:39 下午
 */
public class MinDistance {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length(), n2 = word2.length();
        int [][] dp = new int[n1+1][n2+1];
        for(int i=0;i<=n1;i++)
            dp[i][0] = i;
        for(int i=0;i<=n2;i++)
            dp[0][i] = i;
        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
            }
        }
        return dp[n1][n2];
    }
}
