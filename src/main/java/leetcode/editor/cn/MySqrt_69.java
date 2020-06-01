package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author jxxiangwen
 * Mail: xiangwen.zou@ymm56.com
 * Time: 20-5-31 下午8:00
 */
public class MySqrt_69 {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int start = 0, end = x;
        int result = 0;
        while (start <= end) {
            int middle = start + (end - start) / 2;
            if (middle == x / middle) {
                result = middle;
                break;
            } else if (middle > x / middle) {
                end = middle - 1;
            } else {
                start = middle + 1;
                result = middle;
            }
        }
        return result;
    }

    @Test
    public void testMySqrt() {
        Assert.assertEquals(4, mySqrt(16));
        Assert.assertEquals(2, mySqrt(8));
    }
}
