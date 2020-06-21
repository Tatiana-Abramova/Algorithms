package algo.task_04_dynamic_arrays.dynamic_arrays;

/**
 * An implementation of dynamic array - an array of arrays.
 * When a new element is added, it checks if the current inner sub-array has sufficient length.
 * If it does not, then a new array is added to the main array.
 * Sub-arrays have type of VectorArray.
 * @param <T> a type of an element.
 */
public class MatrixArray<T> implements Array<T> {

    /** The size of the array. */
    private int size;

    /** The length of the sub-arrays. */
    private int vector;

    /** The main array. */
    private Array<Array<T>> mainArray;

    public MatrixArray(int vector) {
        this.vector = vector;
        mainArray = new VectorArray<>();
        size = 0;
    }

    public MatrixArray() {
        this(10);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T item) {
        resize();
        mainArray.get(size / vector).add(item);
        size++;
    }

    @Override
    public void add(T item, int index) {
        checkRange(index);
        resize();
        int arrayNo = index / vector;
        int lastArrayIndex = mainArray.size() - 1;

        T lastItem = null;
        for (int i = arrayNo; i < lastArrayIndex; i++) {
            if (i == arrayNo) {
                lastItem = mainArray.get(i).remove(vector - 1);
                mainArray.get(i).add(item, index % vector);
            }
            T lastItemCurr = null;
            if ((i + 1) < lastArrayIndex) {
                lastItemCurr = mainArray.get(i + 1).remove(vector - 1);
            }

            mainArray.get(i + 1).add(lastItem, 0);
            lastItem = lastItemCurr;
        }
        if (arrayNo == lastArrayIndex) {
            mainArray.get(arrayNo).add(item, index % vector);
        }
        size++;
    }

    @Override
    public T get(int index) {
        return mainArray.get(index / vector).get(index % vector);
    }

    @Override
    public T remove(int index) {
        checkRange(index);
        int arrayNo = index / vector;
        int lastArrayIndex = mainArray.size() - 1;
        T removedElement = mainArray.get(arrayNo).remove(index % vector);

        for (int i = arrayNo; i < lastArrayIndex; i++) {
            T element = mainArray.get(i + 1).remove(0);
            mainArray.get(i).add(element);
        }
        if (mainArray.get(lastArrayIndex).size() == 0) {
            mainArray.remove(lastArrayIndex);
        }

        size--;
        return removedElement;
    }

    private void resize() {
        if (size == mainArray.size() * vector) {
            mainArray.add(new VectorArray<>(vector));
        }
    }
}
