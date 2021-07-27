package leetcode.editor.cn.utils;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class Utils {
    //字符串生成链表
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
    //字符串生成二叉树
    public static TreeNode createTree(String str){
        if (str==null) {
            return null;
        }
        String substring = str.substring(1, str.length() - 1);//掐头去尾
        if (substring.length()==0) {
            return null;
        }
        String[] split = substring.split(",");//按照逗号分割
        TreeNode root = split[0].equals("null")?null:new TreeNode(Integer.parseInt(split[0]));//树的root节点
        Queue<TreeNode> queue = new LinkedBlockingQueue<>(); //广度优先的辅助队列
        queue.add(root);
        int index = 1;//数组的索引下标
        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if (index<split.length){//如果下标越界就跳出while循环
                cur.left = split[index].equals("null")?null:new TreeNode(Integer.parseInt(split[index]));
                index++;
                if (cur.left!=null){//如果节点是null 就不放人队列
                    queue.add(cur.left);
                }
            }else {break;}
            if (index<split.length){//如果下标越界就跳出while循环
                cur.right= split[index].equals("null")?null:new TreeNode(Integer.parseInt(split[index]));
                index++;
                if (cur.right!=null){//如果节点是null 就不放人队列
                    queue.add(cur.right);
                }
            }else {break;}
        }
        return root;
    }
    //生成一个随机数组
    public static int[] generateRandomArray(int arrLength) {
        int[] arr = new int[arrLength];
        int randomNumber = (int) (Math.random() * 1000 + 1);//随机1-1000的整数
        for (int i = 0; i < arrLength; i++) {
            arr[i] = randomNumber;
            randomNumber = (int) (Math.random() * 1000 + 1);
        }
        //printArr(arr);
        return arr;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.println(arr[i]);
            } else {
                System.out.print(arr[i] + ",");
            }
        }
    }
}
