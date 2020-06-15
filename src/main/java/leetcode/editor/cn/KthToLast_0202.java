package leetcode.editor.cn;

public class KthToLast_0202 {
    public int kthToLast(ListNode head, int k) {
        if (null == head || 1 > k) {
            throw new IllegalArgumentException();
        }
        ListNode current = head;
        for (int i = 0; i < k; i++) {
            if (null == current) {
                throw new IllegalArgumentException();
            }
            current = current.next;
        }
        while (null != current) {
            head = head.next;
            current = current.next;
        }
        return head.val;
    }
}
