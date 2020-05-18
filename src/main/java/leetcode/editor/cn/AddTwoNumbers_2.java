package leetcode.editor.cn; /**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */

import org.junit.Assert;
import org.junit.Test;

/**
 * @author jxxiangwen
 * Mail: xiangwen.zou@ymm56.com
 * Time: 20-3-18 下午8:52
 */
public class AddTwoNumbers_2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int overflow = 0;
        ListNode result = l1;
        ListNode walkbefore = null;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + overflow;
            if (sum < 10) {
                overflow = 0;
                l1.val = sum;
            } else {
                overflow = 1;
                l1.val = sum - 10;
            }
            if (null == walkbefore) {
                walkbefore = l1;
            } else {
                walkbefore = walkbefore.next;
            }
            l1 = l1.next;
            l2 = l2.next;

        }
        ListNode left = null;
        if (null != l1) {
            left = l1;
        }
        if (null != l2) {
            left = l2;
        }
        while (null != left) {
            int sum = left.val + overflow;
            if (null == walkbefore) {
                walkbefore = left;
            } else {
                walkbefore.next = left;
                walkbefore = left;
            }
            if (sum < 10) {
                left.val = sum;
                overflow = 0;
                break;
            } else {
                overflow = 1;
                left.val = 0;
            }
            left = left.next;
        }
        if (overflow != 0) {
            walkbefore.next = new ListNode(1);
        }
        return result;
    }

    public boolean nodeEquals(ListNode first, ListNode second) {
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

    @Test
    public void testAddTwoNumbers() {
        // 输入：(2,4,3) + (5,6,4)
        // 输出：7,0,8
        ListNode first = new ListNode(2);
        first.next = new ListNode(4);
        first.next.next = new ListNode(3);

        ListNode second = new ListNode(5);
        second.next = new ListNode(6);
        second.next.next = new ListNode(4);

        ListNode result = new ListNode(7);
        result.next = new ListNode(0);
        result.next.next = new ListNode(8);
        Assert.assertTrue(nodeEquals(result, addTwoNumbers(first, second)));

        // 输入：(5) + (5)
        // 输出：0,1
        first = new ListNode(5);
        second = new ListNode(5);
        result = new ListNode(0);
        result.next = new ListNode(1);
        Assert.assertTrue(nodeEquals(result, addTwoNumbers(first, second)));

        // 输入：(0) + (7,3)
        // 输出：7,3
        first = new ListNode(0);
        second = new ListNode(7);
        second.next = new ListNode(3);
        result = new ListNode(7);
        result.next = new ListNode(3);
        Assert.assertTrue(nodeEquals(result, addTwoNumbers(first, second)));

        // 输入：(9,8) + (1)
        // 输出：0,9
        first = new ListNode(9);
        first.next = new ListNode(8);
        second = new ListNode(1);
        result = new ListNode(0);
        result.next = new ListNode(9);
        Assert.assertTrue(nodeEquals(result, addTwoNumbers(first, second)));
    }
}
