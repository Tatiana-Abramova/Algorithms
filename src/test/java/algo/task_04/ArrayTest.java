package algo.task_04;

import algo.task_04.dynamic_arrays.Array;
import org.junit.Assert;

public abstract class ArrayTest {
    static String element = "Test";
    Array<String> array;

    public void addIndexOutOfBoundTest() {
        array.add(element, 0);
        array.add(element + 1,1);
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> array.add(element + 2,3));
    }

    public void removeIndexOutOfBoundTest() {
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> array.remove(3));
    }

    public void removeTest() {
        array.add(element, 0);
        array.add(element + 1);
        String actual = array.remove(0);
        Assert.assertEquals(element, actual);
    }

    public void sizeTest() {
        Assert.assertEquals(0, array.size());
        array.add(element, 0);
        Assert.assertEquals(1, array.size());
    }
}
