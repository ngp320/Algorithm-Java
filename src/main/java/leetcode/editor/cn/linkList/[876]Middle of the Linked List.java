
//Given a non-empty, singly linked list with head node head, return a middle nod
//e of linked list.
//
// If there are two middle nodes, return the second middle node.
//
//
//
//
// Example 1:
//
//
//Input: [1,2,3,4,5]
//Output: Node 3 from this list (Serialization: [3,4,5])
//The returned node has value 3.  (The judge's serialization of this node is [3,
//4,5]).
//Note that we returned a ListNode object ans, such that:
//ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next =
// NULL.
//
//
//
// Example 2:
//
//
//Input: [1,2,3,4,5,6]
//Output: Node 4 from this list (Serialization: [4,5,6])
//Since the list has two middle nodes with values 3 and 4, we return the second
//one.
//
//
//
//
// Note:
//
//
// The number of nodes in the given list will be between 1 and 100.
//
//
//
// Related Topics 链表 双指针
// 👍 360 👎 0

package leetcode.editor.cn.linkList;

import leetcode.editor.cn.utils.ListNode;

//Java：Middle of the Linked List
class P876MiddleOfTheLinkedList {
    public static void main(String[] args) {
        Solution solution = new P876MiddleOfTheLinkedList().new Solution();
        // TO TEST
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

        // 数组法
        /*
        public ListNode middleNode(ListNode head) {
            ListNode[] Array = new  ListNode[100];
            int index = 0;
            while (head != null) {
                // 此处index会多加1次, 所以 index / 2 即可
                Array[index++] = head;
                head = head.next;
            }
            return Array[index / 2];
        }
        */

        //双指针法
        public ListNode middleNode(ListNode head) {
            ListNode fast = head;
            ListNode low = head;
            //情况1: 当 fast到最后一个节点停止, 那(奇数个节点)/2 一定是中间节点
            //情况2: 当 fast到倒数第二个节点不停止, 超过去一个, 那(偶数个节点+1)/2, 也是两个中心节点的后一个.
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                low = low.next;
            }
            return low;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
