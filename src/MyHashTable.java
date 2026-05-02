package Assignment_3.HashTable;

public class MyHashTable<K, V> {

    private class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return " {" + key + " " + value + "}";
        }
    }

    private HashNode<K, V>[] buckets;
    private static final int DEFAULT_SIZE = 11; // prime number → better distribution
    private int size;

    @SuppressWarnings("unchecked")
    public MyHashTable() {
        buckets = new HashNode[DEFAULT_SIZE];
    }

    @SuppressWarnings("unchecked")
    public MyHashTable(int M) {
        buckets = new HashNode[M];
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % buckets.length;
    }







    public void put(K key, V value) {
        int index = hash(key);
        HashNode<K, V> head = buckets[index];
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
            } else {
                head = head.next;

            }
        }
        size++;
        HashNode<K, V> node = new HashNode<>(key, value);
        node.next = buckets[index];// neew data points to old
        buckets[index] = node;

    }



    public V get(K key) {
        int index = hash(key);
        HashNode<K, V> head = buckets[index];
        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;// it needs to read, not write or put. Size stays same
            }
            head = head.next;
        }
        return null;

    }


    public V remove(K key) {
        int index = hash(key);
        HashNode<K,V> head = buckets[index];
        HashNode<K,V> prev = null;
        while(head!= null) {
            if (head.key.equals(key)) {//check chaining values
                if (prev == null) {
                    buckets[index] = head.next;//point to next in case delating first (Hand->1->2->3) points to 2
                } else {
                    prev.next = head.next;
                }
                size--;

            }
            prev = head;
            head = head.next;

        }
        return null;// to comp to understand




    }



    public boolean contains(V value) {
        for (HashNode<K, V> head : buckets) {
            while (head != null) {
                if (head.value.equals(value)) return true;
                head = head.next;
            }
        }
        return false;
    }

    public K getKey(V value) {
        for (HashNode<K, V> head : buckets) {
            while (head != null) {
                if (head.value.equals(value)) return head.key;
                head = head.next;
            }
        }
        return null;
    }

    public int size() { return size; }

    public void printBucketSizes() {
        for (int i = 0; i < buckets.length; i++) {
            int count = 0;
            HashNode<K, V> head = buckets[i];
            while (head != null) { count++; head = head.next; }
            System.out.println("Bucket " + i + ": " + count + " elements");
        }
    }


}