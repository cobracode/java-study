package algorithm;

import utils.StringUtils;

/**
 * Created by ned on 7/10/2016.
 */
public class CheckStringPermutation implements Algorithm {
    private int count = 0;
    private static final int ASCII_SIZE = 256;

    // Check if s2 is a permutation of s1
    // INPUTS: ASCII or Unicode strings? assume ascii for simplicity (256 chars)
    // When is it a permutation?
    // - when equal: "ned" is a permutation of "ned"
    // - when all items in s2 are in s1 in the same amount
    // - strings must be same length
    public static boolean check(final String s1, final String s2) {
        // Check length
        if (s1.length() == s2.length()) {
            // could use an array, like in unique chars
            final int[] s1Counts = StringUtils.getCharCounts(s1);
            final int[] s2Counts = StringUtils.getCharCounts(s2);


            return StringUtils.charCountsEqual(s1Counts, s2Counts);
        }

        return false;
    }

    @Override
    public String getName() {
        return "String Permutation Checker";
    }

    @Override
    public String getStats() {
        return "TODO";
    }

    @Override
    public int getLastCount() {
        return count;
    }
}
