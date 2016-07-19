package algorithm.sort;

import algorithm.Algorithm;

/**
 * Created by ned on 7/19/16.
 */
public class InsertionSort implements Algorithm, Sort {
    private int count;

    @Override
    public void sort(final int[] numbers) {
        count = 0;

        // Starting at index 1, take number and insert where
        // it belongs to the left, shifting numbers right as needed
        for (int x = 1; x < numbers.length; x++) {
            count++;

            shiftRight(numbers, x - 1, numbers[x]);
        }
    }

    private void shiftRight(final int[] numbers, final int startIndex, final int value) {
        int x = startIndex;

        for (; x >= 0 && value < numbers[x]; x--) {
            count++;

            numbers[x + 1] = numbers[x];
        }

        numbers[x + 1] = value;
    }

    @Override
    public String getName() {
        return "Insertion Sort";
    }

    @Override
    public String getStats() {
        return null;
    }

    @Override
    public int getLastCount() {
        return count;
    }


}
