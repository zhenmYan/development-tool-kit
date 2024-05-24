package src.main.java.com.yzm.leetcode.tree;

import src.main.java.com.yzm.util.TreeNode;

/**
 * description:
 *
 * @author yzm
 * @date 2024/5/23
 */
public class Lc98IsValidBST {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        // 当前节点为空 返回true
        if (root == null) {
            return true;
        }
        // 左节点不为空，判断大小，记录最小值
        if (root.left != null) {
            min = Math.min(root.val, min);
            if (root.left.val >= root.val || root.left.val >= min) {
                return false;
            }
        }
        // 右节点不为空，判断大小，记录最大值
        if (root.right != null) {
            max = Math.max(root.val, max);
            if (root.right.val <= root.val || root.right.val <= max) {
                return false;
            }
        }
        return isValidBST(root.left) && isValidBST(root.right);
    }
}
