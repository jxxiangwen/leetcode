package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author jxxiangwen
 *
 * Time: 20-5-25 下午3:27
 */
public class myAtoi_8 {
    public int myAtoi(String str) {
        if (null == str || 0 == str.length()) {
            return 0;
        }
        char[] numbers = str.toCharArray();
        int result = 0;
        int length = numbers.length;
        int index = 0;
        while (index < length && numbers[index] == ' ') {
            index++;
        }
        if (index == length) {
            return 0;
        }
        boolean positive = true;
        char sigh = numbers[index];
        if (sigh == '+') {
            index++;
        }
        if (sigh == '-') {
            positive = false;
            index++;
        }
        boolean valid = false;
        boolean exceed = false;
        for (int i = index; i < length; i++) {
            int minus = numbers[i] - '0';
            if (minus > 9 || minus < 0) {
                break;
            }
            int tmp = result * 10 + minus;
            //判断是否大于 最大32位整数
            if (positive && (result > 214748364 || (result == 214748364 && minus >= 7))) {
                exceed = true;
                break;
            }
            //判断是否小于 最小32位整数
            if (!positive && (-result < -214748364 || (-result == -214748364 && minus >= 8))) {
                exceed = true;
                break;
            }
            valid = true;
            result = tmp;
        }
        if (!valid) {
            return 0;
        }
        if (exceed) {
            return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        return positive ? result : -result;
    }

    @Test
    public void testMyAtoi() {
        Assert.assertEquals(myAtoi("1"), 1);
        Assert.assertEquals(myAtoi("+1"), 1);
        Assert.assertEquals(myAtoi("-1"), -1);
        Assert.assertEquals(myAtoi("2147483648"), Integer.MAX_VALUE);
        Assert.assertEquals(myAtoi("1325135143634264363457"), Integer.MAX_VALUE);
        Assert.assertEquals(myAtoi("-1325135143634264363457"), Integer.MIN_VALUE);
        Assert.assertEquals(myAtoi("-91283472332"), Integer.MIN_VALUE);
        Assert.assertEquals(myAtoi("4193 with words"), 4193);
        Assert.assertEquals(myAtoi("words and 987"), 0);
        Assert.assertEquals(myAtoi("-   234"), 0);
        Assert.assertEquals(myAtoi("0-1"), 0);
        Assert.assertEquals(myAtoi("+"), 0);
    }
}
