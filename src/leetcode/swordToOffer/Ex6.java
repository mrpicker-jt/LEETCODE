package leetcode.swordToOffer;

import leetcode.ListNode;

import java.util.Stack;

/**
 * @program: leetcode
 * @description: 从尾到头输出链表
 * @author: Mrpicker
 * @create: 2021-08-02 16:54
 **/
public class Ex6 {
    public static void main(String[] args) {

    }

    public static int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        int idx = 0;
        while (!stack.empty()) {
            res[idx] = stack.pop();
            idx++;
        }
        return res;

    }


}
