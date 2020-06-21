package algo.task_04;

import algo.task_04.dynamic_arrays.MatrixArray;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MatrixArrayTest extends ArrayTest {

    @Before
    public void init() {
        array = new MatrixArray<>(2);
    }

    @Test
    public void addTest() {
        for (int i = 0; i < 5; i++) {
            array.add(element + i);
        }
        Assert.assertEquals(element + 0, array.get(0));
        Assert.assertEquals(element + 1, array.get(1));
        Assert.assertEquals(element + 2, array.get(2));
        Assert.assertEquals(element + 3, array.get(3));
        Assert.assertEquals(element + 4, array.get(4));
    }

    @Test
    public void addIndexTest() {
        for (int i = 0; i < 5; i++) {
            array.add(element + i, 0);
        }
        Assert.assertEquals(element + 0, array.get(4));
        Assert.assertEquals(element + 1, array.get(3));
        Assert.assertEquals(element + 2, array.get(2));
        Assert.assertEquals(element + 3, array.get(1));
        Assert.assertEquals(element + 4, array.get(0));

        array.add(element + 5, 4);
        Assert.assertEquals(element + 5, array.get(4));
        Assert.assertEquals(element + 0, array.get(5));
    }

    @Test
    public void addIndexOutOfBoundTest() {
        super.addIndexOutOfBoundTest();
    }

    @Test
    public void removeTest() {
        super.removeTest();
    }

    @Test
    public void removeIndexOutOfBoundTest() {
        super.removeIndexOutOfBoundTest();
    }

    @Test
    public void sizeTest() {
        super.sizeTest();
    }
}
