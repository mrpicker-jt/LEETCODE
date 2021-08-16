package leetcode.interview;

import java.util.Stack;

/**
 * @program: leetcode
 * @description: 两个栈实现一个队列
 * @author: Mrpicker
 * @create: 2021-08-16 11:24
 **/
public class CQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack2.empty() && stack1.empty()) {
            return -1;
        }
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
