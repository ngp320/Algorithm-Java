package leetcode.editor.cn.utils;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @ClassName: afasdf
 * @Description: TODO
 * @Version:
 * @Author: �ƺ�
 * @Date: 2021/7/28 16:36
 */
public class createTree {
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
