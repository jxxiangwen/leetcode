package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author jxxiangwen
 *
 * Time: 20-5-25 下午5:15
 */
public class LongestCommonPrefix_14 {
    public String longestCommonPrefix(String[] strs) {
        if (null == strs || 0 == strs.length) {
            return "";
        }
        if (1 == strs.length) {
            return strs[0];
        }
        StringBuilder common = new StringBuilder();
        String first = strs[0];
        for (int i = 0; i < first.length(); i++) {
            char current = first.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (null == strs[j] || i >= strs[j].length() || strs[j].charAt(i) != current) {
                    return common.toString();
                }
            }
            common.append(current);
        }
        return common.toString();
    }

    @Test
    public void testLongestCommonPrefix() {
        Assert.assertEquals(longestCommonPrefix(new String[]{"flower", "flow", "flight"}), "fl");
        Assert.assertEquals(longestCommonPrefix(new String[]{"dog", "racecar", "car"}), "");
        Assert.assertEquals(longestCommonPrefix(new String[]{"", ""}), "");
        Assert.assertEquals(longestCommonPrefix(new String[]{"c", "c"}), "c");
    }
}
