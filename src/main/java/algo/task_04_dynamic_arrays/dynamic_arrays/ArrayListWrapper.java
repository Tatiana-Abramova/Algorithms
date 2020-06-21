package algo.task_04_dynamic_arrays.dynamic_arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * A wrapper for the standard Java ArrayList.
 * It is used for the comparative performance testing of the different implementations of dynamic arrays.
 * @param <T> a type of an element.
 */
public class ArrayListWrapper<T> implements Array<T> {

    private List<T> arrayList;

    public ArrayListWrapper(int vector) {
        arrayList = new ArrayList<>(vector);
    }

    public ArrayListWrapper() {
        this(10);
    }

    @Override
    public int size() {
        return arrayList.size();
    }

    public void add(T item) {
        arrayList.add(item);
    }

    @Override
    public void add(T item, int index) {
        arrayList.add(index, item);
    }

    @Override
    public T get(int index) {
        return arrayList.get(index);
    }

    @Override
    public T remove(int index) {
        return arrayList.remove(index);
    }
}
