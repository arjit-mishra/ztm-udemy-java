package String;

class BackstrokingCompare {
    public static void main(String[] args) {
        System.out.println("ab#c - ad#c = " + compare("ab#c", "ad#c"));
        System.out.println("ab## - c#d# = " + compare("ab##", "c#d#"));
        System.out.println("a#c - b = " + compare("a#c", "b"));
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
                } // skip the character beacause of backcount
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