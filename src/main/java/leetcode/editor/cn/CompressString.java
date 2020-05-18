package leetcode.editor.cn; /**
 * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
 * <p>
 * 示例1:
 * <p>
 * 输入："aabcccccaaa"
 * 输出："a2b1c5a3"
 * 示例2:
 * <p>
 * 输入："abbccd"
 * 输出："abbccd"
 * 解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
 * 提示：
 * <p>
 * 字符串长度在[0, 50000]范围内。
 * 通过次数8,105提交次数16,210
 */

import org.junit.Assert;
import org.junit.Test;

/**
 * @author jxxiangwen
 * Mail: xiangwen.zou@ymm56.com
 * Time: 20-3-16 上午11:01
 */
public class CompressString {

    private String compressString(String s) {
        if (null == s || 0 == s.length()) {
            return s;
        }
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = s.toCharArray();
        char old = chars[0];
        int length = 1;
        for (int i = 1; i < chars.length; i++) {
            if (old != chars[i]) {
                stringBuilder.append(old);
                stringBuilder.append(length);
                old = chars[i];
                length = 1;
            } else {
                length++;
            }
        }
        stringBuilder.append(old);
        stringBuilder.append(length);
        if (s.length() <= stringBuilder.length()) {
            return s;
        }
        return stringBuilder.toString();
    }

    @Test
    public void testCompressString() {
        Assert.assertEquals("a2b1c5a3", compressString("aabcccccaaa"));
        Assert.assertEquals("", compressString(""));
        Assert.assertEquals("abbccd", compressString("abbccd"));
        Assert.assertEquals("a", compressString("a"));
        Assert.assertEquals("bb", compressString("bb"));
    }
}
