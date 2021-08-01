package leetcode.swordToOffer;
/**
 * Created by 姜腾 on 2021/8/1.
 */

/**
 * @program: leet-code
 * @description: 旋转数组的最小数字
 * @author: Mrpicker
 * @create: 2021-08-01 22:28
 **/
public class Ex11 {
    public static void main(String[] args) {
        int[] array={1};
        System.out.println(minArray(array));
    }

    public static int minArray(int[] numbers) {
        int lo = 0;
        int hi = numbers.length - 1;
        while (lo < hi) {
            int mid = (hi - lo) / 2 + lo;
            if (numbers[mid] < numbers[hi]) {
                //如果mid小于hi，那么mid右边的元素可以舍弃
                hi = mid;
            } else if (numbers[mid] > numbers[hi]) {
                //如果mid大于hi，那么mid左边的元素包括mid都可以舍弃
                lo = mid + 1;
            } else {
                //无法判断出mid的位置，但可以先舍弃一个重复值lo
                lo--;
            }
        }
        return numbers[lo];
    }
}
