package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jxxiangwen
 * Time: 20-6-20 下午1:45
 */
public class FourSum_18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (null == nums || 4 > nums.length) {
            return result;
        }
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 剪枝
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if (nums[length - 1] + nums[length - 2] + nums[length - 3] + nums[length - 4] < target) {
                break;
            }
            for (int j = i + 1; j < length - 2; j++) {
                // 剪枝
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    continue;
                }
                if (nums[i] + nums[j] + nums[length - 1] + nums[length - 2] < target) {
                    continue;
                }
                int start = j + 1;
                int end = length - 1;
                while (start < end) {
                    int sum = nums[i] + nums[j] + nums[start] + nums[end];
                    if (sum == target) {
                        List<Integer> integers = Arrays.asList(nums[i], nums[j], nums[start], nums[end]);
                        if (!result.contains(integers)) {
                            result.add(integers);
                        }
                    }
                    if (sum > target) {
                        end--;
                    } else {
                        start++;
                    }
                }
            }
        }
        return result;
    }

    @Test
    public void testFourSum() {
        int[] example = new int[]{1, 0, -1, 0, -2, 2};
        List<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.asList(-1, 0, 0, 1));
        result.add(Arrays.asList(-2, -1, 1, 2));
        result.add(Arrays.asList(-2, 0, 0, 2));
        List<List<Integer>> lists = fourSum(example, 0);
        Assert.assertEquals(result.size(), lists.size());
        lists.forEach(result::remove);
        Assert.assertEquals(result.size(), 0);


        example = new int[]{-3, -1, 0, 2, 4, 5};
        result = new ArrayList<>();
        result.add(Arrays.asList(-3, -1, 2, 4));
        lists = fourSum(example, 2);
        Assert.assertEquals(result.size(), lists.size());
        lists.forEach(result::remove);
        Assert.assertEquals(result.size(), 0);
    }
}
