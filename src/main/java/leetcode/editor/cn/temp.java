package leetcode.editor.cn;

import leetcode.editor.cn.utils.ListNode;

import java.util.Arrays;

/**
 * @ClassName: temp
 * @Description: TODO
 * @Version: SVN�汾��
 * @Author: �ƺ�
 * @Date: 2021/7/19 11:31
 */
class Solution {
    private static void merge(Comparable[]arr,int l,int mid,int r){

        Comparable[]aux= Arrays.copyOfRange(arr,l,r+1);

        // ��ʼ����iָ����벿�ֵ���ʼ����λ��l��jָ���Ұ벿����ʼ����λ��mid+1
        int i=l,j=mid+1;
        for(int k=l;k<=r;k++){

            if(i>mid){  // �����벿��Ԫ���Ѿ�ȫ���������
                arr[k]=aux[j-l];j++;
            }
            else if(j>r){   // ����Ұ벿��Ԫ���Ѿ�ȫ���������
                arr[k]=aux[i-l];i++;
            }
            else if(aux[i-l].compareTo(aux[j-l])< 0){  // ��벿����ָԪ�� < �Ұ벿����ָԪ��
                arr[k]=aux[i-l];i++;
            }
            else{  // ��벿����ָԪ�� >= �Ұ벿����ָԪ��
                arr[k]=aux[j-l];j++;
            }
        }
    }

}

