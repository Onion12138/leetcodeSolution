package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author onion
 * @date 2019/12/2 -8:19 下午
 */
public class Partition {
    private ArrayList<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        part(s,0, new ArrayList<>());
        return res;
    }
    public boolean isHuiWen(String s){
        int i = 0;
        int j = s.length() - 1;
        while(i <= j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public void part(String s, int i, ArrayList<String> arr){
        if(i == s.length()){
            res.add(new ArrayList<>(arr));
        }
        for(int j = i; j < s.length(); j++){
            if(isHuiWen(s.substring(i,j+1))){
                arr.add(s.substring(i,j+1));
                part(s, j+1, arr);
                arr.remove(arr.size()-1);
            }
        }
    }
}
