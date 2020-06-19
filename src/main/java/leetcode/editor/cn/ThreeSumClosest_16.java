package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author jxxiangwen
 * Time: 20-6-19 下午5:28
 */
public class ThreeSumClosest_16 {
    public int threeSumClosest(int[] nums, int target) {
        if (null == nums || 3 > nums.length) {
            throw new IllegalArgumentException();
        }
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int temp = nums[i] + nums[start] + nums[end];
                if (Math.abs(result - target) > Math.abs(temp - target)) {
                    result = temp;
                }
                if (temp < target) {
                    start++;
                } else if (temp > target) {
                    end--;
                } else {
                    return target;
                }
            }
        }
        return result;
    }

    @Test
    public void testThreeSumClosest() {
        //  -4,-1,1,2
        int[] example = new int[]{-1, 2, 1, -4};
        int target = 1;
        Assert.assertEquals(threeSumClosest(example, target), 2);

        example = new int[]{0, 2, 1, -3};
        target = 1;
        Assert.assertEquals(threeSumClosest(example, target), 0);
    }
}
