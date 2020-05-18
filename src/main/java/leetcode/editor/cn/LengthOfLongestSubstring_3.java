package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jxxiangwen
 * Mail: xiangwen.zou@ymm56.com
 * Time: 20-5-13 下午9:00
 */
public class LengthOfLongestSubstring_3 {
    public int lengthOfLongestSubstring(String s) {
        // 记录字符上一次出现的位置
        int[] last = new int[128];
        for (int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();

        int max = 0;
        // 窗口开始位置
        int start = 0;
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i);
            // 当前字符串已经出现过，也就是要把上一次出现的下一个位置作为start
            if (last[index] != -1 && last[index] + 1 > start) {
                start = last[index] + 1;
            }
            max = Math.max(max, i - start + 1);
            last[index] = i;
        }

        return max;
    }

    @Test
    public void testAddTwoNumbers() {
        Assert.assertEquals(lengthOfLongestSubstring("abcabcbb"), 3);
        Assert.assertEquals(lengthOfLongestSubstring("bbbbb"), 1);
        Assert.assertEquals(lengthOfLongestSubstring("pwwkew"), 3);
        Assert.assertEquals(lengthOfLongestSubstring("au"), 2);
        Assert.assertEquals(lengthOfLongestSubstring("tmmzuxt"), 5);
    }
}
