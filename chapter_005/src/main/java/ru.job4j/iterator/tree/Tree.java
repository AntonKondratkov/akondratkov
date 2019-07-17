package ru.job4j.iterator.tree;

import java.util.*;
/**
 * В данном классе происходит проверка работы класса Tree.
 *@author Anton Kondratkov
 *@since 18.07.2019
 */
public class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    private Node<E> root;

    public Tree(E element) {
        this.root = new Node<>(element);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean result = false;
        if (!findBy(child).isPresent()) {
            findBy(parent).get().add(new Node<>(child));
            result = true;
        }
        return result;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    @Override
    public Iterator iterator() {
        return new TreeIterator<E>();
    }

    private class TreeIterator<E extends Comparable<E>> implements Iterator<E> {

        private List<List<Node<E>>> allChild = new ArrayList<>();
        Iterator<List<Node<E>>> itAll;
        Iterator<Node<E>> itCurrent;

        TreeIterator() {
            allChild.add(Arrays.asList((Node<E>)root));
            addChild((Node<E>)root);
            itAll = allChild.iterator();
            itCurrent = itAll.next().iterator();
        }
        /**
         * Метод рекурсивно заполняет список всех списков потомков.
         * @param node
         */
        private void addChild(Node<E> node) {
            List<Node<E>> childOfNode = node.leaves();
            if(childOfNode.size() > 0) {
                allChild.add(childOfNode);
                for (Node<E> current: childOfNode) {
                    addChild(current);
                }
            }
        }
        /**
         * Метод проверяет текущий список потомков.
         * Если он кончился, делает следующий список потомков из общего списка.
         * @return false - потомка в списке нет, true - потомок в списке есть.
         */
        @Override
        public boolean hasNext() {
            boolean result = itCurrent.hasNext();
            if(!result) {
                if(itAll.hasNext()) {
                    itCurrent = itAll.next().iterator();
                    result = itCurrent.hasNext();
                }
            }

            return result;
        }

        @Override
        public E next() {
            if (hasNext()) {
                return itCurrent.next().getValue();
            }
            throw new NoSuchElementException();
        }
    }
}
