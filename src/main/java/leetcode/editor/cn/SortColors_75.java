package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author jxxiangwen
 *
 * Time: 20-6-1 下午7:04
 */
public class SortColors_75 {
    public void sortColors(int[] nums) {
        int p0 = 0, current = 0;
        int p2 = nums.length - 1;
        while (current <= p2) {
            if (nums[current] == 0) {
                int tmp = nums[p0];
                nums[p0++] = nums[current];
                nums[current++] = tmp;
            } else if (nums[current] == 2) {
                int tmp = nums[current];
                nums[current] = nums[p2];
                nums[p2--] = tmp;
            } else {
                current++;
            }
        }
    }

    @Test
    public void testSortColors() {
        int[] example = new int[]{2, 0, 2, 1, 1, 0};
        sortColors(example);
        Assert.assertArrayEquals(example, new int[]{0, 0, 1, 1, 2, 2});
    }
}
