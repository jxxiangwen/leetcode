package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * @author jxxiangwen
 * Mail: xiangwen.zou@ymm56.com
 * Time: 20-6-11 下午8:50
 */
public class DeleteDuplicates_82 {

    public ListNode deleteDuplicates(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode pre = new ListNode(0);
        ListNode preCurrent = pre;
        ListNode current = head;
        int lastValue = Integer.MAX_VALUE;
        while (null != current) {
            ListNode next = current.next;
            // 前中后不相等,当前结点加入新链表
            if (null != next && next.val != current.val && current.val != lastValue) {
                preCurrent.next = current;
                preCurrent = current;
            }
            // 遍历到最后,当前中不相等,当前结点也加入新链表
            if (null == next && current.val != lastValue) {
                preCurrent.next = current;
                preCurrent = current;
            }
            lastValue = current.val;
            current = current.next;
        }
        preCurrent.next = null;
        return pre.next;
    }

    @Test
    public void testDeleteDuplicates() {
        ListNode listNode = ListNode.createListNode(new int[]{1, 2, 3, 3, 4, 4, 5});
        ListNode returnNode = deleteDuplicates(listNode);
        ListNode result = ListNode.createListNode(new int[]{1, 2, 5});
        Assert.assertTrue(ListNode.listNodeEquals(returnNode, result));

        listNode = ListNode.createListNode(new int[]{1});
        returnNode = deleteDuplicates(listNode);
        result = ListNode.createListNode(new int[]{1});
        Assert.assertTrue(ListNode.listNodeEquals(returnNode, result));


        listNode = ListNode.createListNode(new int[]{1, 1});
        returnNode = deleteDuplicates(listNode);
        Assert.assertTrue(ListNode.listNodeEquals(returnNode, null));


        listNode = ListNode.createListNode(new int[]{1, 2, 2});
        returnNode = deleteDuplicates(listNode);
        result = ListNode.createListNode(new int[]{1});
        Assert.assertTrue(ListNode.listNodeEquals(returnNode, result));
    }
}
