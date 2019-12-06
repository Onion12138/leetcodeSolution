package dfs;

/**
 * @author onion
 * @date 2019/12/6 -4:16 下午
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
public class MaxPathSum {
    private int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxWithRoot(root);
        return res;
    }
    //为何写一个私有递归函数？语义变化：返回必须包含根节点的左子树或右子树
    private int maxWithRoot(TreeNode root){
        if (root == null){
            return 0;
        }
        //设置为0，表示不选
        int left = Math.max(maxWithRoot(root.left),0);
        int right = Math.max(maxWithRoot(root.right),0);
        res = Math.max(res, left + right + root.val);
        return root.val + Math.max(left, right);
    }
}
