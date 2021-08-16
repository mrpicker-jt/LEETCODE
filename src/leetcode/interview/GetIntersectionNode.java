package leetcode.interview;

import leetcode.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: leetcode
 * @description: 相交链表
 * @author: Mrpicker
 * @create: 2021-08-16 11:06
 **/
public class GetIntersectionNode {
    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode temp = headA;
        while (temp != null) {
            set.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            if (set.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;
        while (tempA != null || tempB != null) {
            if (tempA == tempB) {
                return tempA;
            }
            if (tempA == null) {
                tempA = headB;
                tempB = tempB.next;
                continue;
            }
            if (tempB == null) {
                tempA = tempA.next;
                tempB = headA;
                continue;
            }
            tempA = tempA.next;
            tempB = tempB.next;
        }
        return null;
    }
}
