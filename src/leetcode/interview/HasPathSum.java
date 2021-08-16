package leetcode.interview;

import leetcode.TreeNode;

/**
 * @program: leetcode
 * @description: 路径总和
 * @author: Mrpicker
 * @create: 2021-08-16 15:41
 **/
public class HasPathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.val == targetSum && root.left == null && root.right == null) {
            return true;
        }
        int i = targetSum - root.val;
        return hasPathSum(root.left, i) || hasPathSum(root.right, i);
    }
}
