package leetcode.editor.cn.ngp1848diy.utils;

public class createList {
    //字符串生成链表
    public static ListNode createRandomNumberLinkList(int N, int rangeL, int rangeR) {
        assert rangeL <= rangeR;
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        for (int i = 0; i < N; i++) {
            int randomNum = (int)(Math.random() * (rangeR - rangeL + 1) + rangeL);
            ListNode next = new ListNode(randomNum);
            cur.next = next;
            cur = next;
        }
        return dummy.next;
    }

    //字符串生成链表
    public static ListNode createList(String str) {
        if (str == null) {
            return null;
        }
        String substring = str.substring(1, str.length() - 1);
        if (substring.length() == 0) {
            return null;
        }
        String[] split = substring.split(",");
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        for (String s : split) {
            ListNode next = new ListNode(Integer.parseInt(s));
            cur.next = next;
            cur = next;
        }
        return dummy.next;
    }


}
