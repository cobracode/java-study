package algorithm.sort;

/**
 * Created by ned on 7/1/16.
 */
public class Reverse implements Sort {
    private int count = 0;

    private void swap(final int[] items, final int i, final int n) {
        final int tmp = items[i];
        items[i] = items[n];
        items[n] = tmp;
    }

    @Override
    public void sort(int[] items) {
        final int last = items.length - 1;

        count = 0;

        if (0 < last) {
            final int mid = last / 2;

            for (int x = 0; x <= mid; x++) {
                count++;

                swap(items, x, last - x);
            }
        }
    }

    public void sort2(int[] items) {
        final int last = items.length - 1;
        final int mid = last / 2;

        count = 0;

        // Skip 1-element arrays
        if (0 < last) {
            for (int i = 0, n = last; i <= mid && n >= mid; i++, n--) {
                count++;
                swap(items, i, n);
            }
        }
    }

    @Override
    public String getName() {
        return "algorithm.sort.Reverse";
    }

    @Override
    public String getStats() {
        return "Time: O(n); Space: O(1)";
    }

    @Override
    public int getLastCount() {
        return count;
    }
}
