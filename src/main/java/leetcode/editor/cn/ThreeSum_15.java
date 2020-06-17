package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jxxiangwen
 *
 * Time: 20-5-27 下午4:11
 */
public class ThreeSum_15 {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    while (j < k && nums[j] == nums[++j]) {
                    }
                } else if (sum > 0) {
                    while (j < k && nums[k] == nums[--k]) {
                    }
                } else {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < k && nums[j] == nums[++j]) {
                    }
                    while (j < k && nums[k] == nums[--k]) {
                    }
                }
            }
        }
        return result;
    }

    @Test
    public void testThreeSum() {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<Integer> result1 = Arrays.asList(-1, -1, 2);
        List<Integer> result2 = Arrays.asList(-1, 0, 1);
        List<List<Integer>> lists = Arrays.asList(result1, result2);
        Assert.assertEquals(threeSum(nums), lists);
    }
}
