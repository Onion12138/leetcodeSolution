package bfs;

import java.util.*;

/**
 * @author onion
 * @date 2019/12/22 -10:31 下午
 */
public class LadderLength {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new TreeSet<>(wordList);
        Map<String, Integer> map = new HashMap<>();
        if (!dict.contains(endWord))
            return 0;
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        map.put(beginWord, 1);
        while (!queue.isEmpty()){
            int size = queue.size();
            String cur = queue.poll();
            for (int i = 0; i < cur.length(); i++) {
                StringBuilder sb = new StringBuilder(cur);
                for (char c = 'a'; c <= 'z' ; c++) {
                    sb.replace(i,i+1, c + "");
                    String next = sb.toString();
                    if (next.equals(endWord)){
                        return map.get(cur) + 1;
                    }
                    if (!map.containsKey(next) && dict.contains(next)) {
                        queue.add(next);
                        map.put(next, map.get(cur)+1);
                    }
                }
            }
        }
        return 0;
    }
}
