package algo.task_04.dynamic_arrays;

public interface Array<T> {

    int size();

    void add(T item);

    void add(T item, int index);

    T get(int index);

    T remove(int index);

    default void checkRange(int index) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Index: " + index +  ", Size: " + size());
        }
    }
}

