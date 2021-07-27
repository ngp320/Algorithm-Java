
//Given the head of a linked list, remove the nth node from the end of the list
//and return its head.
//
//
// Example 1:
//
//
//Input: head = [1,2,3,4,5], n = 2
//Output: [1,2,3,5]
//
//
// Example 2:
//
//
//Input: head = [1], n = 1
//Output: []
//
//
// Example 3:
//
//
//Input: head = [1,2], n = 1
//Output: [1]
//
//
//
// Constraints:
//
//
// The number of nodes in the list is sz.
// 1 <= sz <= 30
// 0 <= Node.val <= 100
// 1 <= n <= sz
//
//
//
// Follow up: Could you do this in one pass?
// Related Topics 链表 双指针
// 👍 1446 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.utils.ListNode;
import leetcode.editor.cn.utils.Utils;

//Java：Remove Nth Node From End of List
 class P19RemoveNthNodeFromEndOfList{
    public static void main(String[] args) {
        Solution solution = new P19RemoveNthNodeFromEndOfList().new Solution();
        // TO TEST
        ListNode l1 = Utils.createList("[1,2,3,4,5,6]");
        solution.removeNthFromEnd(l1, 2);
        System.out.println();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    // 栈
    /*public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode cur = dummy;
        Deque<ListNode> stack = new LinkedList<>();
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < n; i++) {
            stack.pop();
        }
        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        return dummy.next;
    }*/

    //双指针
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode fast = dummy;
        ListNode low = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        //因为要找出 倒数第n个的 前一个, 所以这里是next
        while (fast.next != null) {
            fast=fast.next;
            low = low.next;
        }
        low.next = low.next.next;
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
