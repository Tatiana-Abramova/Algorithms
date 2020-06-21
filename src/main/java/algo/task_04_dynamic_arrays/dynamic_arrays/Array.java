package algo.task_04_dynamic_arrays.dynamic_arrays;

/**
 * An interface for dynamic arrays.
 * @param <T> a type of an element.
 */
public interface Array<T> {

    /**
     * Returns a size of a dynamic array.
     * @return a size of a dynamic array.
     */
    int size();

    /**
     * Adds a new element to the end of the array.
     * @param item a new element.
     */
    void add(T item);

    /**
     * Adds a new element to a specific position.
     * @param item a new element.
     * @param index a position for the new element.
     */
    void add(T item, int index);

    /**
     * Returns an element from a specific position.
     * @param index a position for the element to be returned.
     * @return an element from a specific position.
     */
    T get(int index);

    /**
     * Removes an element from a specific position.
     * @param index a position for the element to be removed.
     * @return a deleted element.
     */
    T remove(int index);

    /**
     * Checks if the given index is out of range of the array.
     * Throws IndexOutOfBoundsException if the index is out of range of the array.
     * @param index an index of an element.
     */
    default void checkRange(int index) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Index: " + index +  ", Size: " + size());
        }
    }
}

