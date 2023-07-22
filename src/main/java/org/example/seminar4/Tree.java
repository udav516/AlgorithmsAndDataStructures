package org.example.seminar4;

import java.util.*;

public class Tree {
    Node root;

    /**
     * Запуск поиска
     * @param value искомое значение
     * @return результат поиска true/false
     */
    public boolean exist(int value) {
        if (root != null) {
            Node node = find(root, value);
            if (node != null) {
                return true;
            }
        }
        return false;
    }

    /**
     * Поиск узла в глубину дерева через рекурсию
     * @param node   текущий узел
     * @param values искомое значение
     * @return найденный узел
     */
    private Node find(Node node, int values) {
        if (node.value == values) {
            return node;
        } else {
            for (Node child : node.children) {
                Node result = find(child, values);
                if (result != null) {
                    return result;
                }
            }
        }
        return null;
    }

    /**
     * Поиск узла в ширину дерева через цикл
     * @param value искомое значение
     * @return найденный узел
     */
    private Node find(int value) {
        List<Node> line = new ArrayList<>();
        line.add(root);
        while (line.size() > 0) {
            List<Node> nextLine = new ArrayList<>();
            for (Node node : line) {
                if (node.value == value) {
                    return node;
                }
                nextLine.addAll(node.children);
            }
            line = nextLine;
        }
        return null;
    }

    public class Node {
        int value;
        List<Node> children;
    }
}
