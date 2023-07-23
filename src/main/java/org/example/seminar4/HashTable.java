package org.example.seminar4;

public class HashTable<K, V> {
    private final int SIZE = 10;
    private int length = 0;
    private double loadFactor = 0.75;
    List[] list;

    public HashTable(int size) {
        list = (List[]) new Object[size];
    }

    public HashTable() {
        list = (List[]) new Object[SIZE];
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

    public boolean addItem(K key, V value) {
        if (list.length > length * loadFactor) {
            reCalculate();
        }
        Entity newEntity = new Entity();
        newEntity.key = key;
        newEntity.value = value;
        int index = calculateBucketIndex(key);
        List itemList = list[index];
        if (itemList == null) {
            itemList = new List();
            list[index] = itemList;
        }
        boolean flag = list[index].add(newEntity);
        if (flag) {
            length++;
        }
        return flag;
    }

    public boolean removeItem(K key) {
        int index = calculateBucketIndex(key);
        boolean flag = list[index].remove(key);
        if (flag) {
            length--;
        }
        return flag;
    }

    public void reCalculate() {
        List[] oldList = list;
        list = (List[]) new Object[oldList.length * 2];
        for (int i = 0; i < oldList.length; i++) {
            List itemList = oldList[i];
            List.Node node = itemList.head;
            while (node != null) {
                addItem(node.data.key, node.data.value);
                node = node.next;
            }
            oldList[i] = null;
        }
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
