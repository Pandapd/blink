import java.util.LinkedList;
import java.util.Queue;
import tree.TreeNode;

/**
 *
 * 404.左叶子之和
 * @level easy
 * @date Created at 2022/6/20
 */
public class Solution404 {

    /**
     * 我的思路
     * 广度优先遍历
     */

    public int sumOfLeftLeaves(TreeNode root) {
        int res = 0;
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode left = node.left;
            if (left != null) {
                if (isLeafNode(left)) {
                    res += left.val;
                } else {
                    queue.offer(left);
                }
            }
            TreeNode right = node.right;
            if (right != null) {
                if (!isLeafNode(right)) {
                    queue.offer(right);
                }
            }
        }
        return res;
    }

    private boolean isLeafNode(TreeNode node) {
        return node.left==null && node.right==null;
    }
}
