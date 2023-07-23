package org.example.seminar4;

public class HashTable<K, V> {
    private final int SIZE = 10;
    List[] list;

    public HashTable(int size) {
        list = (List[]) new Object[size];
    }

    public int calculateBacketIndex(K key) {
        return key.hashCode() % list.length;
    }

    class Entity {
        private K key;
        private V value;
    }

    class List {
        private Node head;

        class Node {
            private Entity value;
            private Node next;
        }
    }

}
