package leetcode.editor.cn;

//Given a signed 32-bit integer x, return x with its digits reversed. If reversi
//ng x causes the value to go outside the signed 32-bit integer range [-231, 231 -
// 1], then return 0. 
//
// Assume the environment does not allow you to store 64-bit integers (signed or
// unsigned). 
//
// 
// Example 1: 
// Input: x = 123
//Output: 321
// Example 2: 
// Input: x = -123
//Output: -321
// Example 3: 
// Input: x = 120
//Output: 21
// Example 4: 
// Input: x = 0
//Output: 0
// 
// 
// Constraints: 
//
// 
// -231 <= x <= 231 - 1 
// 
// Related Topics Math 
// 👍 4598 👎 7045

public class ReverseInteger{
	public static void main(String[] args) {
		Solution solution = new ReverseInteger().new Solution();
		System.out.println(solution.reverse(1534231569));
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public int reverse(int x) {
		int sum = 0;
		boolean sig = x > 0;
		int y = x > 0 ? x : -x;
		while (y > 0) {
			int n = y % 10;
			y = y / 10;
			if((Integer.MAX_VALUE-n)/10 < sum){
				return 0;
			}
			sum = sum * 10 + n;
		}
		return sig ? sum : -sum;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}