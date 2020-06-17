package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author jxxiangwen
 *
 * Time: 20-5-31 下午7:47
 */
public class MyPow_50 {

    public double myPow(double x, int n) {
        boolean negative = false;
        long b = n;
        if (b < 0) {
            b = -b;
            negative = true;
        }
        double result = pow(x, b);
        return negative ? 1 / result : result;
    }

    public double pow(double x, long n) {
        if (n == 1) {
            return x;
        }
        if (n == 0) {
            return 1;
        }
        double result = pow(x, n >> 1);
        if (n % 2 == 1) {
            return result * result * x;
        }
        return result * result;
    }

    @Test
    public void testMyPow() {
        Assert.assertEquals(1024.0d, myPow(2.0, 10), 0.1);
        Assert.assertEquals(1.0, myPow(0.44528, 0), 0.1);
    }
}
