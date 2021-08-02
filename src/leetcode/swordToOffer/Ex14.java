package leetcode.swordToOffer;

/**
 * @program: leetcode
 * @description: 剪绳子
 * @author: Mrpicker
 * @create: 2021-08-02 17:02
 * <p>
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 **/
public class Ex14 {
    public static void main(String[] args) {
        System.out.println(cuttingRope(33));
    }

    public static int cuttingRope(int n) {
        if (n <= 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int[] f = new int[n];
        f[0] = 0;
        f[1] = 1;
        f[2] = 2;
        for (int i = 3; i <=n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                f[i - 1] = Math.max(f[i - 1], Math.max(j * (i - j), f[i - 1 - j] * j));
            }
        }
        return f[n - 1];
    }
}
