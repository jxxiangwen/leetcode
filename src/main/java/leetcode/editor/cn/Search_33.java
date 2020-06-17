package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author jxxiangwen
 *
 * Time: 20-6-4 下午9:11
 */
public class Search_33 {

    public int search(int[] nums, int target) {
        if (null == nums || 0 == nums.length) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (target == nums[mid]) {
                return mid;
            }
            // 左边连续
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target <= nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // 右边连续
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    @Test
    public void testSearch() {
        int[] example = new int[]{4, 5, 6, 7, 0, 1, 2};
        Assert.assertEquals(search(example, 4), 0);
        Assert.assertEquals(search(example, 3), -1);
        Assert.assertEquals(search(example, 0), 4);
        example = new int[]{1};
        Assert.assertEquals(search(example, 1), 0);
        example = new int[]{5, 1, 2, 3, 4};
        Assert.assertEquals(search(example, 1), 1);
    }
}
