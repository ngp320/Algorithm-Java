package leetcode.editor.cn.ngp1848diy.utils;

import java.util.Arrays;

/**
 * @ClassName: asfdasd123
 * @Description:
 * @Version:
 * @Author: 唐浩
 * @Date: 2021/7/28 16:11
 */
public class SortTestHelper {

    // SortTestHelper不允许产生任何实例
    private SortTestHelper(){}

    public static  ListNode copyArrays2LinkList(int[] arrOrigin) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        for (int num : arrOrigin) {
            ListNode next = new ListNode(num);
            cur.next = next;
            cur = cur.next ;
        }
        return dummy.next;
    }


    // 生成有n个元素的随机数组,每个元素的随机范围为[rangeL, rangeR]
    public static int[] generateRandomArray(int n, int rangeL, int rangeR) {

        assert rangeL <= rangeR;

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] =  (int)(Math.random() * (rangeR - rangeL + 1) + rangeL);
        }
        assert !isArraySorted(arr);
        return arr;
    }

    // 生成一个近乎有序的数组
    // 首先生成一个含有[0...n-1]的完全有序数组, 之后随机交换swapTimes对数据
    // swapTimes定义了数组的无序程度:
    // swapTimes == 0 时, 数组完全有序
    // swapTimes 越大, 数组越趋向于无序
    public static int[] generateNearlyOrderedArray(int n, int swapTimes){

        int[] arr = new int[n];
        for( int i = 0 ; i < n ; i ++ ) {
            arr[i] = i;
        }

        for( int i = 0 ; i < swapTimes ; i ++ ){
            int a = (int)(Math.random() * n);
            int b = (int)(Math.random() * n);
            int t = arr[a];
            arr[a] = arr[b];
            arr[b] = t;
        }

        return arr;
    }

    // 打印arr数组的所有内容
    public static void printArray(int[] arr) {
        Arrays.stream(arr).forEach(x-> System.out.print(x+" "));
        System.out.println();
        //for (int i = 0; i < arr.length; i++){
        //    System.out.print( arr[i] );
        //    System.out.print( ' ' );
        //}
        //System.out.println();
        //return;
    }



    // 打印arr数组的所有内容
    public static void printLinkList(ListNode head, String...messages) {
        int count =0;
        while (head != null){
            System.out.print(head.val+" ");
            head = head.next;
            count++;
        }
        System.out.println();
        for (String msg : messages) {
            System.out.print(msg+" ");
        }
        System.out.println(String.format("总计 %s 个节点",count));
    }

    // 判断 arr 数组 是否有序
    public static boolean isArraySorted(int[] arr){
        for( int i = 0 ; i < arr.length - 1 ; i ++ ) {
            if( arr[i] > arr[i+1] ) {
                return false;
            }
        }
        return true;
    }
    // 判断 head 链表 是否有序
    public static boolean isLinkListSorted(ListNode head){
        while (head.next != null) {
            if (head.val > head.next.val) {
                System.out.println(head.next.val);
                return false;
            }
            head = head.next;
        }
        return true;
    }

}
