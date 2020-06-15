package leetcode.editor.cn;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * @author jxxiangwen
 * Mail: xiangwen.zou@ymm56.com
 * Time: 20-6-11 下午8:50
 */
public class DeleteDuplicates_83 {

    public ListNode deleteDuplicates(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode current = head;
        ListNode cursor = current.next;
        while (null != cursor) {
            if (current.val != cursor.val) {
                current.next = cursor;
                current = cursor;
            }
            cursor = cursor.next;
        }
        current.next = null;
        return pre.next;
    }
}
