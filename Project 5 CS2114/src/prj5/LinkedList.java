/**
 * 
 */
package prj5;

import java.util.Comparator;

/**
 * @author Tom
 *         LinkedList for the back-end of the program.
 *         Contains a private node class used as a basis for the linked list.
 * 
 * @param T
 *            is a generic type
 */
public class LinkedList<T> {

    /**
     * Support class for the LinkedList class
     * 
     * @author Tom (thimler9)
     *
     * @param <T>
     *            is the same parameter as LinkedList<T>
     */
    @SuppressWarnings("hiding")
    private class Node<T> {
        private T data;
        private Node<T> next;

        /**
         * constructor of node
         * @param data data inside node
         * @param next next node of created one
         */
        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        /**
         * gets next node
         * @return next node
         */
        public Node<T> getNext() {
            return next;
        }

        /**
         * gets data of current node
         * @return data
         */
        public T getData() {
            return data;
        }

        /**
         * sets next node of current
         * @param next next node to set
         */
        public void setNext(Node<T> next) {
            this.next = next;
        }

        /**
         * toString method
         * @return list in an array like form
         */
        @Override
        public String toString() {
            return data.toString();
        }
    }

    private Node<T> headNode; // The head node of list
    private int size; // The number of elements in the list


    /**
     * Constructor for LinkedList
     * Creates a sentinel node headnode and sets the size to 0
     */
    public LinkedList() {
        headNode = new Node<T>(null, null);
        size = 0;
    }


    /**
     * Gets the element at the index inputed
     * 
     * @param index
     *            the index of the wanted item
     * @return the item at that index
     */
    public T get(int index) {
        Node<T> header = headNode;

        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        for (int i = 0; i < index; i++) {
            header = header.getNext();
        }

        return header.getNext().getData();
    }


    /**
     * Returns the size of the linkedList
     * 
     * @return the size of the linkedList
     */
    public int getSize() {
        return size;
    }


    /**
     * Adds a new piece of data at the end of the list
     * 
     * @param data
     *            the data being added
     */
    public void add(T data) {
        Node<T> newNode = new Node<T>(data, null);
        Node<T> currentNode = headNode;
        if (size == 0) {
            headNode.setNext(newNode);
        }
        for (int i = 0; i < size + 1; i++) {
            if (currentNode.getNext() == null) {
                currentNode.setNext(newNode);
            }
            currentNode = currentNode.getNext();
        }
        size++;
    }


    /**
     * Removes a given at the given index
     * 
     * @param index
     *            of element being removed
     * @return true if the element was removed false if it is not in the list
     */
    public T remove(int index) {
        Node<T> header = headNode;
        T item = null;

        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        for (int i = 0; i <= index; i++) {
            if (i == index) {
                item = header.getNext().getData();
                header.setNext(header.getNext().getNext());
                size--;
            }
            header = header.getNext();
        }

        return item;
    }


    /**
     * Removes the first instance of a given object
     * 
     * @param object
     *            that is being removed
     * @return true if the element was removed false if it is not in the list
     */
    public boolean remove(T object) {
        Node<T> header = headNode;
        while (header.getNext() != null) {
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
     * Checks to see if the list is empty
     * 
     * @return true if empty, false if not empty
     */
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * Sorts the list depending on the object
     * Uses that objects comparator to sort
     * 
     * @param comp
     *            Comparator for sorting
     */
    public void sort(Comparator<T> comp) {
        int original = size;
        T obj = getNextObj(comp);
        Node<T> temp = new Node<T>(obj, null);
        Node<T> pointer = temp;
        while (size != 0) {
            Node<T> anotherOne = new Node<T>(getNextObj(comp), null);
            pointer.setNext(anotherOne);
            pointer = anotherOne;
        }
        size = original;
        headNode.setNext(temp);
    }


    /**
     * helper method
     * 
     * @param comp
     *            Comparator for sorting
     */
    private T getNextObj(Comparator<T> comp) {
        Node<T> pointer = headNode.getNext();
        Node<T> beforeResult = headNode;
        while (pointer.getNext() != null) {
            T c1 = pointer.getNext().getData();
            if (comp.compare(c1, beforeResult.getNext().getData()) < 0) {
                beforeResult = pointer;
            }
            pointer = pointer.getNext();
        }
        Node<T> result = beforeResult.getNext();
        beforeResult.setNext(result.getNext());
        size--;
        return result.getData();
    }


    /**
     * Creates an identical list of the same elements
     */
    public LinkedList<T> clone() {
        LinkedList<T> clone = new LinkedList<T>();
        Node<T> header = headNode;

        while (header.next != null) {
            clone.add(header.getNext().getData());
            header = header.getNext();
        }

        return clone;
    }

    /**
     * toString method
     * @return list in an array like form
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node<T> pointer = headNode.getNext();
        while (pointer != null) {
            result.append(pointer.toString());
            if(pointer.getNext() != null){
                result.append(", ");
            }
            pointer = pointer.getNext();
        }
        result.append("]");
        return result.toString();
    }
}
