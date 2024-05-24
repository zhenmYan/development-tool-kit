package src.main.java.com.yzm.leetcode.tree;

import src.main.java.com.yzm.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * ##### 算法 leetcode 98 验证二叉搜索树
 *
 *      思路
 *          解法1：中序遍历无逆序
 *          解法2：递归
 *
 *
 * @author yzm
 * @date 2024/5/23
 */
public class Lc98IsValidBST {

    // 解法1 中序遍历无逆序
    List<Integer> list = new ArrayList<>();
    public boolean isValidBST1(TreeNode root) {
        isValid1(root);
        for(int i = 0; i < list.size()-1; i++) {
            if (list.get(i) >= list.get(i+1)){
                return false;
            }
        }
        return true;
    }
    // 中序遍历
    private void isValid1(TreeNode node){
        if (node == null) {
            return;
        }
        isValid1(node.left);
        list.add(node.val);
        isValid1(node.right);
    }


    // 解法2 递归
    public boolean isValidBST(TreeNode root) {
        return isValid2(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    // 带最大值、最小值的递归
    private boolean isValid2(TreeNode node, Long min, Long max) {
        if (node == null) {
            return true;
        }
        if (node.val >= max || node.val <= min) {
            return false;
        }
        return isValid2(node.left, min, (long) node.val)
                && isValid2(node.right, (long) node.val, max);
    }
}
