package algo.task_04;

import algo.task_04.dynamic_arrays.SingleArray;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SingleArrayTest extends ArrayTest {

    @Before
    public void init() {
        array = new SingleArray<>();
    }

    @Test
    public void addTest() {
        array.add(element);
        Assert.assertEquals(element, array.get(0));
    }

    @Test
    public void addIndexTest() {
        array.add(element, 0);
        array.add(element + 1);
        array.add(element + 2, 1);
        Assert.assertEquals(element + 2, array.get(1));
        Assert.assertEquals(element + 1, array.get(2));
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
