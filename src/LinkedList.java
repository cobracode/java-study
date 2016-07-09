import java.util.List;

/**
 * Created by ned on 7/8/16.
 */
class LinkedList<T> {
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
            p("Creating Node for " + item);
            this.item = item;
        }

        @Override
        public String toString() {
            return item.toString();
        }
    }

    LinkedList() {
        p("Creating LinkedList");
    }

    void add(final T item) {
        final Node<T> node = new Node<T>(item);

        if (null == head) {
            p("Adding " + item + " to head");
            head = node;
        } else {
            p("Adding " + item + " to end");

            final Node last = getLastNode();
            last.next = node;
            node.prev = last;
        }
    }

    void remove(final T item) {
        p("Removing " + item);

        if (null == head) {
            p("!! No items to remove");
        } else {
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

    private Node getLastNode() {
        Node last = null;

        if (null != head) {
            Node current = head;
            Node next = current.next;

            while (null != next) {
                current = next;
                next = current.next;
            }

            last = current;
        }

        return last;
    }

    private Node getItemNode(final T item) {
        p("Getting item Node for: " + item);
        Node itemNode = null;

        // Traverse to find item
        if (null != head) {
            Node current = head;
            Node next = current.next;

            while (null != next && null == itemNode) {
                // Check item
                if (current.item == item) {
                    p("Found item node");
                    itemNode = current;
                } else {
                    current = next;
                    next = current.next;
                }
            }

            if (null == itemNode) {
                p("Did not find item in list");
            }
        } else {
            p(item + " not in empty list");
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
