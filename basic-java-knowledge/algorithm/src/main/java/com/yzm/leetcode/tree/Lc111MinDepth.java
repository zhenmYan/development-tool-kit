package src.main.java.com.yzm.leetcode.tree;

import src.main.java.com.yzm.util.TreeNode;

/**
 * ##### 算法 leetcode 111 二叉树的最小深度
 *
 *      描述
 *          给定一个二叉树，找出其最小深度。
 *          最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 *      思路
 *          - 分类讨论
 *          - root为空
 *          - root左右子树为空
 *          - 左子树为空
 *          - 右子树为空
 *          - 都不为空
 *
 * TODO 二刷
 *
 * @author yzm
 * @date 2024/5/23
 */
public class Lc111MinDepth {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 无子节点，返回1
        if (root.left == null && root.right == null) {
            return 1;
        }
        // 无左子树，返回右子树+1
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        // 无右子树，返回左子树+1
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }
        // 否则返回左右子树最小值+1
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
