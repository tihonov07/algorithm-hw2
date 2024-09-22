package org.example;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


public class HomeWork extends BinaryIntSearchTree {

    /**
     * <h1>Задание 1.</h1>
     * Дан класс BinaryTree, который реализует бинарное дерево поиска.
     * Реализовать метод findMaxDigits, который возвращает массив
     * наибольших элементов в дереве, не превосходящих upperBound.
     * <br/>
     * Пример :
     * коллекция в дереве 1, 2, 3, 4, 5
     * count = 3, upperBound 4
     * ответ [4, 3, 2]

     *
     * @param count максимальное количество элементов в ответе
     * @param upperBound верхняя граница для поиска элементов
     * @return массив найденных максимальных значений не более чем upperBound и длиной не более count, отсортировано от большего к меньшему
     * Сигнатуру метода не меняем
     */
    public List<Integer> findMaxDigits(int count, int upperBound) {
        //            5
        //      3             8
        //   1     4       7     10
        //      2       6      9

        var result = new ArrayList<Integer>();
        var visitedNodes = new ArrayDeque<Node>();
        findRootNodes(root, upperBound, visitedNodes);
        visitedNodes.forEach(v -> sumBranch(v, count, result, 1));
        return result;
    }

    private void sumBranch(Node node, int maxSize, List<Integer> result, int level) {
        if (node.right != null && level != 1) {
            sumBranch(node.right, maxSize, result, level + 1);
        }
        if (result.size() >= maxSize) {
            return;
        }
        result.add(node.value);
        if (node.left != null) {
            sumBranch(node.left, maxSize, result, level + 1);
        }
    }
    private void findRootNodes(Node node, int upperBound, Deque<Node> visited) {
        if (node == null) {
            return;
        }
        if(node.value <= upperBound) {
            visited.push(node);
            findRootNodes(node.right, upperBound, visited);
        } else {
            findRootNodes(node.left, upperBound, visited);
        }
    }

}
