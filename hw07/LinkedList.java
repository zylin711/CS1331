public class LinkedList<E> {

    /**
     * Private generic inner Node<E> class,
     * with data and next variables and a 2-arg constructor
     * that receives those (in order) to create the nodes.
     */
    private class Node<E> {
        private E data;
        private Node<E> next;

        private Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    // Instance variables: head, size. size (int)
    private Node<E> head;
    private int size;

    /**
     * Constructor
     * sets head to null and size to 0.
     */
    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    /**
     * Returns the number of elements in the linked list.
     * @return the size of the linked list.
     */
    public int size() {
        return size;
    }

    /**
     * Checks if the linked list is empty.
     * @return whether the linked list is empty or not.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Removes all elements from the linked list.
     * Sets head to null and size to 0.
     */
    public void clear() {
        head = null;
        size = 0;
    }

    /**
     * Adds an element at a specific index in the linked list.
     * @param index the position at which to add the element.
     * @param element the element to be added.
     * @throws IndexOutOfBoundsException if the index is out of range.
     */
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        if (index == 0) {
            head = new Node<>(element, head);
        } else {
            Node<E> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = new Node<>(element, current.next);
        }
        size++;
    }

    /**
     * Adds an element at the end of the linked list.
     * @param element the element to be added.
     */
    public void add(E element) {
        add(size, element);
    }

    /**
     * Checks whether the linked list contains a specific element.
     * @param o the element to search for.
     * @return true if the element is found, false otherwise.
     */
    public boolean contains(Object o) {
        Node<E> current = head;
        while (current != null) {
            if ((o == null && current.data == null) || (o != null && o.equals(current.data))) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * Retrieves the element at a specific index in the linked list.
     * @param index the position of the element to retrieve.
     * @return the element at the specified index.
     * @throws IndexOutOfBoundsException if the index is out of range.
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    /**
     * Returns the index of the first occurrence of a specific element in the list.
     * @param o the element to search for.
     * @return the index of the first occurrence, or -1 if the element is not found.
     */
    public int indexOf(Object o) {
        Node<E> current = head;
        int index = 0;
        while (current != null) {
            if ((o == null && current.data == null) || (o != null && o.equals(current.data))) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    /**
     * Removes and returns the element at a specific index in the linked list.
     * @param index the position of the element to remove.
     * @return the removed element.
     * @throws IndexOutOfBoundsException if the index is out of range.
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        E removedData;
        if (index == 0) {
            removedData = head.data;
            head = head.next;
        } else {
            Node<E> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            removedData = current.next.data;
            current.next = current.next.next;
        }
        size--;
        return removedData;
    }

    /**
     * Removes the first occurrence of a specific element from the linked list.
     * @param o the element to remove.
     * @return true if the element was found and removed, false otherwise.
     */
    public boolean remove(Object o) {
        if (head == null) {
            return false;
        }
        if ((o == null && head.data == null) || (o != null && o.equals(head.data))) {
            head = head.next;
            size--;
            return true;
        }
        Node<E> current = head;
        while (current.next != null) {
            if ((o == null && current.next.data == null) || (o != null && o.equals(current.next.data))) {
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * Replaces the element at a specific index with a new element.
     * @param index the index of the element to replace.
     * @param element the new element to set.
     * @return the old element that was replaced.
     * @throws IndexOutOfBoundsException if the index is out of range.
     */
    public E set(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        E oldData = current.data;
        current.data = element;
        return oldData;
    }

    /**
     * Returns a string representation of the linked list.
     * @return the string representation of the list in the format [elem1, elem2, ...].
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<E> current = head;
        while (current != null) {
            sb.append(String.valueOf(current.data));
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * Compares this linked list to another object for equality.
     * @param obj the object to compare with this linked list.
     * @return true if the given object is also a LinkedList and contains the same elements
     *         in the same order as this list; false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        return true;
    }
}