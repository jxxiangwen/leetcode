package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

public class ReverseList_206 {
    public ListNode reverseList(ListNode head) {
        if (null == head) {
            return null;
        }
        ListNode sentinel = new ListNode(0);
        while (null != head) {
            ListNode current = head;
            head = head.next;
            current.next = sentinel.next;
            sentinel.next = current;
        }
        return sentinel.next;
    }

    @Test
    public void testReverseList() {
        ListNode listNode = ListNode.createListNode(new int[]{1, 2, 3, 4, 5});
        ListNode result = ListNode.createListNode(new int[]{5, 4, 3, 2, 1});
        Assert.assertTrue(ListNode.listNodeEquals(reverseList(listNode), result));
    }
}
