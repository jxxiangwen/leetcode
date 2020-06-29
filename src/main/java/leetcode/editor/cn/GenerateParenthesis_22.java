package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jxxiangwen
 * Time: 20-6-28 下午5:41
 */
public class GenerateParenthesis_22 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }
        dfs(0, n * 2, result, n, n, new StringBuilder());
        return result;
    }

    public void dfs(int currentDepth, int maxDepth, List<String> result, int left, int right, StringBuilder cache) {
        if (left > right) {
            return;
        }
        if (currentDepth == maxDepth) {
            result.add(cache.toString());
            return;
        }
        if (left > 0) {
            dfs(currentDepth + 1, maxDepth, result, left - 1, right, cache.append("("));
            cache.deleteCharAt(cache.length() - 1);
        }
        if (right > left) {
            dfs(currentDepth + 1, maxDepth, result, left, right - 1, cache.append(")"));
            cache.deleteCharAt(cache.length() - 1);
        }
    }

    @Test
    public void testGenerateParenthesis() {
        List<String> result = Arrays.asList("((()))",
                "(()())",
                "(())()",
                "()(())",
                "()()()");
        List<String> strings = generateParenthesis(3);
        Assert.assertEquals(strings.size(), result.size());
        result.forEach(strings::remove);
        Assert.assertEquals(strings.size(), 0);

        result = Arrays.asList("()");
        strings = generateParenthesis(1);
        Assert.assertEquals(strings.size(), result.size());
        result.forEach(strings::remove);
        Assert.assertEquals(strings.size(), 0);
    }
}
