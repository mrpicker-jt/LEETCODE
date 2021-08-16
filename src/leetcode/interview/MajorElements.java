package leetcode.interview;

import java.util.HashMap;

/**
 * @program: leetcode
 * @description: 多数元素
 * @author: Mrpicker
 * @create: 2021-08-16 16:15
 **/
public class MajorElements {


    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            map.putIfAbsent(num, 0);
            int count = map.get(num) + 1;
            if (count > nums.length / 2) {
                return num;
            }
            map.put(num, count);
        }
        return -1;
    }

    public int majorityElement2(int[] nums) {
        int canNum = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (canNum == nums[i]) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                canNum = nums[i];
                count = 1;
            }

        }
        return canNum;
    }


}
