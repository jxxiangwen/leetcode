package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author jxxiangwen
 *
 * Time: 20-6-11 下午8:39
 */
public class RemoveDuplicates_26 {

    public int removeDuplicates(int[] nums) {
        if (null == nums) {
            return 0;
        }
        if (2 > nums.length) {
            return nums.length;
        }
        int count = 1;
        int current = 0;
        int index = 1;
        while (index < nums.length) {
            if (nums[current] == nums[index]) {
                index++;
            } else {
                nums[++current] = nums[index++];
                count++;
            }
        }
        return count;
    }

    @Test
    public void testRemoveDuplicates() {
        int[] example = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        Assert.assertEquals(removeDuplicates(example), 5);
    }
}
