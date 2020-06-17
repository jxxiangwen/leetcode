package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jxxiangwen
 *
 * Time: 20-5-20 下午7:53
 */
public class Solve_130 {
    public void solve(char[][] board) {
        int row = board.length;
        if (row == 0 ) {//行是0再拿列会报错
            return;
        }
        int col = board[0].length;
        Queue<int []> q = new LinkedList<>();//存取之后拿到的 .
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //下标为第0列、行和下标最后一列、行之外的都不做操作 跳过
                if ((i > 0 && i < row - 1) && (j > 0 && j <col - 1))
                    continue;
                //边界为O的加入队列，并且把边界设置为.
                if (board[i][j] == 'O'){
                    q.add(new int[]{i, j});
                    board[i][j] = '.';
                }
            }
        }

        while (!q.isEmpty()){
            //size每次进来都不一样 先在外面定义size
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                int [] cur = q.poll();
                int r = cur[0];//取出行的值
                int c = cur[1];//取出列的值
                if (r > 0 && board[r - 1][c] == 'O') {//查找'.'的上边
                    board[r - 1][c] = '.';
                    q.add(new int[]{r - 1,c});//找到了，把当前位置也要加入队列
                }

                if (r + 1 < row && board[r + 1][c] == 'O') {//找下边
                    board[r + 1][c] = '.';
                    q.add(new int[]{r + 1,c});
                }

                if (c > 0 && board[r][c - 1] == 'O') {//左边
                    board[r][c - 1] = '.';
                    q.add(new int[]{r,c - 1});
                }

                if (c + 1 < col && board[r][c + 1] == 'O') {//右边
                    board[r][c + 1] = '.';
                    q.add(new int[]{r,c + 1});
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                board[i][j] = board[i][j]=='.'?'O':'X';//是.就把他设置为O 不是就是设置为X
            }
        }

    }

    @Test
    public void testSolve() {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'O', 'O', 'X', 'X'}
        };

        char[][] result = {
                {'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X'},
                {'O', 'O', 'X', 'X'}
        };
        solve(board);
        Assert.assertArrayEquals(board[0], result[0]);
        Assert.assertArrayEquals(board[1], result[1]);
        Assert.assertArrayEquals(board[2], result[2]);
        Assert.assertArrayEquals(board[3], result[3]);
    }
}
