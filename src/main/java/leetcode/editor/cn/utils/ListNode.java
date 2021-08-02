package leetcode.editor.cn.utils;

/**
 * @ClassName: ListNode
 * @Description:
 * @Version:
 * @Author: 唐浩
 * @Date: 2021/7/8 13:43
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
