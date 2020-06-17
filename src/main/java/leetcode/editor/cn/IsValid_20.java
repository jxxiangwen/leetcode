package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * @author jxxiangwen
 *
 * Time: 20-5-27 下午5:03
 */
public class IsValid_20 {
    public boolean isValid(String s) {
        if (null == s || 0 == s.length()) {
            return true;
        }
        Map<Character, Character> map = new HashMap<>(3);
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            // 右括号，栈必须不为空切栈顶能匹配
            if (map.containsKey(current)) {
                if (stack.isEmpty()) {
                    return false;
                }
                Character top = stack.pop();
                if (!top.equals(map.get(current))) {
                    return false;
                } else {
                    continue;
                }
            }
            stack.push(current);
        }
        return stack.isEmpty();
    }

    @Test
    public void testIsValid() {
        Assert.assertTrue(isValid("()"));
        Assert.assertTrue(isValid("()[]{}"));
        Assert.assertTrue(!isValid("(]"));
        Assert.assertTrue(!isValid("([)]"));
    }
}
