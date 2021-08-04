package leetcode.swordToOffer;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @program: leetcode
 * @description: 树的子结构
 * @author: Mrpicker
 * @create: 2021-08-03 10:25
 **/
public class Ex26 {
    int maxDiameter = 0;

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 2, null, 3, null, 3);
        Ex26 ex26 = new Ex26();
        TreeNode root = ex26.geneteByBFSList(list);
//        TreeNode reverseRoot = ex26.invertTree(root);
        ex26.levelTravel(root);
    }

    public void levelTravel(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedBlockingQueue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode dequeue = queue.poll();
            System.out.println(dequeue.val);
            if (dequeue.left != null) {
                queue.offer(dequeue.left);
            }
            if (dequeue.right != null) {
                queue.offer(dequeue.right);
            }
        }
    }

    public TreeNode geneteByBFSList(List<Integer> list) {
        if (list.isEmpty()) {
            return null;
        }
        TreeNode root = new TreeNode(list.get(0));
        LinkedBlockingQueue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.offer(root);
        int curIdx = 1;
        while (!queue.isEmpty() && curIdx < list.size()) {
            Integer curVal = list.get(curIdx);
            TreeNode poll = null;
            if (curVal != null) {
                poll = queue.poll();
                poll.left = new TreeNode(curVal);
                queue.offer(poll.left);
            }
            curIdx++;
            if (curIdx >= list.size()) {
                break;
            }
            curVal = list.get(curIdx);
            if (curVal != null) {
                poll = poll != null ? poll : queue.poll();
                poll.right = new TreeNode(curVal);
                queue.offer(poll.right);
            }
            curIdx++;
        }
        return root;
    }

    /**
     * 相同的树，其它二叉树的基础
     *
     * @param A
     * @param B
     * @return
     */
    public boolean isSameTree(TreeNode A, TreeNode B) {
        if (A == null && B == null) {
            return true;
        }
        if (A == null || B == null) {
            return false;
        }
        return A.val == B.val && isSameTree(A.left, B.left) && isSameTree(A.right, B.right);
    }

    /**
     * 是否是子树，用isSameTree轻松解决
     *
     * @param root
     * @param subRoot
     * @return
     */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (isSameTree(root, subRoot)) {
            return true;
        }
        if (root == null) {
            return false;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    /**
     * 镜像翻转二叉树
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        invertTree(root.right);
        invertTree(root.left);
        return root;
    }

    /**
     * 是否是镜像对称的树
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return isSameTree(root, invertTree(root));
    }


    /**
     * 树的高度，路径类的基础
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    /**
     * 树中的最长直径，直径=左树高度+右树高度
     *
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int L = diameterOfBinaryTree(root.left);
        int R = diameterOfBinaryTree(root.right);
        maxDiameter = Math.max(maxDiameter, L + R);
        return Math.max(L, R) + 1;
    }

    /**
     * 是否是平衡二叉树,用到maxDepth
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return (Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1) && isBalanced(root.left) && isBalanced(root.right);
    }


    /**
     * 是否是单值树，即所有值相等
     *
     * @param root
     * @return
     */
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null && root.left.val != root.val) {
            return false;
        }
        if (root.right != null && root.right.val != root.val) {
            return false;
        }
        return isUnivalTree(root.left) && isUnivalTree(root.right);
    }

    /**
     * 合并两颗树
     *
     * @param root1
     * @param root2
     * @return
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode root = new TreeNode(root1.val + root2.val);
        root.left = mergeTrees(root1.left, root2.left);
        root.right = mergeTrees(root1.right, root2.right);
        return root;
    }

    /**
     * 是否是树的子结构，区别于子树，子结构只需要部分满足相等就行
     *
     * @param A
     * @param B
     * @return
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return A != null && B != null && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    private boolean recur(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }
        return recur(A.left, B.left) && recur(A.right, B.right);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {

        }

        TreeNode(int x) {
            val = x;
        }
    }
}
