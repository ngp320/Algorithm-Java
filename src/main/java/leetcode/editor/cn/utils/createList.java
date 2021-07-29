package leetcode.editor.cn.utils;

public class createList {
    //×Ö·û´®Éú³ÉÁ´±í
    public static ListNode createList(String str) {
        if (str == null) {
            return null;
        }
        String substring = str.substring(1, str.length() - 1);
        if (substring.length() == 0) {
            return null;
        }
        String[] split = substring.split(",");
        ListNode root = new ListNode(-1);
        ListNode temp = root;
        for (String s : split) {
            ListNode next = new ListNode(Integer.parseInt(s));
            temp.next = next;
            temp = next;
        }
        return root.next;
    }


}
