package leetcode.editor.cn;

//Given a string s, return the longest palindromic substring in s. 
//
// 
// Example 1: 
//
// 
//Input: s = "babad"
//Output: "bab"
//Note: "aba" is also a valid answer.
// 
//
// Example 2: 
//
// 
//Input: s = "cbbd"
//Output: "bb"
// 
//
// Example 3: 
//
// 
//Input: s = "a"
//Output: "a"
// 
//
// Example 4: 
//
// 
//Input: s = "ac"
//Output: "a"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consist of only digits and English letters (lower-case and/or upper-case), 
//
// 
// Related Topics String Dynamic Programming 
// 👍 8690 👎 602

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        String v1 = "aacabdkacaa";
        System.out.println(solution.longestPalindrome(v1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            return onceRun(s);
        }

		private String onceRun(String s) {
			int m = 0, n = 0, max = 0;
			for (int i = 0; i < s.length(); i++) {
				boolean odd = true;
				boolean even = true;
				for (int j = 0; j <= i; j++) {
					if (i - j < 0) {
						continue;
					}
					odd = odd && i + j < s.length()
							&& s.charAt(i - j) == s.charAt(i + j);

					even = even && i + j + 1 < s.length()
							&& s.charAt(i - j) == s.charAt(i + j + 1);

					if (odd && 2 * j + 1 > max) {
						m = i - j;
						n = i + j;
						max = n - m + 1;
					}
					if (even && 2 * j + 2 > max) {
						m = i - j;
						n = i + j + 1;
						max = n - m + 1;
					}

					if (!odd && !even) {
						break;
					}
				}
			}
			return s.substring(m, n + 1);
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}