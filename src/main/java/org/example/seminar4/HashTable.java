package org.example.seminar4;

public class HashTable<K, V> {
    private final int SIZE = 10;
    List[] list;

    public HashTable(int size) {
        list = (List[]) new Object[size];
    }

    public int calculateBucketIndex(K key) {
        return key.hashCode() % list.length;
    }

    public V findValueInList(K key) {
        int index = calculateBucketIndex(key);
        if (list[index] != null) {
            return list[index].findValue(key);
        }
        return null;
    }

    class Entity {
        private K key;
        private V value;
    }

    class List {
        private Node head;

        class Node {
            private Entity data;
            private Node next;
        }

        public V findValue(K key) {
            Node node = head;
            while (node != null) {
                if (node.data.key.equals(key)) {
                    return node.data.value;
                }
                node = node.next;
            }
            return null;
        }
    }

}
