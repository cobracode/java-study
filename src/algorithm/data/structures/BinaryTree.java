package algorithm.data.structures;

/**
 * Created by ned on 7/18/16.
 */
public class BinaryTree {
    private static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(final int value) {
            data = value;
        }

        @Override
        public String toString() {
            return "[Node: value = " + data + "]";
        }
    }

    private static class ChildParentPair {
        private Node child;
        private Node parent;

        public ChildParentPair(final Node child, final Node parent) {
            this.child = child;
            this.parent = parent;
        }


    }

    private Node root;

    public void add(final int value) {
        final Node newNode = new Node(value);

        if (null == root) {
            root = newNode;
        } else {
            // Add item to left-most open child
            final Node openNode = getFirstNodeNeedingAChild(root);

            if (null == openNode.left) {
                openNode.left = newNode;
            } else {
                openNode.right = newNode;
            }
        }
    }


    public boolean contains(final int value) {
        // Start at root
        return containsHelper(root, value);
    }

    private boolean containsHelper(final Node startingNode, final int value) {
        if (null == startingNode) {
            return false;
        }

        // Check current
        if (startingNode.data == value) {
            return true;
        }

        // Check left
        if (containsHelper(startingNode.left, value)) {
            return true;
        } else {
            // Check right
            return containsHelper(startingNode.right, value);
        }
    }


    public boolean remove(final int value) {
        // Find node with value
        return deleteNode(root, null, value);
    }

    public int size() {
        return sizeHelper(root);
    }

    private int sizeHelper(final Node current) {
        if (null == current) {
            return 0;
        }

        // Count left and right subtrees
        final int left = sizeHelper(current.left);
        final int right = sizeHelper(current.right);

        return 1 + left + right;
    }

    private void deleteFromParent(final Node parent, final Node child, final Node grandChild) {
        // Grandchild is OK if it's null
        if (parent.left == child) {
            parent.left = grandChild;
        } else {
            parent.right = grandChild;
        }
    }

    private Node getRightmostChild(final Node current, Node parent) {
        if (null == current) {
            return null;
        }

        // Update parent
        parent = current;

        // Get rightmost child of current; if null, return current
        final Node rightmost = getRightmostChild(current.right, parent);

        if (null != rightmost) {
            return rightmost;
        } else {
            return current;
        }
    }

    private boolean deleteNode(final Node current, final Node parent, final int value) {
        if (null == current) {
            return false;
        }

        // Different approach based on # children
        switch (getNumChildren(current)) {
            case 0:
                // Remove reference from parent
                if (null != parent) {
                    deleteFromParent(parent, current, null);
                } else {
                    // We're at root, with no children. Just set to null
                    root = null;
                }

                return true;
            case 1:
                final Node child = (null != current.left) ? current.left : current.right;

                // Set parent to point to child
                if (null != parent) {
                    deleteFromParent(parent, current, child);
                } else {
                    // We're at root; make child root
                    root = child;
                }

                return true;
            case 2:
                Node rightmostParent = current;

                // Delete current, making left-side right-most child new subtree root
                final Node newRoot = getRightmostChild(current.left, rightmostParent);

                // Detach newRoot from its parent
                p("Rightmost child: " + newRoot + "; parent: " + rightmostParent);
                break;
            default:
                break;
        }

//        // Check input
//        if (null == startingNode) {
//            return false;
//        }
//
//        // Root node
//        if (root == startingNode) {
//            root = null;
//        }
//
//        // Check value
//        if (startingNode.data == value) {
//            // Remove this node
//            // Based on num children:
//            // 0 - null predecessor reference to node
//            // 1 - replace predecessor reference from node to child
//
//
//            switch (getNumChildren(startingNode)) {
//                case 0:
//                    if (null != predecessor) {
//                        // Find which left or right this Node is
//                        // and null the reference
//                        if (predecessor.left == startingNode) {
//                            predecessor.left = null;
//                        } else {
//                            predecessor.right = null;
//                        }
//                    }
//
//                    break;
//                case 1:
//                    if (null == predecessor) {
//
//                    }
//
//                    break;
//            }
//        }

        return false;
    }

    private int getNumChildren(final Node node) {
        int numChildren = 0;

        if (null != node.left) {
            numChildren++;
        }

        if (null != node.right) {
            numChildren++;
        }

        return numChildren;
    }

    public void print() {
        printHelper(root, 0);
    }

    private void printHelper(final Node startingNode, final int depth) {
        // Stop when null
        if (null == startingNode) {
            return;
        }

        // Print current node
        p("Depth " + depth + " - " + startingNode.toString());


        printHelper(startingNode.left, depth + 1);
        printHelper(startingNode.right, depth + 1);
    }

    private Node getFirstNodeNeedingAChild(final Node startingNode) {
        if (null == startingNode) {
            return null;
        }

        // Check this node
        if (null == startingNode.left || null == startingNode.right) {
            return startingNode;
        }

        Node leftCheckedNode = getFirstNodeNeedingAChild(startingNode.left);

        if (null == leftCheckedNode) {
            return getFirstNodeNeedingAChild(startingNode.right);
        } else {
            return leftCheckedNode;
        }
    }

    private static void p(final String s) {
        System.out.println(s);
    }

    @Override
    public String toString() {
        return "[BinaryTree: size " + size() + "]";
    }
}
