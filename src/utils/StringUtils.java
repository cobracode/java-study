package utils;

/**
 * Created by ned on 7/10/16.
 */
public class StringUtils {
    public static final int ASCII_SIZE = 256;

    public static boolean charCountsEqual(final int[] c1, final int[] c2) {
        for (int x = 0; x < ASCII_SIZE; x++) {
            if (c1[x] != c2[x]) {
                return false;
            }
        }

        return true;
    }

    public static int[] getCharCounts(final String string) {
        final int[] counts = new int[ASCII_SIZE];

        for (int x = 0; x < string.length(); x++) {
            counts[string.charAt(x)]++;
        }

        return counts;
    }
}
