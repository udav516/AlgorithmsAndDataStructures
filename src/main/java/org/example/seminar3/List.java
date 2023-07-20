package org.example.seminar3;

public class List {
    Node head;
    Node tail;

    /**
     * Добавление элемента в конец двусвязного списока
     * @param value добавляемый элемент
     */
    public void add(int value) {
        Node node = new Node();
        node.value = value;
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.previous = tail;
            tail = node;
        }
    }

    /**
     * Добавление элемента с узлом в двусвязный список
     * @param value добавляемый элемент
     * @param node  добавляемый узел
     */
    public void add(int value, Node node) {
        Node next = node.next;
        Node newNode = new Node();
        newNode.value = value;
        node.next = newNode;
        newNode.previous = node;
        if (next == null) {
            tail = newNode;
        } else {
            next.previous = newNode;
            newNode.next = next;
        }
    }

    /**
     * Удаление узла в двусвязный список
     * @param node удаляемый узел
     */
    private void delete(Node node) {
        Node previous = node.previous;
        Node next = node.next;
        if (previous == null) {
            next.previous = null;
            head = next;
        } else if (next == null) {
            previous.next = null;
            tail = previous;
        } else {
            previous.next = next;
            next.previous = previous;
        }

    }

    /**
     * Поиск элемента в двусвязном списке
     * @param value искомый элемента
     * @return найденное значение
     */
    public Node find(int value) {
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.value == value) {
                return currentNode;
            }
            currentNode = currentNode.next;
        }
        return null;
    }

    /**
     * Разворот двусвязного списка
     */
    public void revert() {
        Node currentNote = head;
        while (currentNote != null) {
            Node next = currentNote.next;
            Node previous = currentNote.previous;
            currentNote.next = previous;
            currentNote.previous = next;
            if (previous == null) {
                tail = currentNote;
            }
            if (next == null) {
                head = currentNote;
            }
            currentNote = next;
        }
    }

    /**
     * Добавление элемента в начало стека
     * @param value добавляемый элемент
     */
    public void push (int value) {
        Node node = new Node();
        node.value =value;
        node.next = head;
        head = node;
    }

    /**
     * Извлечение последнего элемента стека
     * @return последний элемент
     */
    public  Integer pop(){
        Integer result = null;
        if (head != null){
            result = head.value;
            head = head.next;
        }
        return result;
    }
//    /**
//     * Проверка на наличие пустого односвязного списка
//     */
//    public void revert() {
//        if (head != null && head.next != null) {
//            revert(head.next, head);
//        }
//    }
//
//    /**
//     * Разворот односвязного списка
//     * @param currentNode  текущий узел
//     * @param previousNode предыдущий узел
//     */
//    private void revert(Node currentNode, Node previousNode) {
//        if (currentNode.next == null) {
//            head = currentNode;
//        } else {
//            revert(currentNode.next, currentNode);
//        }
//        currentNode.next = previousNode;
//        previousNode.next = null;
//    }

    public class Node {
        int value;
        Node next;
        Node previous;
    }
}
