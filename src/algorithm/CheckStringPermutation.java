package algorithm;

/**
 * Created by ned on 7/10/2016.
 */
public class CheckStringPermutation implements Algorithm {
    private int count = 0;

    // Check if s2 is a permutation of s1
    // When is it a permutation?
    // - when equal: "ned" is a permutation of "ned"
    public boolean check(final String s1, final String s2) {
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
