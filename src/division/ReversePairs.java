package division;

/**
 * @author onion
 * @date 2019/11/11 -6:51 下午
 */
public class ReversePairs {
    public int reversePairs(int[] nums) {
        return (int)mergeSort(nums, 0, nums.length-1);
    }
    private long mergeSort(int [] nums, int begin, int end){
        if(begin >= end)
            return 0;
        int mid = begin + end >> 1;
        long leftCnt = mergeSort(nums, begin, mid);
        long rightCnt = mergeSort(nums, mid+1, end);
        long midCnt = 0;
        int [] temp = new int[end - begin + 1];
        int i = begin, j = mid + 1, index = 0;
        while (i <= mid && j <= end){
            if ((long)nums[i] > (long)2 * nums[j]) {
                midCnt += mid - i + 1;
                j ++;
            }
            else
                i ++;
        }
        i = begin;
        j = mid + 1;
        while (i <= mid && j <= end){
            if (nums[i] > nums[j]) {
                temp[index++] = nums[j++];
            }
            else{
                temp[index++] = nums[i++];
            }
        }
        while (i <= mid)
            temp[index++] = nums[i++];
        while (j <= end)
            temp[index++] = nums[j++];
        for (int k = begin; k <= end; k++) {
            nums[k] = temp[k - begin];
        }
        return leftCnt + rightCnt + midCnt;
    }

}
