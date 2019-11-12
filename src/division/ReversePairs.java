package division;

/**
 * @author onion
 * @date 2019/11/11 -6:51 下午
 */
public class ReversePairs {
    private int []temp;
    public int reversePairs(int[] nums) {
        int n = nums.length;
        temp = new int[n];
        return mergeCount(nums, 0, n-1);
    }
    private int mergeCount(int []nums, int begin, int end){
        if(begin >= end)
            return 0;
        int mid = begin + end >> 1;
        int leftCnt = mergeCount(nums, begin, mid);
        int rightCnt = mergeCount(nums, mid+1, end);
        int midCnt = 0;
        for(int i = begin; i <= end; i++)
            temp[i] = nums[i];
        int i = begin, j = mid+1;
        while(i <= mid && j <= end){
            if((long)nums[i] > (long)2 * nums[j]){
                midCnt += mid - i + 1;
                j++;
            }else{
                i++;
            }
        }
        i = begin;
        j = mid+1;
        for(int k = begin; k <= end; k++){
            if(i > mid){
                nums[k] = temp[j++];
            }else if(j > end){
                nums[k] = temp[i++];
            }else if(temp[i] < temp[j]){
                nums[k] = temp[i++];
            }else{
                nums[k] = temp[j++];
            }
        }
        return leftCnt + rightCnt + midCnt;
    }
}
