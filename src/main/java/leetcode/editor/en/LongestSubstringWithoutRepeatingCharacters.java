package leetcode.editor.cn;

//Given a string s, find the length of the longest substring without repeating c
//haracters. 
//
// 
// Example 1: 
//
// 
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
// 
//
// Example 2: 
//
// 
//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
// 
//
// Example 3: 
//
// 
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a 
//substring.
// 
//
// Example 4: 
//
// 
//Input: s = ""
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 0 <= s.length <= 5 * 104 
// s consists of English letters, digits, symbols and spaces. 
// 
// Related Topics Hash Table Two Pointers String Sliding Window 
// 👍 11652 👎 634

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters{
	public static void main(String[] args) {
		Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
		System.out.println(solution.lengthOfLongestSubstring("dvdf"));
		
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> charSets = new HashSet<>();
		int length= 0;
		int j = 0;
        for (int i = 0; i < s.length() ; i++) {
			if(!charSets.contains(s.charAt(i))){
				charSets.add(s.charAt(i));
			}else {
				for (;j < s.length(); j++) {
					if(s.charAt(j) != s.charAt(i)){
						charSets.remove(s.charAt(j));
					}else {
						break;
					}
				}
				j++;
			}
			length = length>charSets.size()? length :charSets.size();
		}
        return length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}