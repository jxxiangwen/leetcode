package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * @author jxxiangwen
 * Mail: xiangwen.zou@ymm56.com
 * Time: 20-5-28 下午4:43
 */
public class Permute_46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (null == nums || 0 == nums.length) {
            return result;
        }
        Set<Integer> used = new HashSet<>();
        int depth = nums.length;
        dfs(nums, result, new ArrayList<>(), depth, 0, used);
        return result;
    }

    private void dfs(int[] nums, List<List<Integer>> result, List<Integer> currentResult, int depth, int currentDepth, Set<Integer> used) {
        if (depth == currentDepth) {
            result.add(new ArrayList<>(currentResult));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used.contains(nums[i])) {
                continue;
            }
            used.add(nums[i]);
            currentResult.add(nums[i]);
            dfs(nums, result, currentResult, depth, currentDepth + 1, used);
            used.remove(nums[i]);
            currentResult.remove((Object) nums[i]);
        }
    }

    @Test
    public void testPermute() {
        List<List<Integer>> permute = permute(new int[]{1, 2, 3});
        Assert.assertEquals(6, permute.size());
        Assert.assertTrue(permute.contains(Arrays.asList(1, 2, 3)));
        Assert.assertTrue(permute.contains(Arrays.asList(1, 3, 2)));
        Assert.assertTrue(permute.contains(Arrays.asList(2, 1, 3)));
        Assert.assertTrue(permute.contains(Arrays.asList(2, 3, 1)));
        Assert.assertTrue(permute.contains(Arrays.asList(3, 2, 1)));
        Assert.assertTrue(permute.contains(Arrays.asList(3, 1, 2)));
    }
}
