package algorithm.data.structures;

import algorithm.Algorithm;

/**
 * Created by ned on 7/15/16.
 */
public class Hashtable implements Algorithm {
    private static final String TAG = "Hashtable: ";

    // Table of linked lists
    private LinkedList<Entry>[] table = new LinkedList[DEFAULT_SIZE];
    private static final int DEFAULT_SIZE = 3;
    private int count = 0;

    public void put(final String key, final String value) {
        final Entry entry = new Entry(key, value);
        p("Inserting into the table: " + entry);

        // Check size - double table size if out of space
//        if (count >= table.length - 1) {
//            doubleTable();
//        }

        // Get index
        final int index = getIndex(entry.getKey());
        p(key + " --> " + index);

        // Add to tail of linked list at index
        addToIndex(index, entry);

        // Update count
        count++;
    }

    private void addToIndex(int index, final Entry entry) {
        LinkedList<Entry> list = table[index];

        if (null == list) {
            list = new LinkedList<Entry>();
            table[index] = list;
        }

        list.add(entry);
    }

    public String get(final String key) {
        p("Getting key \"" + key + "\"");

        final int index = getIndex(key);

        // Attempt to find key in list at index
        final LinkedList<Entry> list = table[index];

        if (null != list) {
            final Entry entry = list.get(new Entry(key, ""));

            if (null != entry) {
                return (String)entry.getValue();
            }
        }

        return null;
    }

//    private void doubleTable() {
//        final LinkedList<String>[] oldTable = table;
//
//        // Create new table with double existing size
//        final int newSize = 2 * table.length;
//        final LinkedList<String>[] newTable = new LinkedList[newSize];
//        table = newTable;
//
//        // Copy old entries to new table with new hashes
//        // - iterate over all indices
//        for (int index = 0; index < table.length; index++) {
//            // Iterate over items in linked list at index
//            final LinkedList<String> list = table[index];
//
//            // Most existing list to new index
//            //getIndex()
//        }
//
//        table = newTable;
//    }

    private int getIndex(final String key) {
        return key.hashCode() % table.length;
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

    private static void p(final String s) {
        System.out.println(TAG + s);
    }

    private static class Entry {
        private String key;
        private String value;

        public Entry(final String key, final String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }

        @Override
        public boolean equals(final Object obj) {
            // First check for null and class match
            if (null != obj && obj.getClass().getName().equals(Entry.class.getName())) {
                // Right class - check key
                if (key.equals(((Entry)obj).key)) {
                    return true;
                }
            }

            return false;
        }

        @Override
        public String toString() {
            return key + ": " + value;
        }
    }
}
