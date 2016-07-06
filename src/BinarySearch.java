/**
 * Created by ned on 7/4/16.
 */
class BinarySearch implements Search {
    private int count = 0;

    @Override
    public String getName() {
        return "Binary Search";
    }

    @Override
    public String getStats() {
        return "Time: O(log n); Space: O(1)";
    }

    @Override
    public int getLastCount() {
        return count;
    }

    @Override
    public int search(final int[] items, final int value) {
        int min = 0;
        int max = items.length - 1;
        int guessIndex = 0;

        count = 0;

        while (min <= max) {
            guessIndex = (min + max) / 2;
            final int guess = items[guessIndex];

            count++;

            if (value == guess) {
                // Found it
                return guessIndex;
            } else if (value > guess) {
                min = guessIndex + 1;
            } else {
                max = guessIndex - 1;
            }
        }

        return -1;
    }
}
