package leetcode.interview;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description: 二叉树的层序遍历
 * @author: Mrpicker
 * @create: 2021-08-16 15:59
 **/
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<TreeNode> candidateQueue = new ArrayList<>();
        List<List<Integer>> intQueueList = new ArrayList<>();
        candidateQueue.add(root);
        while (!candidateQueue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            List<TreeNode> newQueue = new ArrayList<>();
            for (int i = 0; i < candidateQueue.size(); i++) {
                TreeNode treeNode = candidateQueue.get(i);
                list.add(treeNode.val);
                if (treeNode.left != null) {
                    newQueue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    newQueue.add(treeNode.right);
                }
            }
            intQueueList.add(list);
            candidateQueue = newQueue;
        }
        return intQueueList;
    }
}
