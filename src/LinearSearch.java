/**
 * Created by ned on 7/4/16.
 */
class LinearSearch implements Search {
    @Override
    public int search(final int[] items, final  int value) {
        for (int x = 0; x < items.length; x++) {
            // Check
            if (value == items[x]) {
                return x;
            }
        }

        return -1;
    }

    @Override
    public String getName() {
        return "Linear Search";
    }

    @Override
    public String getStats() {
        return "Time: O(n); Space: O(1)";
    }
}
