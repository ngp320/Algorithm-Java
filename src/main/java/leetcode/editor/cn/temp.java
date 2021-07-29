package leetcode.editor.cn;

import leetcode.editor.cn.utils.ListNode;

import java.util.Arrays;

/**
 * @ClassName: temp
 * @Description: TODO
 * @Version: SVN版本号
 * @Author: 唐浩
 * @Date: 2021/7/19 11:31
 */
class Solution {
    private static void merge(Comparable[]arr,int l,int mid,int r){

        Comparable[]aux= Arrays.copyOfRange(arr,l,r+1);

        // 初始化，i指向左半部分的起始索引位置l；j指向右半部分起始索引位置mid+1
        int i=l,j=mid+1;
        for(int k=l;k<=r;k++){

            if(i>mid){  // 如果左半部分元素已经全部处理完毕
                arr[k]=aux[j-l];j++;
            }
            else if(j>r){   // 如果右半部分元素已经全部处理完毕
                arr[k]=aux[i-l];i++;
            }
            else if(aux[i-l].compareTo(aux[j-l])< 0){  // 左半部分所指元素 < 右半部分所指元素
                arr[k]=aux[i-l];i++;
            }
            else{  // 左半部分所指元素 >= 右半部分所指元素
                arr[k]=aux[j-l];j++;
            }
        }
    }

}

