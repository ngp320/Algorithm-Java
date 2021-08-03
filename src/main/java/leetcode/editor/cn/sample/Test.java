package leetcode.editor.cn.sample;

public class Test {
    public static void main(String[] args) {


    }
    public class Solution {
        // 归并排序
        /**
         * 前置知识点:
         * 2.2.2.1 对小规模子数组使用插入排序  (算法4th)
         * 用不同的方法处理小规模问题能改进大多数递归算法的性能，因为递归会使小规模问题中方法的调用过于频繁，所以改进对它们的处理方法就能改进整个算法。对排序来说，我们已经知道插入排序（或者选择排序）非常简单，因此很可能在小数组上比归并排序更快。
         * 更多理论依据:   常见比较排序算法的耗时测试  https://www.pianshen.com/article/4186476018/
         * 2.2.2.2 测试数组是否已经有序
         * 我们可以添加一个判断条件，如果a[mid]小于等于a[mid+1],我们就认为数组已经是有序的并跳过merge() 方法。这个改动不影响排序的递归调用，但是任意有序的子数组算法的运行时间 就变为线性的了
         * 2.2.2.3 不将元素复制到辅助数组 我们可以节省将数组元素复制到用于归并的辅助数组所用的时间（但空间不行）。要做到这一点我们要调用两种排序方法，一种将数据从输入数组排序到辅助数组，一种将数据从辅助数组排序到输入数组。这种方法需要一些技巧，我们要在递归调用的每个层次交换输入数组和辅助数组的角色
         *
         * /

        /**
         * 列表大小  小于等于7时，将优先于 mergeSort 使用插入排序
         * std::stable_sort要比递归实现的归并排序效率高50%左右，这主要是由于：
         * 1.stable_sort首先将输入序列以7个元素为单位分成若干小组，每小组内进行插入排序
         * 2.合并插入排序构成的有序序列时，通过mergeto(A,B，step) && mergeto(B,A,step*2)的方式减少了一定的数据拷贝
         * 来源: https://www.pianshen.com/article/4186476018/
         *
         */
        private static final int INSERTION_SORT_THRESHOLD = 7;


        public int[] sortArray(int[] nums) {
            int len = nums.length;
            //temp  用于合并两个有序数组的辅助数组，全局使用一份，避免多次创建和销毁
            int[] temp = new int[len];
            mergeSort(nums, 0, len - 1, temp);
            return nums;
        }

        /**
         * 对数组 nums 的子区间 [left, right] 进行归并排序
         */
        private void mergeSort(int[] nums, int left, int right, int[] temp) {
            // 小区间使用插入排序
            if (right - left <= INSERTION_SORT_THRESHOLD) {
                insertionSort_timeGeekBang(nums, left, right);
                return;
            }

            // Java 里更优的写法，在 left 和 right 都接近int数据类型 值范围的 上限时，相加会溢出, 相减不会溢出，此种情况, 结论依然正确
            // 位操作 能让计算机有比除法更快的速度.
            int mid = left + ((right - left) >>1);
            mergeSort(nums, left, mid, temp);
            mergeSort(nums, mid + 1, right, temp);
            // 若两个子区间本身有序, 无需合并.
            // 因为两个子区间本身有序(因为是拆到, 再循环, 排序合并)，则若第一个子区间最后一个元素, 小于第二个子区间第一个元素, 则已经是合并后的顺序
            if (nums[mid] <= nums[mid + 1]) {
                return;
            }
            mergeOfTwoSortedArray(nums, left, mid, right, temp);
        }


        /**
         * 对数组 arr 的子区间 [left, right] 使用插入排序
         *
         * @param arr   给定数组
         * @param left  左边界，能取到
         * @param right 右边界，能取到
         */
        public void insertionSort_timeGeekBang(int[] arr, int left, int right) {
            for (int i = left+1; i <= right ; ++i) {
                int value = arr[i];
                int j = i - 1;
                // 查找插入的位置
                for (; j >= left; --j) {
                    if (arr[j] > value) {
                        arr[j+1] = arr[j];  // 数据移动
                    } else {
                        break;
                    }
                }
                arr[j+1] = value; // 插入数据
            }
        }

        /**
         * 合并两个有序数组：先把值复制到临时数组，再合并回去
         *
         * @param nums
         * @param left
         * @param mid   [left, mid] 有序，[mid + 1, right] 有序
         * @param right
         * @param temp  全局使用的临时数组
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
                    // 注意写成 < 就丢失了稳定性（相同元素原来靠前的排序以后依然靠前）
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
            //    var i :=p，j:=q + 1，k:=0
            //    // 初始化变量
            //    i, j, k var tmp :=new array[0...r - p]
            //    // 申请一个大小跟A[p...r]一样的临时数组
            //    while i <= q AND j<=r do {
            //        if A[i] <= A[j] {
            //            tmp[k++] = A[i++]
            //            i++ 等于i:=i + 1
            //        } else{
            //            tmp[k++] = A[j++]
            //        }
            //    }
            //    // 判断哪个子数组中有剩余的数据
            //    var start :=i，end:=q if j <= r then start :=j, end:=r
            //    //将剩余的数据拷贝到临时数组
            //    tmp while start <= end do {
            //        tmp[k++] = A[start++]
            //    }
            //    //将tmp中的数组拷贝回A
            //[p...r]for i:=0 to r -p do {
            //        A[p + i] = tmp[i]
            //    }
            //}
        }
    }


}

