package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 *
 * @author jxxiangwen
 * Time: 20-6-20 下午6:01
 */
public class NumTrees_96 {
    public int numTrees(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        // dp存储的值为二叉搜索树的种类
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    @Test
    public void testNumTrees() {
        Assert.assertEquals(numTrees(3), 5);
    }
}
