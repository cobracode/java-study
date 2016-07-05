import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by ned on 6/26/16.
 */
public class Main {
    private static final List<int[]> inputList = new ArrayList<int[]>();
    private static final List<Algorithm> algorithms = new ArrayList<Algorithm>();


    public static final void main(final String[] args) {
        loadInput();
        loadAlgorithms();
        runAlgorithms();

        runSorts();
    }

    private static void runSorts() {
        final Search linear = new LinearSearch();

        final int[] items = {0, 3, 88, 1, -1, 82, 34};

        final int result = linear.search(items, 82);
        p("result: " + result);
    }

    private static void runAlgorithms() {
        long startTime = 0;
        long sortStartTime = 0;

        for (final Algorithm algorithm : algorithms) {
            p("Running " + algorithm.getName() + "; " + algorithm.getStats() + "\n");

            sortStartTime = System.currentTimeMillis();

            for (final int[] input : inputList) {
                // Copy input to not ruin it for next sorts
                final int[] inputCopy = Arrays.copyOf(input, input.length);

                p("Acting on " + input.length + " items");
                p("Starting array: " + Arrays.toString(inputCopy));

                startTime = System.currentTimeMillis();

                algorithm.run(inputCopy);

                displayResults(startTime, System.currentTimeMillis(), inputCopy);
            }

            p("\nTOTAL TIME in " +
                    algorithm.getName() + ": " + (System.currentTimeMillis() - sortStartTime) + " millis\n\n");
        }
    }

    private static void p(final String s) {
        System.out.println(s);
    }

    private static void loadAlgorithms() {
        //loadSorts();

        //algorithms.add(new Reverse());
    }

    private static void loadSorts() {
        algorithms.add(new BubbleSort());
        algorithms.add(new MergeSort());
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
        p("Resulting array: " + Arrays.toString(list));
        p("Time: " + (endTime - startTime) + " milliseconds");
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
