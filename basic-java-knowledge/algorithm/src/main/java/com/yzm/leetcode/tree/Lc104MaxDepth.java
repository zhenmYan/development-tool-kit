package src.main.java.com.yzm.leetcode.tree;

import src.main.java.com.yzm.util.TreeNode;

/**
 * ##### 算法 leetcode 104 二叉树的最大深度
 *
 * @author yzm
 * @date 2024/5/25
 */
public class Lc104MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 取左右子树最大值+1
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
