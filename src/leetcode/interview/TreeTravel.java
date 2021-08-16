package leetcode.interview;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @program: leetcode
 * @description: 二叉树非递归遍历
 * @author: Mrpicker
 * @create: 2021-08-16 11:28
 **/
public class TreeTravel {

    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        while (!stack.empty() || root != null) {
            if (root != null) {
                list.add(root.val);
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop().right;
            }
        }

        return list;
    }

    public List<Integer> midorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        while (!stack.empty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode pop = stack.pop();
                list.add(pop.val);
                root = pop.right;
            }
        }

        return list;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> integerStack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        while (!stack.empty() || root != null) {
            if (root != null) {
                integerStack.push(root.val);
                stack.push(root);
                root = root.right;
            } else {
                root = stack.pop().left;
            }
        }

        while (!integerStack.empty()) {
            list.add(integerStack.pop());
        }
        return list;
    }
}
