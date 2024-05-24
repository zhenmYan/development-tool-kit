package src.main.java.com.yzm.leetcode.tree;

import src.main.java.com.yzm.util.TreeNode;

/**
 * ##### 算法 leetcode 101 对称二叉树
 *
 * @author yzm
 * @date 2024/5/24
 */
public class Lc101IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }
    public boolean isSymmetric(TreeNode node1, TreeNode node2) {
        // 都为空
        if (node1 == null && node2 == null) {
            return true;
        }
        // 有一个为空
        if (node1 == null || node2 == null) {
            return false;
        }
        if (node1.val != node2.val) {
            return false;
        }
        // 都不为空
        return isSymmetric(node1.left, node2.right)
                && isSymmetric(node1.right, node2.left);
    }
}
