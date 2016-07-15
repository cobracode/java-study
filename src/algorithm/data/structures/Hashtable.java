package algorithm.data.structures;

import algorithm.Algorithm;

import java.util.Arrays;


/**
 * Created by ned on 7/14/16.
 */
public class Hashtable implements Algorithm {
    private String[] table = new String[DEFAULT_SIZE];
    private int size = 0;
    private static int DEFAULT_SIZE = 5;
    private static final String TAG = "Hashtable: ";

    public void add(final String key) {
        final int spotsLeft = table.length - size;

        if (spotsLeft < 1) {
            doubleTable();
        }

        table[getIndex(key)] = key;
        size++;

        printArray(table);
    }

    private void doubleTable() {
        p("Doubling table");
        table = Arrays.copyOf(table, 2*size);
    }

    private int getIndex(final String key) {
        int index = key.hashCode() % table.length;

        // Check if index is taken
        while (null != table[index]) {
            //p("Collision at " + index + "!");
            index = (int)(Math.random() * (table.length - 1));
        }

        p("New index: "+ index);

        return index;
    }

    private void p(String s) {
        System.out.println(TAG + s);
    }

    private void p(final int s) {
        System.out.println(TAG + s);
    }

    public void remove(final String key) {

    }

    public boolean contains(final String key) {
        return false;
    }

    public String get(final String key) {
        return null;
    }

    private void printArray(final String[] array) {
        StringBuffer sb = new StringBuffer();

        sb.append("[");

        for (final String s : array) {
            sb.append(null == s ? "-" : s);
            sb.append(", ");
        }

        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
        }

        sb.append("]");

        p(sb.toString());
    }


    @Override
    public String getName() {
        return "Hashtable";
    }

    @Override
    public String getStats() {
        return null;
    }

    @Override
    public int getLastCount() {
        return 0;
    }
}
