package algorithm;

/**
 * Created by ned on 7/10/16.
 */
public class StringSpaceReplacer implements Algorithm {
    public void replaceSpaces(final char[] string, final int length) {
        // Ex:
        // hi im ned  -->  hi%20im%20ned
        // l1: 9; l2: 13
        // needs: 2*spaces extra indices

        // get required length
        // replace from back to front

        // get required length
        // by counting spaces and multiplying by 2
        int spaces = 0;

        for (int x = 0; x < string.length; x++) {
            if (string[x] == ' ') {
                spaces++;
            }
        }

        final int requiredLength = string.length + 2*spaces;

        for (int x = requiredLength - 1; x >= 0; x--) {

        }
    }

    @Override
    public String getName() {
        return "String Space Replacer";
    }

    @Override
    public String getStats() {
        return "TODO";
    }

    @Override
    public int getLastCount() {
        return 0;
    }
}
