package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class ValidateStackSequences_946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (null == pushed || null == popped) {
            return false;
        }
        if (pushed.length != popped.length) {
            return false;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int push = 0;
        int pop = 0;
        while (pop < popped.length) {
            int current = popped[pop];
            if (stack.size() > 0 && current == stack.peek()) {
                stack.pop();
                pop++;
            } else if (push < pushed.length) {
                stack.push(pushed[push]);
                push++;
            } else {
                return false;
            }
        }
        return pop == popped.length && push == pushed.length;
    }

    @Test
    public void testValidateStackSequences() {
        int[] in = new int[]{1, 2, 3, 4, 5};
        int[] out = new int[]{4, 5, 3, 2, 1};
        Assert.assertTrue(validateStackSequences(in, out));
    }
}
