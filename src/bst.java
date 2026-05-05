package Assignment_3.BST_1;

import java.util.ArrayList;
import java.util.Iterator; // REQUIRED
import java.util.Stack;

public class bst<K extends Comparable<K>, V> implements Iterable<K> {
    private Node root;
    private int size = 1;

    private class Node {
        private K key;
        private V val;
        private Node left, right;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }


    public void put(K key, V val) {
        if (root == null) {
            root = new Node(key, val);
            return;
        }
        Node current = root;
        Node parent = null;
        int cmp = 0;

        while (current != null) { 
            parent = current;
            cmp = key.compareTo(current.key);
            if (cmp < 0) current = current.left;
            else if (cmp > 0) current = current.right;
            else {
                current.val = val;
                return; // Key exists, just update and exit
            }
        }

        Node newNode = new Node(key, val);
        if (cmp < 0) parent.left = newNode; 
        else parent.right = newNode;
        size++;
    }







    public V get(K key) {
        Node current = root;
        while (current != null) {
            int cmp = key.compareTo(current.key);

            if (cmp < 0) current = current.left;
            else if (cmp > 0) current = current.right;
            else return current.val;
        }
        return null;
    }
    public void delete(K key) {
        Node parent = null;
        Node current = root;

        // 1. Find the node and its parent
        while (current != null) {
            parent = current;
            int cmp = key.compareTo(current.key);
            if (cmp < 0) current = current.left;
            else current = current.right;
        }

        if (current == null) return;

        // 2. Handle Case: Node has 0 or 1 child
        if (current.left == null || current.right == null) {
            Node temp; // Create a reference holder

            if (current.left != null) {
                // If there is a left child, pick it.
                temp = current.left;
            } else {
                // If there is no left child, we pick the right child.
                // (Note: If current.right is also null, temp becomes null,
                // which is correct for a leaf node with no children).
                temp = current.right;
            }

            if (parent == null) {
                root = temp; // Deleting the root
            } else if (parent.left == current) {
                parent.left = temp;
            } else {
                parent.right = temp;
            }
            size--;
        }
        // 3. Handle Case: Node has 2 children
        else {

            Node succParent = current;
            Node successor = current.right;

            while (successor.left != null) {
                succParent = successor;
                successor = successor.left;
            }

            current.key = successor.key;
            current.val = successor.val;

            if (succParent == current) {
                succParent.right = successor.right;
            } else {
                succParent.left = successor.right;
            }

            size--;
        }



    }

    public Iterator<K> iterator() {
        return new Iterator<K>() {
            private Stack<Node> stack = new Stack<>();

            {
                pushLeft(root);
            }

            private void pushLeft(Node node) {
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }

            @Override
            public boolean hasNext() {
                // 1. Check the condition: is the stack empty?
                boolean emptyStatus = stack.isEmpty();

                if (emptyStatus == true) {
                    return false;
                } else {
                    return true;
                }
            }

            @Override
            public K next() {

                Node node = stack.pop();
                K result = node.key;

                if (node.right != null) {
                    pushLeft(node.right);
                }

                return result;
            }
        };
    }

    public static void main(String[] args) {
        bst<String, Integer> tree = new bst<>();

        tree.put("sss", 12);
        tree.put("lll", 22);
        tree.put("hhh", 19);
        tree.put("hhh", 19);

        tree.put("hh", 20);

        tree.put("she", 89);
        tree.put("he", 79);
        tree.put("we", 99);
        tree.put("they", 109);


        tree.delete("hhh");
        tree.iterator();

        for (String key : tree) {
            System.out.println(key + " -> " + tree.get(key));
        }
    }
}





















