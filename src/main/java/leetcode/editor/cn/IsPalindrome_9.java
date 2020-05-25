package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author jxxiangwen
 * Mail: xiangwen.zou@ymm56.com
 * Time: 20-5-25 下午4:48
 */
public class IsPalindrome_9 {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int reverse = 0;
        while (x > reverse) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }
        return x == reverse || x == reverse / 10;
    }

    @Test
    public void testIsPalindrome() {
        Assert.assertTrue(isPalindrome(9669));
        Assert.assertTrue(!isPalindrome(-9669));
        Assert.assertTrue(!isPalindrome(100));
        Assert.assertTrue(isPalindrome(0));
    }
}
