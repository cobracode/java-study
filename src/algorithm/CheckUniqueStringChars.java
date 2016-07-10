package algorithm;

/**
 * Created by ned on 7/10/2016.
 */
public class CheckUniqueStringChars implements Algorithm {
    private int count = 0;

    public boolean check(final String string) {
        //return checkUsingArray(string);
        return checkUsingContains(string);
    }

    private boolean checkUsingContains(final String string) {
        count = 0;

        // From first to last, check if the remainder of the string
        // contains the character
        for (int x = 0; x < string.length(); x++) {
            // Check if current char is in rest
            final CharSequence c = string.substring(x, x + 1);

            count++;

            if (string.substring(x + 1).contains(c)) {
                return false;
            }
        }

        return true;
    }

//    private boolean checkUsingRecursion(final String string) {
//        // Check n compared to checkUsingRecursion(n-1)
//
//        // Base case: char by itself is always true (unique)
//        if (string.length() < 2) {
//            return true;
//        }
//
//        // Normal case: string[0] != checkUsingRecursion(string[1 - n])
//        char first = string.charAt(0);
//        //boolean x = first
//
//        return false;
//    }

    private boolean checkUsingArray(final String string) {
        count = 0;

        // index is the ASCII code for each char
        final boolean[] charFound = new boolean[128];

        for (int x = 0; x < string.length(); x++) {
            final int index = (int)string.charAt(x);

            count++;

            if (charFound[index]) {
                return false;
            } else {
                charFound[index] = true;
            }
        }

        return true;
    }


    @Override
    public String getName() {
        return "String Unique Char Checker";
    }

    @Override
    public String getStats() {
        return "Using array: Time: O(n); Space: O(1); Using lookahead contains: Time: O(n**2); Space O(1)";
    }

    @Override
    public int getLastCount() {
        return count;
    }
}
