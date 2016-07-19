package algorithm.sort;

/**
 * Created by ned on 6/27/16.
 */
public class MergeSort implements Sort {
    private int count;

    @Override
    public void sort(int[] numbers) {
        if (null == numbers || numbers.length < 2) {
            return;
        }

        count = 0;

        sortHelper(numbers, 0, numbers.length - 1);
    }

    private void sortHelper(int[] numbers, int begin, int end) {
        count++;

        // begin must be before end
        if (begin >= end) {
            return;
        }

        final int mid = (begin + end) / 2;

        // Sort first half
        sortHelper(numbers, begin, mid);

        // Sort second half
        sortHelper(numbers, mid + 1, end);

        // Merge results
        merge(numbers, begin, mid, end);
    }

    private void merge(int[] numbers, int begin, int mid, int end) {
        // Copy A and B halves
        //final int[] a = Arrays.copyOfRange(numbers, begin, mid);
        //final int[] b = Arrays.copyOfRange(numbers, mid + 1, end);

        final int aSize = mid - begin + 1;//(mid - begin == 0) ? 1 : mid - begin;
        final int bSize = end - mid;//(end - mid == 0) ? 1 : end - mid;

        int[] a = new int[aSize];
        int[] b = new int[bSize];

        int aIndex = 0;
        int bIndex = 0;
        int nIndex = begin;

        // Copy first half
        for (; nIndex <= mid; aIndex++, nIndex++) {
            count++;

            a[aIndex] = numbers[nIndex];
        }

        // Copy second half
        for (; nIndex <= end; bIndex++, nIndex++) {
            count++;

            b[bIndex] = numbers[nIndex];
        }


        // Reset indices
        aIndex = 0;
        bIndex = 0;
        nIndex = begin;


        // Iterate until reach the first end, placing lower value in numbers
        while (aIndex < a.length && bIndex < b.length) {
            count++;

            // Compare
            if (a[aIndex] < b[bIndex]) {
                numbers[nIndex++] = a[aIndex++];
            } else {
                numbers[nIndex++] = b[bIndex++];
            }
        }

        // Copy any stragglers from A or B

        while (aIndex < a.length) {
            count++;

            numbers[nIndex++] = a[aIndex++];
        }

        while (bIndex < b.length) {
            count++;

            numbers[nIndex++] = b[bIndex++];
        }
    }

    @Override
    public String getName() {
        return "Merge Sort";
    }

    @Override
    public String getStats() {
        return "O(n) best; O(n log n) worst; O(n log n) avg; SPACE: O(n)";
    }

    @Override
    public int getLastCount() {
        return count;
    }
}
