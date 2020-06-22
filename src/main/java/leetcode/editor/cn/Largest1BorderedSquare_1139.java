package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author jxxiangwen
 * Time: 20-6-22 上午11:16
 */
public class Largest1BorderedSquare_1139 {
    public int largest1BorderedSquare(int[][] grid) {
        if (null == grid || 0 == grid.length || null == grid[0] || 0 == grid[0].length) {
            return 0;
        }
        int row = grid.length;
        int column = grid[0].length;
        int max = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (0 == grid[i][j]) {
                    continue;
                }
                int endRow = i;
                int endColumn = j;
                while (endRow + 1 < row && endColumn + 1 < column) {
                    if (1 == grid[endRow + 1][j] && 1 == grid[i][endColumn + 1]) {
                        int length = endRow - i + 1;
                        if (length * length > max) {
                            int result = countRectangle(grid, row, column, i, endRow, j, endColumn);
                            if (result > max) {
                                max = result;
                            }
                        }
                        endRow++;
                        endColumn++;
                    } else {
                        break;
                    }
                }
                int length = endRow - i + 1;
                if (length * length > max) {
                    int result = countRectangle(grid, row, column, i, endRow, j, endColumn);
                    if (result > max) {
                        max = result;
                    }
                }
            }
        }
        return max;
    }

    public int countRectangle(int[][] grid, int row, int column, int startRow, int endRow, int startColumn, int endColumn) {
        if (startRow > row || endRow > row || startColumn > column || endColumn > column) {
            return 0;
        }
        if ((endRow - startRow) != (endColumn - startColumn)) {
            // 不是正方形
            return 0;
        }
        // 检查正方形每条边都为1
        for (int i = startRow; i <= endRow; i++) {
            if (grid[i][startColumn] == 0) {
                return 0;
            }
        }
        for (int i = startRow; i <= endRow; i++) {
            if (grid[i][endColumn] == 0) {
                return 0;
            }
        }
        for (int i = startColumn; i <= endColumn; i++) {
            if (grid[startRow][i] == 0) {
                return 0;
            }
        }
        for (int i = startColumn; i <= endColumn; i++) {
            if (grid[endRow][i] == 0) {
                return 0;
            }
        }
        int length = endRow - startRow + 1;
        return length * length;
    }

    @Test
    public void testLargest1BorderedSquare() {
        int[][] grid = new int[][]{
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        int result = largest1BorderedSquare(grid);
        Assert.assertEquals(result, 9);
        grid = new int[][]{
                {1, 1, 0, 0}
        };
        result = largest1BorderedSquare(grid);
        Assert.assertEquals(result, 1);

        grid = new int[][]{
                {0, 1, 1, 1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 1, 1, 1, 0, 1, 1},
                {1, 1, 1, 1, 0, 1, 1, 1},
                {1, 0, 1, 0, 0, 1, 1, 1},
                {0, 1, 1, 1, 1, 0, 1, 1}
        };
        result = largest1BorderedSquare(grid);
        Assert.assertEquals(result, 9);
    }
}
