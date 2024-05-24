package src.main.java.com.yzm.leetcode.tree;

import src.main.java.com.yzm.util.TreeNode;

/**
 * ##### 算法 leetcode 226 翻转二叉树
 *
 * @author yzm
 * @date 2024/5/25
 */
public class Lc226InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
