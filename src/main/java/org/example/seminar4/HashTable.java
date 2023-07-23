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

        public boolean add(Entity item) {
            Node newNode = new Node();
            Node node = head;
            while (node != null) {
                if (node.data.key.equals(item.key)) {
                    return false;
                }
                if (node.next == null) break;
                node = node.next;
            }
            newNode.data = item;
            node.next = newNode;
            return true;
        }

        public boolean remove(K key) {
            Node node = head;
            Node previous = head;
            if (head != null) {
                if (head.data.key.equals(key)) {
                    head = head.next;
                    return true;
                }
            }
            while (node != null) {
                if (node.data.key.equals(key)) {
                    previous.next = node.next;
                }
                previous = node;
                node = node.next;
            }
            return false;
        }
    }

}
