/**
 * Created by ned on 7/1/16.
 */
public class Reverse implements Algorithm {
    private void swap(final int[] items, final int i, final int n) {
        final int tmp = items[i];
        items[i] = items[n];
        items[n] = tmp;
    }

    @Override
    public int run(int[] items, Object... args) {
        final int last = items.length - 1;
        final int mid = last / 2;

        // Skip 1-element arrays
        if (0 < last) {
            for (int i = 0, n = last; i <= mid && n >= mid; i++, n--) {
                swap(items, i, n);
            }
        }

        return 0;
    }

    @Override
    public String getName() {
        return "Reverse";
    }

    @Override
    public String getStats() {
        return "Time: O(n); Space: O(1)";
    }
}
