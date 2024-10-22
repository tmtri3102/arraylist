import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    // Default constructor
    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    // Constructor with capacity
    public MyList(int capacity) {
        elements = new Object[capacity];
    }

    // Add element at a specific index
    public void add(int index, E element) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + size);
        }
        ensureCapacity(size + 1);
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    // Remove element at a specific index
    public E remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + size);
        }
        E removedElement = (E) elements[index];
        int numElementsMoved = size - index - 1;
        if (numElementsMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numElementsMoved);
        }
        elements[--size] = null; // clear to let GC do its work
        return removedElement;
    }

    // Get the size of the list
    public int size() {
        return size;
    }

    // Clone the list
    public E clone() {
        try {
            MyList<E> clone = (MyList<E>) super.clone();
            clone.elements = Arrays.copyOf(elements, size);
            return (E) clone;
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e);
        }
    }

    // Check if the list contains a specific element
    public boolean contains(E o) {
        return indexOf(o) >= 0;
    }

    // Get index of a specific element
    public int indexOf(E o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(elements[i])) {
                return i;
            }
        }
        return -1;
    }

    // Add element to the list
    public boolean add(E e) {
        ensureCapacity(size + 1);
        elements[size++] = e;
        return true;
    }

    // Ensure capacity of the list
    public void ensureCapacity(int minCapacity) {
        if (minCapacity > elements.length) {
            int newCapacity = elements.length * 2;
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    // Get element at a specific index
    public E get(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + size);
        }
        return (E) elements[i];
    }

    // Clear the list
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }
}
