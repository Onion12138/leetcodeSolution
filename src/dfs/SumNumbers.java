package dfs;

/**
 * @author onion
 * @date 2019/12/6 -4:50 下午
 */
public class SumNumbers {
    private int res = 0;
    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        sum(root, 0);
        return res;
    }
    private void sum(TreeNode root, int cur){
        if(root.left == null && root.right == null){
            res += 10 * cur + root.val;
        }
        if(root.left != null){
            sum(root.left, 10 * cur + root.val);
        }
        if(root.right != null){
            sum(root.right, 10 * cur + root.val);
        }
    }
}
