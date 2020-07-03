package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

/**
 * @author jxxiangwen
 * Time: 20-6-30 下午2:10
 */
public class SwapPairs_34 {
    public ListNode swapPairs(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode sentinel = new ListNode(0);
        ListNode pre = sentinel;
        ListNode next = head;
        while (null != next && null != next.next) {
            ListNode current = next;
            next = next.next.next;
            pre.next = current.next;
            current.next.next = current;
            current.next = null;
            pre = pre.next.next;
        }
        pre.next = next;
        return sentinel.next;
    }

    @Test
    public void testSwapPairs() {
        System.out.println(new Date(System.currentTimeMillis()));
        ListNode origin = ListNode.createListNode(new int[]{1, 2, 3});
        ListNode swap = ListNode.createListNode(new int[]{2, 1, 3});
        ListNode result = swapPairs(origin);
        Assert.assertTrue(ListNode.listNodeEquals(swap, result));
        origin = ListNode.createListNode(new int[]{1, 2, 3, 4});
        swap = ListNode.createListNode(new int[]{2, 1, 4, 3});
        result = swapPairs(origin);
        Assert.assertTrue(ListNode.listNodeEquals(swap, result));

    }
}
