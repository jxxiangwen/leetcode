package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author jxxiangwen
 * Time: 20-6-29 下午8:44
 */
public class FindRepeatNumber_offer_03 {

    public int findRepeatNumber(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return -1;
        }
        for (int i = 0; i < nums.length; i++) {
            while (i != nums[i]) {
                if (nums[nums[i]] == nums[i]) {
                    return nums[i];
                } else {
                    int temp = nums[nums[i]];
                    nums[nums[i]] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        return -1;
    }

    @Test
    public void testFindRepeatNumber() {
        int[] example = new int[]{2, 3, 1, 0, 2, 5, 3};
        int repeatNumber = findRepeatNumber(example);
        Assert.assertTrue(2 == repeatNumber || 3 == repeatNumber);
    }
}
