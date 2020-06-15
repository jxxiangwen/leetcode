package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author jxxiangwen
 * Mail: xiangwen.zou@ymm56.com
 * Time: 20-6-9 下午7:27
 */
public class Rotate_189 {

    public void rotate(int[] nums, int k) {
        if (k > nums.length) {
            k = k % nums.length;
        }
        reverser(nums, 0, nums.length - 1);
        reverser(nums, 0, k - 1);
        reverser(nums, k, nums.length - 1);
    }


    private void reverser(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    @Test
    public void testRotate() {
        int[] example = new int[]{1, 2, 3, 4, 5, 6, 7};
        int[] result = new int[]{5, 6, 7, 1, 2, 3, 4};
        rotate(example, 3);
        Assert.assertArrayEquals(result, example);
    }
}
