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


    public static final void main(final String[] args) {
        loadInput();
        loadSorts();

        long startTime = 0;
        long sortStartTime = 0;

        for (final Sort sort : sorts) {
            System.out.println("Running " + sort.getName() + "; " + sort.getStats() + "\n");

            sortStartTime = System.currentTimeMillis();

            for (final int[] input : inputList) {
                // Copy input to not ruin it for next sorts
                final int[] inputCopy = Arrays.copyOf(input, input.length);

                System.out.println("Sorting " + input.length + " items");

                startTime = System.currentTimeMillis();

                sort.sort(inputCopy);

                displayResults(startTime, System.currentTimeMillis(), inputCopy);
            }

            System.out.println("\nTOTAL TIME in " +
                    sort.getName() + ": " + (System.currentTimeMillis() - sortStartTime) + " millis\n\n");
        }
    }

    private static void loadSorts() {
        sorts.clear();

        sorts.add(new BubbleSort());
        sorts.add(new MergeSort());
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

    private static void displayResults(final long startTime, final long endTime, final int[] list) {
        System.out.println("Sorted list: " + Arrays.toString(list));
        System.out.println("Time: " + (endTime - startTime) + " milliseconds");
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
