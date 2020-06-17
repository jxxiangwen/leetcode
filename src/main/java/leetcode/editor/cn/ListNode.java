package leetcode.editor.cn;

/**
 * @author jxxiangwen
 *
 * Time: 20-3-18 下午8:53
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static ListNode createListNode(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return null;
        }
        ListNode current = new ListNode(nums[0]);
        ListNode head = new ListNode(0);
        head.next = current;
        for (int i = 1; i < nums.length; i++) {
            current.next = new ListNode(nums[i]);
            current = current.next;
        }
        return head.next;
    }

    public static boolean listNodeEquals(ListNode first, ListNode second) {
        if (first == second) {
            return true;
        }
        while (null != first && null != second) {
            if (first.val != second.val) {
                return false;
            }
            first = first.next;
            second = second.next;
        }
        return null == first && null == second;
    }
}