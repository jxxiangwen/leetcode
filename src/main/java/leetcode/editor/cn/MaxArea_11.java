package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author jxxiangwen
 * Mail: xiangwen.zou@ymm56.com
 * Time: 20-5-25 下午4:36
 */
public class MaxArea_11 {
    public int maxArea(int[] height) {
        if (null == height || 0 == height.length) {
            return 0;
        }
        int i = 0;
        int j = height.length - 1;
        int result = 0;
        while (i < j) {
            int temp = (j - i) * Math.min(height[i], height[j]);
            result = Math.max(temp, result);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return result;
    }

    @Test
    public void testMaxArea() {
        Assert.assertEquals(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}), 49);
    }
}
