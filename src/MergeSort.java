/**
 * Created by ned on 6/27/16.
 */
public class MergeSort implements Sort {
    @Override
    public void sort(final int[] numbers) {
        // TODO
    }

    @Override
    public int run(int[] items, Object... args) {
        sort(items);
        return 0;
    }

    @Override
    public String getName() {
        return "Merge Sort";
    }

    @Override
    public String getStats() {
        return "O(n) best; O(n log n) worst; O(n log n) avg; SPACE: O(n)";
    }


    private void divideArray() {

    }
}
