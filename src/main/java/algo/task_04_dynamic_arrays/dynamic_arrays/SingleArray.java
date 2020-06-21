package algo.task_04_dynamic_arrays.dynamic_arrays;

/**
 * A simple implementation of dynamic array.
 * It creates a new array each time, when a new element is added or removed.
 * @param <T> a type of an element.
 */
public class SingleArray<T> implements Array<T> {

    /** An inner array to store elements. */
    private Object[] array;

    public SingleArray() {
        array = new Object[0];
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public void add(T item) {
        resize();
        array[size() - 1] = item;
    }

    @Override
    public void add(T item, int index) {
        checkRange(index);
        resize(index);
        array[index] = item;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T) array[index];
    }

    @Override
    @SuppressWarnings("unchecked")
    public T remove(int index) {
        checkRange(index);
        Object element = array[index];
        resizeRemove(index);
        return (T) element;
    }

    private void resize() {
        Object[] newArray = new Object[size() + 1];
        System.arraycopy(array, 0, newArray, 0, size());
        array = newArray;
    }

    private void resize(int index) {
        Object[] newArray = new Object[size() + 1];
        System.arraycopy(array, 0, newArray, 0, index);
        System.arraycopy(array, index, newArray, index + 1, size() - index);
        array = newArray;
    }

    private void resizeRemove(int index) {
        Object[] newArray = new Object[size() - 1];
        System.arraycopy(array, 0, newArray, 0, index);
        System.arraycopy(array, index + 1, newArray, index, size() - index - 1);
        array = newArray;
    }


}
