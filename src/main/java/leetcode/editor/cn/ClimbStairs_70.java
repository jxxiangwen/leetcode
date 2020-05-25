package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author jxxiangwen
 * Mail: xiangwen.zou@ymm56.com
 * Time: 20-5-25 下午3:15
 */
public class ClimbStairs_70 {
    public int climbStairs(int n) {
        if (n < 3) {
            return n;
        }
        int result = 0;
        int pre_pre = 1;
        int pre = 2;
        for (int i = 3; i <= n; i++) {
            result = pre + pre_pre;
            pre_pre = pre;
            pre = result;
        }
        return result;
    }

    @Test
    public void testClimbStairs() {
        Assert.assertEquals(climbStairs(0), 0);
        Assert.assertEquals(climbStairs(1), 1);
        Assert.assertEquals(climbStairs(2), 2);
        Assert.assertEquals(climbStairs(3), 3);
        Assert.assertEquals(climbStairs(4), 5);
        Assert.assertEquals(climbStairs(5), 8);
    }
}
