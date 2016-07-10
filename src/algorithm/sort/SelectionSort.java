package algorithm.sort;

import algorithm.sort.Sort;

/**
 * Created by ned on 7/7/16.
 */
public class SelectionSort implements Sort {
    private int count = 0;

    @Override
    public void sort(final int[] numbers) {
        // From left to right, find the next min value and replace it, moving down the line
        count = 0;

        for (int x = 0; x < numbers.length - 1; x++) {
            count++;

            final int minIndex = getMinIndex(numbers, x);
            swap(numbers, x, minIndex);
        }
    }

    private int getMinIndex(final int[] numbers, final int startIndex) {
        // From left to right, find min index, updating as you find lower values
        int minIndex = startIndex;
        int min = numbers[minIndex];

        for (int x = minIndex + 1; x < numbers.length; x++) {
            count++;

            // Check and update
            if (numbers[x] < min) {
                minIndex = x;
                min = numbers[x];
            }
        }

        return minIndex;
    }

    @Override
    public String getName() {
        return "Selection algorithm.sort.Sort";
    }

    @Override
    public String getStats() {
        return "Time: O(n^2); Space: O(1)";
    }

    @Override
    public int getLastCount() {
        return count;
    }

    private void swap(final int[] items, final int x, final int y) {
        final int tmp = items[x];
        items[x] = items[y];
        items[y] = tmp;
    }
}
