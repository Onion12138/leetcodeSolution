package dynamicProgramming;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author onion
 * @date 2019/12/5 -10:34 上午
 */
public class WordBreak {
    public boolean wordBreakI(String s, List<String> wordDict) {
        int n = s.length();
        boolean []dp = new boolean[n+1];
        dp[0] = true;
        //前闭后开
        for(int i=1; i <= n; i++){
            for(int j=0; j < i; j++){
                if(dp[j] && wordDict.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
    private Map<Integer, List<String>> memo;
    public List<String> wordBreakII(String s, List<String> wordDict) {
        memo = new HashMap<>();
        return wordBreak(s, wordDict, 0);
    }
    private List<String> wordBreak(String s, List<String> wordDict, int start) {
        if (memo.containsKey(start)){
            return memo.get(start);
        }
        LinkedList<String> res = new LinkedList<>();
        if (start == s.length()){
            res.add("");
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end))){
                List<String> list = wordBreak(s,wordDict, end);
                for (String l : list) {
                    res.add(s.substring(start, end) + (l.equals("") ? "" : " ") + l);
                }
            }
        }
        memo.put(start, res);
        return res;
    }
}
