package String;

import java.util.HashMap;
import java.util.Map;

class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println("Brute Force");
        System.out.println("lengthOfLongestSubstring abcabcbb is " + lengthOfLongestSubstringBrute("abcabcbb"));
        System.out.println("lengthOfLongestSubstring of bbbbb is " + lengthOfLongestSubstringBrute("bbbbb"));
        System.out.println("lengthOfLongestSubstring of pwwkew is " + lengthOfLongestSubstringBrute("pwwkew"));

        System.out.println("Sliding window");
        System.out.println("lengthOfLongestSubstring abcabcbb is " + lengthOfLongestSubstringSlidingWindow("abcabcbb"));
        System.out.println("lengthOfLongestSubstring of bbbbb is " + lengthOfLongestSubstringSlidingWindow("bbbbb"));
        System.out.println("lengthOfLongestSubstring of pwwkew is " + lengthOfLongestSubstringSlidingWindow("pwwkew"));

    }

    private static int lengthOfLongestSubstringBrute(String string) {

        if (string.length() < 2)
            return string.length();

        int longest = 0;
        for (int lp = 0; lp < string.length(); lp++) {
            Map<Character, Integer> seen = new HashMap<>();
            int lMax = 0;
            for (int rp = lp; rp < string.length(); rp++) {
                if (!seen.containsKey(string.charAt(rp))) {
                    seen.put(string.charAt(rp), rp);
                    lMax++;
                    longest = Math.max(lMax, longest);
                } else
                    break;
            }
        }
        return longest;
    }

    private static int lengthOfLongestSubstringSlidingWindow(String string) {

        if (string.length() < 2)
            return string.length();

        int longest = 0, lp = 0, rp = 0;
        Map<Character, Integer> seen = new HashMap<>();

        for(rp = 0; rp<string.length(); rp++){
            // check if repeated character is after lp
            char currentChar = string.charAt(rp);
            Integer duplicateInHash = seen.getOrDefault(currentChar, -1);
            if(lp <= duplicateInHash){
                lp = duplicateInHash + 1;
            }
            //add the current char to seen (if duplicate, update the index)
            seen.put(currentChar, rp);
            longest = Math.max(longest, (rp - lp) + 1);
        }
        return longest;
    }

}
