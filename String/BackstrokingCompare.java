package String;

import java.util.ArrayDeque;
import java.util.Deque;

class BackstrokingCompare {
    public static void main(String[] args) {
        System.out.println("\nBRUTE\n");
        System.out.println("ab#c - ad#c = " + compareBrute("ab#c", "ad#c"));
        System.out.println("ab## - c#d# = " + compareBrute("ab##", "c#d#"));
        System.out.println("a#c - b = " + compareBrute("a#c", "b"));
        System.out.println("bxj##tw - bxj###tw = " + compareBrute("bxj##tw", "bxj###tw"));
        System.out.println("\nSPACE OPTIMIZED\n");
        System.out.println("ab#c - ad#c = " + compare("ab#c", "ad#c"));
        System.out.println("ab## - c#d# = " + compare("ab##", "c#d#"));
        System.out.println("a#c - b = " + compare("a#c", "b"));
        System.out.println("bxj##tw - bxj###tw = " + compare("bxj##tw", "bxj###tw"));

    }


     public static boolean compareBrute(String s, String t) {

         return finalBuild(s).equals(finalBuild(t));

     }

     public static String finalBuild(String s){
         Deque<Character> stk = new ArrayDeque<>();

         for(Character ch: s.toCharArray())
             if(ch != '#')
                 stk.push(ch);
             else if(stk.size() > 0)
                 stk.pop();
         return String.valueOf(stk);

     }
    private static boolean compare(String s, String t) {

        int p = s.length() - 1, q = t.length() - 1;
        int bcS = 0, bcT = 0;

        while (p >= 0 || q >= 0) {

            // find correct character to compare in first string
            while (p >= 0) {
                if (s.charAt(p) == '#') {
                    bcS++;
                    p--;
                } // found hash, increase back count, skip current character
                else if (bcS > 0) {
                    bcS--;
                    p--;
                } // skip the character because of back-count
                else
                    break; // found the character
            }

            while (q >= 0) {
                if (t.charAt(q) == '#') {
                    bcT++;
                    q--;
                } else if (bcT > 0) {
                    bcT--;
                    q--;
                } else
                    break;
            }

            // character don't match
            if (p >= 0 && q >= 0 && (s.charAt(p) != t.charAt(q)))
                return false;

            // if one of the array is finished
            if (p < 0 != q < 0)
                return false;

            // if both the arrays are finished or number matches
            p--;
            q--;

        }

        return true;
    }
}