package dynamicProgramming;

/**
 * @author onion
 * @date 2019/12/9 -9:12 下午
 */
public class MaxProduct {
    public int maxProduct(int[] nums) {
        int min = 1;
        int max = 1;
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < 0){
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(nums[i], max * nums[i]);
            min = Math.min(nums[i], min * nums[i]);
            res = Math.max(res, max);
        }
        return res;
    }
}
