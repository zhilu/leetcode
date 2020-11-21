package leetcode.editor.cn;

//Given two sorted arrays nums1 and nums2 of size m and n respectively, return t
//he median of the two sorted arrays. 
//
// Follow up: The overall run time complexity should be O(log (m+n)). 
//
// 
// Example 1: 
//
// 
//Input: nums1 = [1,3], nums2 = [2]
//Output: 2.00000
//Explanation: merged array = [1,2,3] and median is 2.
// 
//
// Example 2: 
//
// 
//Input: nums1 = [1,2], nums2 = [3,4]
//Output: 2.50000
//Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
// 
//
// Example 3: 
//
// 
//Input: nums1 = [0,0], nums2 = [0,0]
//Output: 0.00000
// 
//
// Example 4: 
//
// 
//Input: nums1 = [], nums2 = [1]
//Output: 1.00000
// 
//
// Example 5: 
//
// 
//Input: nums1 = [2], nums2 = []
//Output: 2.00000
// 
//
// 
// Constraints: 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -106 <= nums1[i], nums2[i] <= 106 
// 
// Related Topics Array Binary Search Divide and Conquer 
// 👍 8431 👎 1301

public class MedianOfTwoSortedArrays{
	public static void main(String[] args) {
		Solution solution = new MedianOfTwoSortedArrays().new Solution();
		int a [] ={1,2};
		int b [] ={3,4};
        System.out.println(solution.findMedianSortedArrays(a,b));

	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return userNewArray(nums1,nums2);

    }

    /**
     * 空间换时间
     */
    private double userNewArray(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int[] arr = null;
        if (len == nums1.length) {
            arr = nums1;
        } else if (len == nums2.length) {
            arr = nums2;
        } else {
            arr = new int[len];
            for (int i = 0, j = 0, k = 0; i < nums1.length || j < nums2.length; ) {
                if (i == nums1.length) {
                    arr[k++] = nums2[j++];
                } else if (j == nums2.length) {
                    arr[k++] = nums1[i++];
                } else {
                    if (nums1[i] > nums2[j]) {
                        arr[k++] = nums2[j++];
                    } else {
                        arr[k++] = nums1[i++];
                    }
                }

                if (k > len / 2) {
                    break;
                }
            }
        }
        if (len % 2 == 0) {
            return (double) (arr[len / 2 - 1] + arr[len / 2]) / 2;
        } else {
            return arr[len / 2];
        }
    }

    private double standard(int[] A, int[] B){
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j-1] > A[i]){
                iMin = i + 1; // i is too small
            }
            else if (i > iMin && A[i-1] > B[j]) {
                iMax = i - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}