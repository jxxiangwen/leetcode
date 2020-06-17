package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * @author jxxiangwen
 *
 * Time: 20-3-17 上午10:33
 */
public class TwoSum_1 {

    /**
     * 执行用时 : 60 ms, 在所有 Java 提交中击败了 21.07% 的用户
     * 内存消耗 : 39.5 MB, 在所有 Java 提交中击败了 5.06% 的用户
     *
     * @param nums
     * @param target
     * @return
     */
    private int[] twoSum(int[] nums, int target) {
        if (null == nums || nums.length < 2) {
            return null;
        }
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return null;
    }

    /**
     * 执行用时 : 3 ms, 在所有 Java 提交中击败了 99.58% 的用户
     * 内存消耗 : 42 MB, 在所有 Java 提交中击败了 5.06% 的用户
     *
     * @param nums
     * @param target
     * @return
     */
    private int[] twoSumHash(int[] nums, int target) {
        if (null == nums || nums.length < 2) {
            return null;
        }
        Map<Integer, Integer> maps = new HashMap<>(nums.length);
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            Integer index = maps.get(diff);
            if (null != index) {
                result[0] = index;
                result[1] = i;
                return result;
            }
            maps.put(nums[i], i);
        }
        return null;
    }

    @Test
    public void testTwoSum() {
        Assert.assertArrayEquals(twoSum(new int[]{2, 7, 11, 15}, 9), new int[]{0, 1});
        Assert.assertArrayEquals(twoSum(new int[]{2, 5, 5, 11}, 10), new int[]{1, 2});
    }

    @Test
    public void testTwoSumHash() {
        Assert.assertArrayEquals(twoSumHash(new int[]{2, 7, 11, 15}, 9), new int[]{0, 1});
        Assert.assertArrayEquals(twoSumHash(new int[]{2, 5, 5, 11}, 10), new int[]{1, 2});
    }
}
