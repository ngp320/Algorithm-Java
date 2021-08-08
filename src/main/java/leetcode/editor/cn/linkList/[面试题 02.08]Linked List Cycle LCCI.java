
//Given a circular linked list, implement an algorithm that returns the node at
//the beginning of the loop.
//
// Circular linked list: A (corrupt) linked list in which a node's next pointer
//points to an earlier node, so as to make a loop in the linked list.
//
// Example 1:
//
//
//Input: head = [3,2,0,-4], pos = 1
//Output: tail connects to node index 1
//
// Example 2:
//
//
//Input: head = [1,2], pos = 0
//Output: tail connects to node index 0
//
// Example 3:
//
//
//Input: head = [1], pos = -1
//Output: no cycle
//
// Follow Up:
//Can you solve it without using additional space?
// Related Topics 哈希表 链表 双指针
// 👍 78 👎 0

package leetcode.editor.cn.linkList;

import leetcode.editor.cn.ngp1848diy.utils.ListNode;

//Java：Linked List Cycle LCCI
 class  LinkedListCycle {
    public static void main(String[] args) {
        Solution solution = new  LinkedListCycle().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
