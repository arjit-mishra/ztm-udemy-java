package String;

public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal : panama";//true
        String s1 = "";//true
        String s2 = "abc";//false
        String s3 = "aabcdd";//false
        String s4 = "aacbbcaa";//true

        System.out.println(s +" is palindrome? "+ isPalindrome1(processString(s)));
        System.out.println(s1 +" is palindrome? "+ isPalindrome1(processString(s1)));
        System.out.println(s2 +" is palindrome? "+ isPalindrome1(processString(s2)));
        System.out.println(s3 +" is palindrome? "+ isPalindrome1(processString(s3)));
        System.out.println(s4 +" is palindrome? "+ isPalindrome1(processString(s4)));

        System.out.println();
        System.out.println();

        System.out.println(s +" is palindrome? "+ isPalindrome2(processString(s)));
        System.out.println(s1 +" is palindrome? "+ isPalindrome2(processString(s1)));
        System.out.println(s2 +" is palindrome? "+ isPalindrome2(processString(s2)));
        System.out.println(s3 +" is palindrome? "+ isPalindrome2(processString(s3)));
        System.out.println(s4 +" is palindrome? "+ isPalindrome2(processString(s4)));


        System.out.println();
        System.out.println();

        System.out.println(s +" is palindrome? "+ isPalindrome3(processString(s)));
        System.out.println(s1 +" is palindrome? "+ isPalindrome3(processString(s1)));
        System.out.println(s2 +" is palindrome? "+ isPalindrome3(processString(s2)));
        System.out.println(s3 +" is palindrome? "+ isPalindrome3(processString(s3)));
        System.out.println(s4 +" is palindrome? "+ isPalindrome3(processString(s4)));
    }

    private static boolean isPalindrome3(String s) {
        if (s.length()<2)
            return true;
        String reverse = new StringBuilder(s).reverse().toString();

        int lp=0;

        while(lp<s.length()){
            if (s.charAt(lp) != reverse.charAt(lp))
                return false;
            lp++;
        }

        return true;
    }

    private static boolean isPalindrome2(String s) {
        if (s.length()<2)
            return true;

        char[] ch = s.toCharArray();
        int mid = ch.length / 2;
        int rp = mid, lp = mid;

        if(ch.length%2 == 0)
            lp = mid - 1;

        while(lp>=0 && rp<ch.length) {
            if(ch[lp] != ch[rp])
                return false;
            lp--;
            rp++;
        }

        return true;
    }

    private static boolean isPalindrome1(String s){
        if (s.length()<2)
            return true;

        char[] ch = s.toCharArray();
        int lp = 0, rp = ch.length - 1;

        while(lp<=rp) {
            if(ch[lp] != ch[rp])
                return false;
            lp++;
            rp--;
        }

        return true;
    }
    private static String processString(String s){
        return s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
    }
}
