import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by ned on 6/26/16.
 */
public class Main {
    private static final List<int[]> inputList = new ArrayList<int[]>();
    private static final List<Sort> sorts = new ArrayList<Sort>();
    private static final List<Search> searches = new ArrayList<Search>();


    public static final void main(final String[] args) {
        loadInput();

        loadSorts();
        runSorts();

        loadSearches();
        runSearches();
    }

    private static void loadSearches() {
        searches.add(new LinearSearch());
        searches.add(new BinarySearch());
    }

    private static void loadSorts() {
        sorts.add(new BubbleSort());
        //sorts.add(new MergeSort());
        sorts.add(new Reverse());
    }

    private static void runSearches() {
        final BubbleSort bs = new BubbleSort();

        for (final Search search : searches) {
            p("Running " + search.getName() + "; " + search.getStats() + "\n");

            for (final int[] input : inputList) {
                // Copy input to not ruin it for next sorts
                final int[] sortedList = Arrays.copyOf(input, input.length);
                bs.sort(sortedList);
                final int value = 3;

                p("Searching " + input.length + " items for " + value);
                p("Starting array: " + Arrays.toString(sortedList));

                final int resultIndex = search.search(sortedList, value);

                p("Index: " + resultIndex);
                p("Took " + search.getLastCount() + " operations\n\n");
            }
        }
    }

    private static void runSorts() {
        for (final Sort sort : sorts) {
            p("Running " + sort.getName() + "; " + sort.getStats() + "\n");

            for (final int[] input : inputList) {
                // Copy input to not ruin it for next sorts
                final int[] inputCopy = Arrays.copyOf(input, input.length);

                p("Acting on " + input.length + " items");
                p("Starting array: " + Arrays.toString(inputCopy));

                sort.sort(inputCopy);
            }
        }
    }

    private static void p(final String s) {
        System.out.println(s);
    }



    private static void loadInput() {
        inputList.clear();

        inputList.add(new int[] {});
        inputList.add(new int[] {1});
        inputList.add(new int[] {1, 2});
        inputList.add(new int[] {2, 1});
        inputList.add(new int[] {1, 2, 3});
        inputList.add(new int[] {2, 1, 3});
        inputList.add(new int[] {3, 2, 1});
        inputList.add(new int[] {10, 2, -10, 48, 1});
        inputList.add(getRandomList(100));
        inputList.add(getRandomList(1000));
        inputList.add(getRandomList(5000));
    }

    private static int[] getRandomList(final int numItems) {
        final int[] list = new int[numItems];

        final Random rand = new Random();

        for (int x = 0; x < numItems; x++) {
            list[x] = rand.nextInt(1000);
        }

        return list;
    }
}
