package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

public class Multiply_43 {
    public String multiply(String num1, String num2) {
        if (null == num1 || null == num2 || 0 == num1.length() || 0 == num2.length()) {
            return null;
        }
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int[] result = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                int sum = result[i + j + 1] + n1 * n2;
                result[i + j + 1] = sum % 10;
                result[i + j] += sum / 10;
            }
        }
        int start = 0;
        if (result[0] == 0) {
            start = 1;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = start; i < result.length; i++) {
            stringBuilder.append(result[i]);
        }
        return stringBuilder.toString();
    }

    @Test
    public void testMultiply() {
        Assert.assertEquals("56088", multiply("123", "456"));
    }
}
