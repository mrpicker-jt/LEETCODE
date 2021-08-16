package leetcode.interview;

import java.util.HashMap;

/**
 * @program: leetcode
 * @description: 无重复字符的最长子串
 * @author: Mrpicker
 * @create: 2021-08-16 10:54
 **/
public class LengthOfLongestSubstring {
    public static void main(String[] args) {

    }

    private static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            maxLength = Math.max(maxLength, i - left + 1);
        }
        return maxLength;
    }
}
