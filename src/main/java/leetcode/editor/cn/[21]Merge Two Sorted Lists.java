
//Merge two sorted linked lists and return it as a sorted list. The list should
//be made by splicing together the nodes of the first two lists.
//
//
// Example 1:
//
//
//Input: l1 = [1,2,4], l2 = [1,3,4]
//Output: [1,1,2,3,4,4]
//
//
// Example 2:
//
//
//Input: l1 = [], l2 = []
//Output: []
//
//
// Example 3:
//
//
//Input: l1 = [], l2 = [0]
//Output: [0]
//
//
//
// Constraints:
//
//
// The number of nodes in both lists is in the range [0, 50].
// -100 <= Node.val <= 100
// Both l1 and l2 are sorted in non-decreasing order.
//
// Related Topics 递归 链表
// 👍 1788 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.utils.ListNode;
import leetcode.editor.cn.utils.Utils;

//Java：Merge Two Sorted Lists
class P21MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new P21MergeTwoSortedLists().new Solution();
        // TO TEST
        ListNode l1 = Utils.createList("[1,2,4]");
        ListNode l2 = Utils.createList("[1,3,4]");
        solution.mergeTwoLists(l1, l2);
        System.out.println();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        //递归 写法
        /*public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            //head 和 head.next 要分清楚, 边界条件
            if (l1 == null) {
                return l2;
            } else if (l2 == null) {
                return l1;
            } else if (l1.val < l2.val) {
                l1.next = mergeTwoLists(l1.next, l2);
                return l1;
            } else {
                // 算法每一句顺序都很重要, 而且前后联系
                // 因为此处, 相等时 l2先next导致下次递归为空, 如果此处l2.val=l1.val, 则上文 li.next == null 条件判断 应该放到第一句
                l2.next = mergeTwoLists(l1, l2.next);
                return l2;
            }
        }*/

        //迭代 写法
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode preHead = new ListNode(-1);
            ListNode pre = preHead;
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    pre.next = l1;
                    l1 = l1.next;
                } else {
                    pre.next = l2;
                    l2 = l2.next;
                }
                pre = pre.next;
            }
            // l1,l2 最少有1个为空, 则拼接另一个到 pre.next
            pre.next = l1 == null ? l2 : l1;
            return preHead.next;

        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
