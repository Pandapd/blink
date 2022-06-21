import java.util.LinkedList;
import java.util.Queue;
import tree.TreeNode;

/**
 * 111. 二叉树的最小深度
 *
 * @level easy
 * @date Created at 2022/6/21 9:47
 */
public class Solution111 {

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (isLeafNode(node)) {
                    return level;
                }
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            // 层数增加
            level++;
        }
        return level;
    }

    private static boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }


    public static void main(String[] args) {

        TreeNode r1r2 = new TreeNode(2, null, null);
        TreeNode r1l2 = new TreeNode(2, null, r1r2);
        TreeNode l1 = new TreeNode(2, null, r1l2);
        TreeNode r1 = new TreeNode(2, null, l1);
        TreeNode root = new TreeNode(2, null, r1);
        int i = minDepth(root);
        System.out.println("最小深度=【" + i + "】");
    }
}
