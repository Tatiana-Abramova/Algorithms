package algo.task_04_dynamic_arrays.dynamic_arrays;

/**
 * An implementation of dynamic array.
 * When a new element is added, it checks if the current inner array has sufficient length.
 * If it does not, then a new array is created with length equal length of the current array multiplied to the factor parameter.
 * @param <T> a type of an element.
 */
public class FactorArray<T> implements Array<T> {

    /** An inner array to store elements. */
    private Object[] array;

    /** A number by which the length of the array is increased. */
    private int factor;

    /** The size of the array. */
    private int size;

    public FactorArray(int factor, int initLength) {
        this.factor = factor;
        array = new Object[initLength];
        size = 0;
    }

    public FactorArray() {
        this(50, 10);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T item) {
        resize();
        array[size] = item;
        size++;
    }

    @Override
    public void add(T item, int index) {
        checkRange(index);
        resize();
        shift(index);
        array[index] = item;
        size++;
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
        if (size > index + 1) {
            System.arraycopy(array, index + 1, array, index, size() - index - 1);
        }
        array[--size] = null;
        return (T) element;
    }

    private void resize() {
        if (size() == array.length) {
            Object[] newArray = new Object[array.length + array.length * factor / 100];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
    }

    private void shift(int index) {
        System.arraycopy(array, index, array, index + 1, array.length - index - 1);
    }
}
