package org.example.seminar3;

public class Task1 {
    private Node head;

    private class Node {
        private Node next;
        private int value;
    }

    public void addFirst(int value) {
        Node node = new Node();
        node.value = value;
        node.next = head;
        head = node;
    }

    public void removeFirst() {
        if (head != null) {
            head = head.next;
        }
    }

    public boolean contains(int value) {
        Node node = head;
        while (node != null) {
            if (node.value == value) {
                return true;
            }
            node = node.next;
        }
        return false;
    }
}
