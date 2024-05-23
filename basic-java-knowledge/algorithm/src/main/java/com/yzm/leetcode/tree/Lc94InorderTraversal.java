package src.main.java.com.yzm.leetcode.tree;

import src.main.java.com.yzm.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * ##### 算法 leetcode 94 二叉树的中序遍历
 *
 * @author yzm
 * @date 2024/5/23
 */
public class Lc94InorderTraversal {
    List<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return list;
        }
        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
        return list;
    }
}
