package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author jxxiangwen
 * Time: 20-6-23 上午11:07
 */
public class DeleteAndEarn_740 {
    public int deleteAndEarn(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return 0;
        }
        if (1 == nums.length) {
            return nums[0];
        }
        int max = 0;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }
        int[] count = new int[max + 1];
        for (int num : nums) {
            count[num]++;
        }
        int[] dp = new int[max + 1];
        dp[1] = count[1];
        dp[2] = Math.max(dp[1], count[2] * 2);
        for (int i = 3; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + i * count[i]);
        }
        return dp[max];
    }

    @Test
    public void testDeleteAndEarn() {
        int[] example = new int[]{2, 2, 3, 3, 3, 4};
        int result = deleteAndEarn(example);
        Assert.assertEquals(result, 9);
    }
}
