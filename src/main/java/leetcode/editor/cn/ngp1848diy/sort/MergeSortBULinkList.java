package leetcode.editor.cn.ngp1848diy.sort;

import leetcode.editor.cn.ngp1848diy.utils.ListNode;

/**
 * @ClassName: mergeSortBULinkList
 * @Description:
 * @Version:
 * @Author: 唐浩
 * @Date: 2021/7/30 14:12
 */
public class MergeSortBULinkList {
    // 特点: 自底向上, 适合链表.

    public static ListNode mergeSortBULinkList(ListNode head) {
        // 保存head, 因为下面遍历长度会移动head
        //哨兵节点, 省去头结点特殊判断等操作
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        //计算链表长度
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }




        //sz size
        //sz <<=1 , 位操作 (*2)
        for (int sz = 1; sz < length; sz <<= 1) {
            ListNode prev = dummy;
            ListNode cur = dummy.next;


            //(最后切分完) or (sz>剩余个数) 时, cur = null
            while (cur != null) {
                // left 获取sz个节点 (先把整个linklist, 贴上)
                ListNode left = cur;
                // right 获取sz个节点 (cut sz个节点, 使left为sz个节点)
                // splitLinkList 可以理解为 拆分链表
                ListNode right = cutLinkList(left, sz);
                // cur 准备下一轮循环 (cut sz个节点, 使right为sz个节点)
                cur = cutLinkList(right, sz);

                prev = mergeLinkList(left, right, prev);
            }
        }

        return dummy.next;
    }

    private static ListNode cutLinkList(ListNode head, int sz) {
        if (head == null) {
            return null;
        }

        //head算是第一个
        for (int i = 1;  i < sz; i++) {
            if (head.next != null){
                head = head.next;
            }
        }

        //截断linkList
        ListNode afterCutLinkList = head.next;
        head.next = null;
        return afterCutLinkList;
    }

    private static ListNode mergeLinkList(ListNode left, ListNode right, ListNode prev) {
        //保存 相对于 left的 dummy哨兵节点
        ListNode cur = prev;
        //merge
        while (left != null && right != null) {
            if (left.val < right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }

        //若一个为null, 另一个还有元素, 接上剩余元素
        if (left != null) {
            cur.next = left;
        } else if (right != null) {
            cur.next = right;
        }
        // 所以遍历到最后即为, cur指向right最后一个节点.
        // 以便 下一轮循环
        while (cur.next != null) {
            cur = cur.next;
        }
        return cur;
    }
}
