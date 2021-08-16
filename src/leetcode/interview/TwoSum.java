package leetcode.interview;

/**
 * @program: leetcode
 * @description: 两数之和
 * @author: Mrpicker
 * @create: 2021-08-16 16:46
 **/
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            int dest=target-nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j]==dest){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }
}
