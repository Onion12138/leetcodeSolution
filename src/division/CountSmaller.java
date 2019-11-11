package division;

import java.util.ArrayList;
import java.util.List;

/**
 * @author onion
 * @date 2019/11/11 -7:45 下午
 */
public class CountSmaller {
    private int index[];
    private int temp[];
    private int counter[];
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return res;
        }
        temp = new int[len];
        counter = new int[len];
        index = new int[len];
        for (int i = 0; i < len; i++) {
            index[i] = i;
        }
        mergeAndCountSmaller(nums, 0, len - 1);
        for (int i = 0; i < len; i++) {
            res.add(counter[i]);
        }
        return res;
    }
    private void mergeAndCountSmaller(int[] nums, int begin, int end) {
        if (begin >= end)
            return;
        int mid = begin + end >> 1;
        mergeAndCountSmaller(nums, begin, mid);
        mergeAndCountSmaller(nums, mid + 1, end);
        if (nums[index[mid]] > nums[index[mid + 1]]) {
            merge(nums, begin, mid, end);
        }
    }

    private void merge(int[] nums, int begin, int mid, int end) {
        for (int i = begin; i <= end; i++) {
            temp[i] = index[i];
        }
        int i = begin, j = mid + 1;
        for (int k = begin; k <= end; k++) {
            if (i > mid){
                index[k] = temp[j++];
            }else if(j > end){
                index[k] = temp[i++];
                counter[index[k]] += end - mid;
            }else if (nums[temp[i]] <= nums[temp[j]]){
                index[k] = temp[i++];
                counter[index[k]] += j - mid - 1;
            }else{
                index[k] = temp[j++];
            }
        }
    }
}
