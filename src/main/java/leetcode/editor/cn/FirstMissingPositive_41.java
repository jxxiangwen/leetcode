package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author jxxiangwen
 *
 * Time: 20-5-27 下午5:58
 */
public class FirstMissingPositive_41 {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            while (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
                // 满足在指定范围内、并且没有放在正确的位置上，才交换
                // 例如：数值 3 应该放在索引 2 的位置上
                swap(nums, nums[i] - 1, i);
            }
        }

        // [1, -1, 3, 4]
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        // 都正确则返回数组长度 + 1
        return len + 1;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    @Test
    public void test() {
        Assert.assertEquals(firstMissingPositive(new int[]{1, 2, 0}), 3);
        Assert.assertEquals(firstMissingPositive(new int[]{3, 4, -1, 1}), 2);
        Assert.assertEquals(firstMissingPositive(new int[]{7, 8, 9, 11, 12}), 1);
    }
}
