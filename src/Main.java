import algorithm.CheckStringPermutation;
import algorithm.CheckUniqueStringChars;
import algorithm.data.structures.Hashtable;
import algorithm.data.structures.LinkedList;
import algorithm.search.BinarySearch;
import algorithm.search.LinearSearch;
import algorithm.search.Search;
import algorithm.sort.BubbleSort;
import algorithm.sort.Reverse;
import algorithm.sort.SelectionSort;
import algorithm.sort.Sort;

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
        testHashtable();


//        loadInput();
//
//        loadSorts();+
//        runSorts();

//        loadSearches();
//        runSearches();
    }

    private static void testHashtable() {
        final Hashtable ht = new Hashtable();

        ht.add("ned");
        ht.add("mystery");
        ht.add("rex");
        ht.add("moe");
        ht.add("ashley");
        ht.add("nedster");
        ht.add("plane");

        for (int x = 0; x < 50; x++) {
            ht.add(String.valueOf(x));
        }

    }

    private static void testStringPermutations() {
        CheckStringPermutation c = new CheckStringPermutation();

        p("'' a permutation of '' ? " + c.check("", ""));
        p("'a' a permutation of 'a' ? " + c.check("a", "a"));
        p("'aa' a permutation of 'aa' ? " + c.check("aa", "aa"));
        p("'ba' a permutation of 'ab' ? " + c.check("ba", "ab"));
        p("'ba' a permutation of 'a' ? " + c.check("ba", "a"));
        p("'a' a permutation of 'ba' ? " + c.check("a", "ba"));

        p("'ned' a permutation of 'den' ? " + c.check("ned", "den"));
        p("'match' a permutation of 'amtch' ? " + c.check("match", "amtch"));
        p("'match' a permutation of 'fishmatch' ? " + c.check("match", "fishmatch"));
    }

    private static void testUniqueStringChars() {
        CheckUniqueStringChars c = new CheckUniqueStringChars();

        p("Checking \"\": " + c.check(""));
        p("Checking \"a\": " + c.check("a"));
        p("Checking \"aa\": " + c.check("aa"));
        p("Checking \"ab\": " + c.check("ab"));
        p("Checking \"ned\": " + c.check("ned"));
        p("Checking \"nedn\": " + c.check("nedn"));
    }

    private static void testLinkedList() {
        LinkedList<String> list = new LinkedList<String>();

        list.add("ned");
        p(list.toString() + "\n");

        list.add("tom");
        p(list.toString() + "\n");

        list.add("sabrina");
        p(list.toString() + "\n");

        list.remove("ned2");
        p(list.toString() + "\n");

        list.remove("ned");
        p(list.toString() + "\n");

        list.remove("ned");
        p(list.toString() + "\n");

        list.remove("tom");
        p(list.toString() + "\n");

        p("\nIs ned in list? " + list.contains("ned"));
        p("\nIs ashley in list? " + list.contains("ashley"));
        p("\nIs sabrina in list? " + list.contains("sabrina"));

        p(list.toString());
    }

    private static void loadSearches() {
        searches.add(new LinearSearch());
        searches.add(new BinarySearch());
    }

    private static void loadSorts() {
        sorts.add(new BubbleSort());
        //sorts.add(new MergeSort());
        sorts.add(new Reverse());
        sorts.add(new SelectionSort());
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
        int countSum = 0;
        int nSum = 0;

        for (final Sort sort : sorts) {
            countSum = 0;
            nSum = 0;

            p("Running " + sort.getName() + "; " + sort.getStats() + "\n");

            for (final int[] input : inputList) {
                // Copy input to not ruin it for next sorts
                final int[] inputCopy = Arrays.copyOf(input, input.length);
                nSum += inputCopy.length;

                p("Acting on " + input.length + " items");
                p("Starting array: " + Arrays.toString(inputCopy));

                sort.sort(inputCopy);

                p("End array: " + Arrays.toString(inputCopy) + "\n");
                p("Took " + sort.getLastCount() + " operations\n\n");

                countSum += sort.getLastCount();
            }

            final double ratio = (double)countSum / (double)nSum;
            p(sort.getName() + " TOTAL OPERATIONS: " + countSum + " -  TOTAL N: " + nSum + "  -- RATIO: " + ratio + "\n\n\n");
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
