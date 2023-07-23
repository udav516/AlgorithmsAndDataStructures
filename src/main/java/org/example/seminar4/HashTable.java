package org.example.seminar4;

public class HashTable {
    class Entity {
        private int key;
        private int value;
    }

    class List {
        private Node node;

        class Node {
            private Entity key;
            private Node node;
        }
    }

}
