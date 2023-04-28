package String;

public class AlmostPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal : panama";//true
        String s1 = "A man, a plan, z a canal : panama";//true
        String s2 = "a";//false
        String s3 = "aabcdd";//true
        String s4 = "race a car";//true
        String s5 = "";//true
        String s6 = "ab";//true

        System.out.println(s + " is almost palindrome? " + isAlmostPalindrome(processString(s)));
        System.out.println(s1 + " is almost palindrome? " + isAlmostPalindrome(processString(s1)));
        System.out.println(s2 + " is almost palindrome? " + isAlmostPalindrome(processString(s2)));
        System.out.println(s3 + " is almost palindrome? " + isAlmostPalindrome(processString(s3)));
        System.out.println(s4 + " is almost palindrome? " + isAlmostPalindrome(processString(s4)));
        System.out.println(s5 + " is almost palindrome? " + isAlmostPalindrome(processString(s5)));
        System.out.println(s6 + " is almost palindrome? " + isAlmostPalindrome(processString(s6)));

    }


    private static boolean isAlmostPalindrome(String s) {
        if (s.length() < 2)
            return true;

        char[] ch = s.toCharArray();
        int lp = 0, rp = ch.length - 1;

        while (lp <= rp) {
            if (ch[lp] != ch[rp])
                return (validSubPalindrome(ch, lp+1, rp) || validSubPalindrome(ch, lp, rp-1) );
//                return false;
            lp++;
            rp--;
        }

        return true;
    }

    private static boolean validSubPalindrome(char[] ch, int lp, int rp) {
        while (lp <= rp) {
            if (ch[lp] != ch[rp])
                return false;
            lp++;
            rp--;
        }
        return true;
    }

    private static String processString(String s) {
        return s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
    }
}
