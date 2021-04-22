package leetcode.editor.en;

//Given an integer x, return true if x is palindrome integer. 
//
// An integer is a palindrome when it reads the same backward as forward. For ex
//ample, 121 is palindrome while 123 is not. 
//
// 
// Example 1: 
//
// 
//Input: x = 121
//Output: true
// 
//
// Example 2: 
//
// 
//Input: x = -121
//Output: false
//Explanation: From left to right, it reads -121. From right to left, it becomes
// 121-. Therefore it is not a palindrome.
// 
//
// Example 3: 
//
// 
//Input: x = 10
//Output: false
//Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
// 
//
// Example 4: 
//
// 
//Input: x = -101
//Output: false
// 
//
// 
// Constraints: 
//
// 
// -231 <= x <= 231 - 1 
// 
//
// 
//Follow up: Could you solve it without converting the integer to a string? Rela
//ted Topics Math 
// 👍 3231 👎 1728

public class PalindromeNumber{
	public static void main(String[] args) {
		Solution solution = new PalindromeNumber().new Solution();
        System.out.println(solution.isPalindrome(121));
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0 ){
            return false;
        } else if(x ==0){
            return true;
        }
        int sum = 0;
        while (true){
            int last = x % 10;
            if(sum ==0 && last ==0){
                return false;
            }
            x = x / 10;
            if(x == sum || x == (sum = sum * 10 + last) ){
                return true;
            }
            if(sum > x){
                break;
            }

        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}