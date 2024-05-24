package src.main.java.com.yzm.leetcode.tree;

import src.main.java.com.yzm.util.TreeNode;

/**
 * ##### 算法 leetcode 105 从前序与中序遍历序列构造二叉树
 *
 * TODO 二刷
 *
 * @author yzm
 * @date 2024/5/25
 */
public class Lc105BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    public static TreeNode buildTree(int[] preorder, int preL, int preR, int[] inorder, int inL, int inR){
        if (preL > preR || inL > inR){
            return null;
        }
        int mid = 0;
        int val = preorder[preL];
        TreeNode node = new TreeNode(val);
        for(int i = inL; i <= inR; i++){
            if (inorder[i] == val){
                mid = i;
                break;
            }
        }
        int lLen = mid - inL;
        int rLen = inR - mid;
        node.left = buildTree(preorder, preL+1, preL + lLen, inorder, inL, inL+lLen-1);
        node.right = buildTree(preorder, preL+lLen+1, preR, inorder, mid+1, inR);
        return node;
    }
}
