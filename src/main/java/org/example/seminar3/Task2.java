package org.example.seminar3;

public class Task2 {
    private Node head;
    private Node tail;


    private class Node {
        private Node next;
        private Node prev;
        private int value;
    }

    // [Node <=> NodeTest]
    public void addFirst(int value) {
        Node node = new Node();
        node.value = value;
        if (head != null) {
            node.next = head;
            head.prev = node;
        } else {
            tail = node;
        }
        head = node;
    }

    public void removeFirst() {
        if (head != null && head.next != null) {
            head.next.prev = null;
            head = head.next;
        } else {
            head = null;
            tail = null;
        }
    }

    public void addLast(int value) {
        Node node = new Node();
        node.value = value;
        if (tail != null) {
            node.prev = tail;
            tail.next = node;
        } else {
            head = node;
        }
        tail = node;
    }

    public void removeLast() {
        if (tail != null && tail.prev != null) {
            tail = tail.prev;
            tail.next = null;

        } else {
            head = null;
            tail = null;
        }
    }
}
