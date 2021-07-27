
//Given the head of a singly linked list and two integers left and right where l
//eft <= right, reverse the nodes of the list from position left to position right
//, and return the reversed list.
//
//
// Example 1:
//
//
//Input: head = [1,2,3,4,5], left = 2, right = 4
//Output: [1,4,3,2,5]
//
//
// Example 2:
//
//
//Input: head = [5], left = 1, right = 1
//Output: [5]
//
//
//
// Constraints:
//
//
// The number of nodes in the list is n.
// 1 <= n <= 500
// -500 <= Node.val <= 500
// 1 <= left <= right <= n
//
//
//
//Follow up: Could you do it in one pass? Related Topics 链表
// 👍 943 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.utils.ListNode;
import leetcode.editor.cn.utils.Utils;

//Java：Reverse Linked List II
 class P92ReverseLinkedListIi{
    public static void main(String[] args) {
        Solution solution = new P92ReverseLinkedListIi().new Solution();
        // TO TEST
        ListNode list = Utils.createList("[1]");
        solution.reverseBetween(list, 1,1);
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
    // 解题思路: https://leetcode-cn.com/problems/reverse-linked-list-ii/solution/java-shuang-zhi-zhen-tou-cha-fa-by-mu-yi-cheng-zho/
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1, head);

        ListNode g = dummy;
        ListNode p = dummy.next;

        //g在prev, p在left位置
        for (int step = 0; step < left -1; step++) {
            g=g.next;
            p=p.next;
        }

        //头插法 图见上面链接
        for (int step = 0; step < right-left; step++) {
            //取
            ListNode removeNode = p.next;
            p.next = p.next.next;

            //插
            removeNode.next = g.next;
            g.next = removeNode;
        }

        return dummy.next;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
