package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author jxxiangwen
 *
 * Time: 20-5-15 下午2:54
 */
public class AddStrings_415 {

    public String addStrings(String num1, String num2) {
        if (null == num1 || null == num2) {
            return "";
        }
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        char[] result = new char[Math.max(num1.length(), num2.length()) + 1];
        int length = result.length - 1;
        while (i >= 0 || j >= 0) {
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int res = n1 + n2 + carry;
            result[length] = (char) ((res % 10) + '0');
            carry = res / 10;
            i--;
            j--;
            length--;
        }
        if (carry == 1) {
            result[length] = '1';
        }
        return new String(result).trim();
    }

    @Test
    public void addStrings() {
        Assert.assertEquals(addStrings("125", "956"), "1081");
        Assert.assertEquals(addStrings("1", "9"), "10");
    }


}
