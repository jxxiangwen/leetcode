package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

public class VerifyPostorder_33 {
    public boolean verifyPostorder(int[] postorder) {
        if(null == postorder || 0 == postorder.length){
            return true;
        }
        return verify(postorder, 0, postorder.length);
    }

    public boolean verify(int[] postorder, int start, int end) {
        if (null == postorder || 1 > postorder.length || start > end || start < 0 || end > postorder.length) {
            return false;
        }
        if (start == end) {
            return true;
        }
        int root = postorder[end - 1];
        int less = start;
        for (int i = start; i < end - 1; i++) {
            if (postorder[i] < root) {
                less++;
            }
        }
        int more = less;
        for (int i = more; i < end - 1; i++) {
            if (postorder[i] < root) {
                return false;
            }
            more++;
        }
        boolean left = true;
        if (less > start) {
            left = verify(postorder, start, less);
        }
        boolean right = true;
        if (more < end) {
            right = verify(postorder, less, end - 1);
        }
        return left && right;
    }

    @Test
    public void testVerifyPostorder() {
        Assert.assertFalse(verifyPostorder(new int[]{1, 6, 3, 2, 5}));
        Assert.assertTrue(verifyPostorder(new int[]{1, 3, 2, 6, 5}));
    }
}
