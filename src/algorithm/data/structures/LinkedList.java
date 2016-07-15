package algorithm.data.structures;

import java.util.List;

/**
 * Created by ned on 7/8/16.
 */
public class LinkedList<T> {
    // what does it do?
    // - has items
    //      - list of nodes
    // - add item
    // - remove item
    // - get item at index
    // - contains item
    private Node<T> head;

    private class Node<T> {
        // has item, next, prev
        public T item;
        public Node next;
        public Node prev;

        public Node(final T item) {
            this.item = item;
        }

        @Override
        public String toString() {
            return item.toString();
        }
    }

    public LinkedList() {
    }

    public void add(final T item) {
        final Node<T> node = new Node<T>(item);

        if (null == head) {
            head = node;
        } else {
            final Node last = getLastNode();
            last.next = node;
            node.prev = last;
        }
    }

    public void remove(final T item) {
        if (null != head) {
            final Node itemNode = getItemNode(item);

            if (null == itemNode) {
                p("Item not found");
            } else {
                // Check for head
                if (head == itemNode) {
                    p("Removing " + item + " from head");
                    head = itemNode.next;

                    // Set previous, if head still exists (head wasn't the only node)
                    if (null != head) {
                        head.prev = null;
                    }
                } else {
                    p("Removing " + item + " from further in list");
                    itemNode.prev.next = itemNode.next;

                    if (null != itemNode.next) {
                        itemNode.next.prev = itemNode.prev;
                    }
                }
            }
        }
    }

    public boolean contains(final T item) {
        return null != getItemNode(item);
    }

    private Node getLastNode() {
        Node last = null;

        if (null != head) {
            last = head;

            while (null != last.next) {
                last = last.next;
            }
        }

        return last;
    }

    private Node getItemNode(final T item) {
        Node itemNode = null;

        // Traverse to find item
        if (null != head) {
            Node current = head;

            // Check first
            if (current.item.equals(item)) {
                itemNode = current;
            }

            // If not in first, check rest
            while (null != current.next && null == itemNode) {
                if (current.item.equals(item)) {
                    itemNode = current;
                }

                current = current.next;
            }
        }

        return itemNode;
    }

    private void p(final String s) {
        System.out.println(s);
    }

    @Override
    public String toString() {
        String string = "LinkedList: [";

        if (null != head) {
            Node current = head;
            Node next = head.next;

            string += current;

            // Traverse
            while (null != next) {
                current = next;
                next = current.next;

                string += ", " + current;
            }
        }

        string += "]";

        return string;
    }
}
