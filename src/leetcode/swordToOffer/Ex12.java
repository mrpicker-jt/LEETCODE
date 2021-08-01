package leetcode.swordToOffer;/**
 * Created by 姜腾 on 2021/8/1.
 */

/**
 * @program: leet-code
 * @description: 矩阵中的路径
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * @author: Mrpicker
 * @create: 2021-08-01 23:08
 * <p>
 * [["A","B","C","E"],["S","F","E","S"],["A","D","E","E"]]
 * "ABCESEEEFS"
 **/
public class Ex12 {
    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCESEEEFS";
        System.out.println(exist(board, word));
    }

    public static boolean exist(char[][] board, String word) {
        int[][] step = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (findPath(board, word, step, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean findPath(char[][] board, String word, int[][] step, int curI, int curJ) {
        if (curI < 0 || curI >= board.length || curJ < 0 || curJ >= board[0].length) {
            return false;
        }
        if (step[curI][curJ] != 0) {
            return false;
        }
        char curC = board[curI][curJ];
        if (curC != word.charAt(0)) {
            return false;
        }
        String newWord = word.substring(1);
        if (newWord.length() == 0) {
            return true;
        }
        step[curI][curJ] = -1;
        boolean res = findPath(board, newWord, step, curI, curJ - 1) ||
                findPath(board, newWord, step, curI, curJ + 1) ||
                findPath(board, newWord, step, curI + 1, curJ) ||
                findPath(board, newWord, step, curI - 1, curJ);
        step[curI][curJ] = 0;
        return res;
    }
}
