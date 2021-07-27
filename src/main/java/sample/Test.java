package sample;

public class Test {
    public static void main(String[] args) {


    }
    public class Solution {
        // �鲢����
        /**
         * ǰ��֪ʶ��:
         * 2.2.2.1 ��С��ģ������ʹ�ò�������  (�㷨4th)
         * �ò�ͬ�ķ�������С��ģ�����ܸĽ�������ݹ��㷨�����ܣ���Ϊ�ݹ��ʹС��ģ�����з����ĵ��ù���Ƶ�������ԸĽ������ǵĴ��������ܸĽ������㷨����������˵�������Ѿ�֪���������򣨻���ѡ�����򣩷ǳ��򵥣���˺ܿ�����С�����ϱȹ鲢������졣
         * ������������:   �����Ƚ������㷨�ĺ�ʱ����  https://www.pianshen.com/article/4186476018/
         * 2.2.2.2 ���������Ƿ��Ѿ�����
         * ���ǿ������һ���ж����������a[mid]С�ڵ���a[mid+1],���Ǿ���Ϊ�����Ѿ�������Ĳ�����merge() ����������Ķ���Ӱ������ĵݹ���ã���������������������㷨������ʱ�� �ͱ�Ϊ���Ե���
         * 2.2.2.3 ����Ԫ�ظ��Ƶ��������� ���ǿ��Խ�ʡ������Ԫ�ظ��Ƶ����ڹ鲢�ĸ����������õ�ʱ�䣨���ռ䲻�У���Ҫ������һ������Ҫ�����������򷽷���һ�ֽ����ݴ������������򵽸������飬һ�ֽ����ݴӸ������������������顣���ַ�����ҪһЩ���ɣ�����Ҫ�ڵݹ���õ�ÿ����ν�����������͸�������Ľ�ɫ
         *
         * /

        /**
         * �б��С  С�ڵ���7ʱ���������� mergeSort ʹ�ò�������
         * std::stable_sortҪ�ȵݹ�ʵ�ֵĹ鲢����Ч�ʸ�50%���ң�����Ҫ�����ڣ�
         * 1.stable_sort���Ƚ�����������7��Ԫ��Ϊ��λ�ֳ�����С�飬ÿС���ڽ��в�������
         * 2.�ϲ��������򹹳ɵ���������ʱ��ͨ��mergeto(A,B��step) && mergeto(B,A,step*2)�ķ�ʽ������һ�������ݿ���
         * ��Դ: https://www.pianshen.com/article/4186476018/
         *
         */
        private static final int INSERTION_SORT_THRESHOLD = 7;


        public int[] sortArray(int[] nums) {
            int len = nums.length;
            //temp  ���ںϲ�������������ĸ������飬ȫ��ʹ��һ�ݣ������δ���������
            int[] temp = new int[len];
            mergeSort(nums, 0, len - 1, temp);
            return nums;
        }

        /**
         * ������ nums �������� [left, right] ���й鲢����
         */
        private void mergeSort(int[] nums, int left, int right, int[] temp) {
            // С����ʹ�ò�������
            if (right - left <= INSERTION_SORT_THRESHOLD) {
                insertionSort_timeGeekBang(nums, left, right);
                return;
            }

            // Java ����ŵ�д������ left �� right ���ӽ�int�������� ֵ��Χ�� ����ʱ����ӻ����, �������������������, ������Ȼ��ȷ
            // λ���� ���ü�����бȳ���������ٶ�.
            int mid = left + ((right - left) >>1);
            mergeSort(nums, left, mid, temp);
            mergeSort(nums, mid + 1, right, temp);
            // �����������䱾������, ����ϲ�.
            // ��Ϊ���������䱾������(��Ϊ�ǲ�, ��ѭ��, ����ϲ�)��������һ�����������һ��Ԫ��, С�ڵڶ����������һ��Ԫ��, ���Ѿ��Ǻϲ����˳��
            if (nums[mid] <= nums[mid + 1]) {
                return;
            }
            mergeOfTwoSortedArray(nums, left, mid, right, temp);
        }


        /**
         * ������ arr �������� [left, right] ʹ�ò�������
         *
         * @param arr   ��������
         * @param left  ��߽磬��ȡ��
         * @param right �ұ߽磬��ȡ��
         */
        public void insertionSort_timeGeekBang(int[] arr, int left, int right) {
            for (int i = left+1; i <= right ; ++i) {
                int value = arr[i];
                int j = i - 1;
                // ���Ҳ����λ��
                for (; j >= left; --j) {
                    if (arr[j] > value) {
                        arr[j+1] = arr[j];  // �����ƶ�
                    } else {
                        break;
                    }
                }
                arr[j+1] = value; // ��������
            }
        }

        /**
         * �ϲ������������飺�Ȱ�ֵ���Ƶ���ʱ���飬�ٺϲ���ȥ
         *
         * @param nums
         * @param left
         * @param mid   [left, mid] ����[mid + 1, right] ����
         * @param right
         * @param temp  ȫ��ʹ�õ���ʱ����
         */
        private void mergeOfTwoSortedArray(int[] nums, int left, int mid, int right, int[] temp) {
            System.arraycopy(nums, left, temp, left, right + 1 - left);

            int i = left;
            int j = mid + 1;

            for (int k = left; k <= right; k++) {
                if (i == mid + 1) {
                    nums[k] = temp[j];
                    j++;
                } else if (j == right + 1) {
                    nums[k] = temp[i];
                    i++;
                } else if (temp[i] <= temp[j]) {
                    // ע��д�� < �Ͷ�ʧ���ȶ��ԣ���ͬԪ��ԭ����ǰ�������Ժ���Ȼ��ǰ��
                    nums[k] = temp[i];
                    i++;
                } else {
                    // temp[i] > temp[j]
                    nums[k] = temp[j];
                    j++;
                }
            }
        }

        private void mergeOfTwoSortedArray_timeGeekBang(int[] nums, int left, int mid, int right, int[] temp) {
            //merge(A[p...r],A[p...q],A[q + 1...r]){
            //    var i :=p��j:=q + 1��k:=0
            //    // ��ʼ������
            //    i, j, k var tmp :=new array[0...r - p]
            //    // ����һ����С��A[p...r]һ������ʱ����
            //    while i <= q AND j<=r do {
            //        if A[i] <= A[j] {
            //            tmp[k++] = A[i++]
            //            i++ ����i:=i + 1
            //        } else{
            //            tmp[k++] = A[j++]
            //        }
            //    }
            //    // �ж��ĸ�����������ʣ�������
            //    var start :=i��end:=q if j <= r then start :=j, end:=r
            //    //��ʣ������ݿ�������ʱ����
            //    tmp while start <= end do {
            //        tmp[k++] = A[start++]
            //    }
            //    //��tmp�е����鿽����A
            //[p...r]for i:=0 to r -p do {
            //        A[p + i] = tmp[i]
            //    }
            //}
        }
    }


}

