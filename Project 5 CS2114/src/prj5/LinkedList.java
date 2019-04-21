/**
 * 
 */
package prj5;

import java.util.Comparator;

/**
 * @author Tom
 * @author Eriq Taing (eriq12)
 * @version 4/20/2019
 *
 *          Creates a linkedList
 */
public class LinkedList<T> {

    private class Node<S> {
        private S data;
        private Node<S> next;
        private Node<S> prev;


        /**
         * constructor
         * 
         * @param d
         *            data
         */
        public Node(S d) {
            data = d;
            next = null;
            prev = null;
        }


        /**
         * returns next node
         * 
         * @return next node
         */
        public Node<S> getNext() {
            return next;
        }


        /**
         * returns previous node
         * 
         * @return previous node
         */
        public Node<S> getPrev() {
            return prev;
        }


        /**
         * getter
         * 
         * @return data of node
         */
        public S getData() {
            return data;
        }


        private void linkWith(Node<S> n) {
            next = n;
            n.next = this;
        }


        /**
         * set next node of current
         * 
         * @param next
         *            node to set to
         */
        public void setNext(Node<S> next) {
            this.next = next;
        }


        private void insertAfter(Node<S> n) {
            Node<S> temp = n.next;
            n.linkWith(this);
            linkWith(temp);
            size++;
        }


        /**
         * returns if this
         * 
         * @return if the next node is not the tail
         */
        public boolean hasNext() {
            return next != tail;
        }


        /**
         * removes node from the list
         * 
         * @return the node being removed
         */
        public Node<S> remove() {
            prev.linkWith(next);
            return this;
        }
    }

    Node<T> head;
    Node<T> tail;
    int size;


    /**
     * constructor
     */
    public LinkedList() {
        head = new Node<T>(null);
        tail = new Node<T>(null);
        init();
    }


    private void init() {
        size = 0;
        head.linkWith(tail);
    }


    /**
     * getter
     * 
     * @return size
     */
    public int getSize() {
        return size;
    }


    /**
     * getter of an element
     * 
     * @param index
     *            of where the element is
     * @return data at index
     * @throws IndexOutOfBoundsException
     */
    public T get(int index) {
        Node<T> header = head;

        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        for (int i = 0; i < index; i++) {
            header = header.getNext();
        }

        return header.getNext().getData();
    }


    /**
     * adds to end of list
     * 
     * @param data
     *            to add to the end
     * @return index of the element
     */
    public int add(T data) {
        Node<T> newNode = new Node<T>(data);
        tail.getPrev().insertAfter(newNode);
        return size++;
    }


    /**
     * removes element at index
     * 
     * @param index
     *            where to remove
     * @return if element at index is removed
     * @throws IndexOutOfBoundsException
     */
    public boolean remove(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> header = head;
        for (int i = 0; i <= index && header != tail; i++) {
            if (i == index) {
                header.remove().getData();
                size--;
                return true;
            }
            header = header.getNext();
        }
        return false;
    }


    /**
     * removes specified object
     * 
     * @param object
     *            target to be removed
     * @return if object was removed
     */
    public boolean remove(T object) {
        Node<T> header = head;
        while (header.getNext() != tail) {
            if (header.getNext().getData() == object) {
                header.setNext(header.getNext().getNext());
                size--;
                return true;
            }
            header = header.getNext();
        }
        return false;
    }


    /**
     * if element is empty
     * 
     * @return if size is 0
     */
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * sorts list
     * 
     * @param comparor
     *            to compare objects by
     */
    public void sort(Comparator<T> comparor) {
        int originalSize = size;
        Node<T> newHead = findNextNode(comparor);
        Node<T> header = newHead;
        while (!isEmpty()) {
            findNextNode(comparor).insertAfter(header);
            header = header.next;
        }
        head.linkWith(newHead);
        header.linkWith(tail);
        size = originalSize;
    }


    /**
     * Helper method for the sort
     */
    private Node<T> findNextNode(Comparator<T> comparor) {
        Node<T> result = head.next;
        for (Node<T> header = result; header != tail; header = header.next) {
            if (comparor.compare(header.data, result.data) < 0) {
                result = header;
            }
        }
        return result.remove();
    }


    /**
     * clones list
     * 
     * @return copy of the current list
     */
    public LinkedList<T> clone() {
        LinkedList<T> clone = new LinkedList<T>();
        Node<T> header = head;

        while (header.hasNext()) {
            header = header.getNext();
            clone.add(header.getData());
        }

        return clone;
    }
}
