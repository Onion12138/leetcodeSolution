package bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author onion
 * @date 2019/12/22 -10:41 下午
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
public class FindBottomLeftValue {
    public int findBottomLeftValue(TreeNode root) {
        int ret = root.val;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i ++) {
                TreeNode cur = queue.poll();
                if(i == 0)
                    ret = cur.val;
                if(cur.left != null)
                    queue.add(cur.left);
                if(cur.right != null)
                    queue.add(cur.right);
            }
        }
        return ret;
    }
}
