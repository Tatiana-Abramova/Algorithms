package algo.task_04.dynamic_arrays;

public class FactorArray<T> implements Array<T> {

    private Object[] array;
    private int factor;
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
