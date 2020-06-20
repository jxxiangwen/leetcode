package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * @author jxxiangwen
 * Time: 20-6-20 下午4:34
 */
public class LetterCombinations_17 {
    public List<String> letterCombinations(String digits) {
        if (null == digits || 0 == digits.length()) {
            return Collections.emptyList();
        }
        Map<Character, String> mapped = new HashMap<>();
        mapped.put('1', "");
        mapped.put('2', "abc");
        mapped.put('3', "def");
        mapped.put('4', "ghi");
        mapped.put('5', "jkl");
        mapped.put('6', "mno");
        mapped.put('7', "pqrs");
        mapped.put('8', "tuv");
        mapped.put('9', "wxyz");
        List<String> result = new ArrayList<>();
        dfs(mapped, result, digits, 0, digits.length(), new StringBuilder());
        return result;
    }

    public void dfs(Map<Character, String> mapped, List<String> result, String digits, int depth, int maxDepth, StringBuilder current) {
        if (depth == maxDepth) {
            result.add(current.toString());
            return;
        }
        String mappingLetter = mapped.get(digits.charAt(depth));
        if (null == mappingLetter || 0 == mappingLetter.length()) {
            dfs(mapped, result, digits, depth + 1, maxDepth, current);
            return;
        }
        for (int i = 0; i < mappingLetter.length(); i++) {
            current.append(mappingLetter.charAt(i));
            dfs(mapped, result, digits, depth + 1, maxDepth, current);
            current.deleteCharAt(current.length() - 1);
        }
    }

    @Test
    public void testLetterCombinations() {
        List<String> strings = letterCombinations("213");
        List<String> result = Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
        Assert.assertEquals(strings.size(), result.size());
        result.forEach(strings::remove);
        Assert.assertEquals(strings.size(), 0);
    }
}
