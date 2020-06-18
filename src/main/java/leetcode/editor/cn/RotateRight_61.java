package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author jxxiangwen
 * Time: 20-6-18 下午9:01
 */
public class RotateRight_61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (null == head || k == 0 || null == head.next) {
            return head;
        }
        int length = 0;
        ListNode count = head;
        while (null != count) {
            length++;
            count = count.next;
        }
        k = k % length;
        if (k == 0) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (k > 0 && null != fast) {
            fast = fast.next;
            k--;
        }
        // k比链表长度要长
        if (k > 0 || null == fast) {
            return head;
        }
        while (null != fast.next) {
            fast = fast.next;
            slow = slow.next;
        }
        ListNode pre = new ListNode(0);
        pre.next = slow.next;
        ListNode current = slow.next;
        slow.next = null;
        while (null != current.next) {
            current = current.next;
        }
        current.next = head;
        return pre.next;
    }

    @Test
    public void testRotateRight() {
        ListNode initNode = ListNode.createListNode(new int[]{1, 2, 3, 4, 5});
        ListNode result = ListNode.createListNode(new int[]{4, 5, 1, 2, 3});
        Assert.assertTrue(ListNode.listNodeEquals(rotateRight(initNode, 2), result));
        initNode = ListNode.createListNode(new int[]{1, 2, 3, 4, 5});
        result = ListNode.createListNode(new int[]{1, 2, 3, 4, 5});
        Assert.assertTrue(ListNode.listNodeEquals(rotateRight(initNode, 5), result));

    }
}
