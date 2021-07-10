package leetcode.editor.cn;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class Utils {
    //�ַ�����������
    public static ListNode createList(String str){
        if (str==null) {
            return null;
        }
        String substring = str.substring(1, str.length() - 1);
        if (substring.length()==0)return null;
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
    //�ַ������ɶ�����
    public static TreeNode createTree(String str){
        if (str==null) {
            return null;
        }
        String substring = str.substring(1, str.length() - 1);//��ͷȥβ
        if (substring.length()==0) {
            return null;
        }
        String[] split = substring.split(",");//���ն��ŷָ�
        TreeNode root = split[0].equals("null")?null:new TreeNode(Integer.parseInt(split[0]));//����root�ڵ�
        Queue<TreeNode> queue = new LinkedBlockingQueue<>(); //������ȵĸ�������
        queue.add(root);
        int index = 1;//����������±�
        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if (index<split.length){//����±�Խ�������whileѭ��
                cur.left = split[index].equals("null")?null:new TreeNode(Integer.parseInt(split[index]));
                index++;
                if (cur.left!=null){//����ڵ���null �Ͳ����˶���
                    queue.add(cur.left);
                }
            }else {break;}
            if (index<split.length){//����±�Խ�������whileѭ��
                cur.right= split[index].equals("null")?null:new TreeNode(Integer.parseInt(split[index]));
                index++;
                if (cur.right!=null){//����ڵ���null �Ͳ����˶���
                    queue.add(cur.right);
                }
            }else {break;}
        }
        return root;
    }

}
