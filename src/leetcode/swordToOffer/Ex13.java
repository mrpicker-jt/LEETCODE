package leetcode.swordToOffer;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @program: leetcode
 * @description: 机器人的运动范围
 * @author: Mrpicker
 * @create: 2021-08-02 15:03
 * <p>
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
 * 它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。
 * 请问该机器人能够到达多少个格子？
 **/
public class Ex13 {

    public static void main(String[] args) {
        System.out.println(movingCount(2, 3, 3));
    }

    public static int movingCount(int m, int n, int k) {
        int[][] grid = new int[m][n];
        int sum = 1;
        LinkedBlockingQueue<Pair<Integer, Integer>> pathQueue = new LinkedBlockingQueue<>();
        pathQueue.add(new Pair<>(0, 0));
        grid[0][0] = -1;
        while (!pathQueue.isEmpty()) {
            Pair<Integer, Integer> poll = pathQueue.poll();
            List<Pair<Integer, Integer>> nextBoxList = new ArrayList<>();
            nextBoxList.add(new Pair<>(poll.getKey(), poll.getValue() + 1));
            nextBoxList.add(new Pair<>(poll.getKey(), poll.getValue() - 1));
            nextBoxList.add(new Pair<>(poll.getKey() + 1, poll.getValue()));
            nextBoxList.add(new Pair<>(poll.getKey() - 1, poll.getValue()));
            for (Pair<Integer, Integer> box : nextBoxList) {
                Integer i = box.getKey();
                Integer j = box.getValue();
                if (checkBox(grid, i, j, k)) {
                    grid[i][j] = -1;
                    sum++;
                    pathQueue.offer(box);
                }
            }

        }
        return sum;
    }

    private static boolean checkBox(int[][] grid, int i, int j, int k) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return false;
        }
        if (grid[i][j] != 0) {
            return false;
        }
        if (getNumberSum(i) + getNumberSum(j) > k) {
            return false;
        }
        return true;
    }

    private static int getNumberSum(int i) {
        int sum = 0;
        while (i > 0) {
            sum += i % 10;
            i /= 10;
        }
        return sum;
    }

}
