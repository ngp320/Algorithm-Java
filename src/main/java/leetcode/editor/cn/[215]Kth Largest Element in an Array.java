
//Given an integer array nums and an integer k, return the kth largest element i
//n the array.
//
// Note that it is the kth largest element in the sorted order, not the kth dist
//inct element.
//
//
// Example 1:
// Input: nums = [3,2,1,5,6,4], k = 2
//Output: 5
// Example 2:
// Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
//Output: 4
//
//
// Constraints:
//
//
// 1 <= k <= nums.length <= 104
// -104 <= nums[i] <= 104
//
// Related Topics 数组 分治 快速选择 排序 堆（优先队列）
// 👍 1206 👎 0

package leetcode.editor.cn;

//Java：Kth Largest Element in an Array
class P215KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new P215KthLargestElementInAnArray().new Solution();
        int[] nums = {3, 2, 1, 5, 6, 4};
        int res = solution.findKthLargest(nums, 2);
        System.out.println();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            return quickSort(nums, 0, nums.length - 1, nums.length - k);
        }

        public int quickSort(int[] nums, int l, int r, int index) {
            int p = partition(nums, l, r);
            if (p == index) {
                return nums[p];
            } else if (p > index) {
                // 若p>index, 则表明 index 在 标定值p 分出来的两个数组的 左边的数组里
                return quickSort(nums, l, p - 1, index);
            } else {
                return quickSort(nums, p + 1, r, index);
            }

        }

        public int partition(int[] nums, int l, int r) {
            int p = (int) (l + (r - l) * Math.random());
            int val = nums[p];
            swap(nums, p, l);
            int j = l;
            for (int i = l + 1; i <= r; i++) {
                if (nums[i] < val) {
                    swap(nums, i, j + 1);
                    j++;
                }
            }
            swap(nums, l, j);
            return j;
        }

        public void swap(int[] nums, int x, int y) {
            int temp = nums[x];
            nums[x] = nums[y];
            nums[y] = temp;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}
