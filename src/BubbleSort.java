/**
 * Created by ned on 6/26/16.
 */
public class BubbleSort implements Sort {
    @Override
    public void sort(final int[] numbers) {
        final int lastIndex = numbers.length - 1;

        // From last to 1
        for (int last = lastIndex; last > 0; last--) {
            // From first to last
            for (int compare = 0; compare < last; compare++) {
                if (numbers[compare] > numbers[compare + 1]) {
                    swap(numbers, compare, compare + 1);
                }
            }
        }
    }

    private void swap(final int[] numbers, final int x, final int y) {
        final int tmp = numbers[x];
        numbers[x] = numbers[y];
        numbers[y] = tmp;
    }


    @Override
    public int run(int[] items, Object... args) {
        sort(items);
        return 0;
    }

    @Override
    public String getName() {
        return "Bubble Sort";
    }

    @Override
    public String getStats() {
        return "O(n^2) best; O(n^2) worst; O(n^2) avg; SPACE: O(1)";
    }
}
