package algo.task_04_dynamic_arrays;

import algo.Actions;

import algo.task_04_dynamic_arrays.dynamic_arrays.*;
import org.junit.Test;
import org.junit.jupiter.params.provider.Arguments;

import java.util.List;
import java.util.stream.Collectors;

public class ArraysAddComparativeTest extends ArraysComparativeTest {

    @Test
    public void comparativeTest() throws Exception {
        List<Arguments> args = getAllArgs().collect(Collectors.toList());
        Object[][] table = getComparativeTable(args);
        printTable(table);
    }

    @Override
    public Actions getActions(Arguments arg) {
        Array<Integer> vectorArray = new VectorArray<>(10000);
        Array<Integer> factorArray1 = new FactorArray<>(50, 1000);
        Array<Integer> factorArray2 = new FactorArray<>(100, 1000);
        Array<Integer> matrixArray1 = new MatrixArray<>(1000);
        Array<Integer> matrixArray2 = new MatrixArray<>(10000);
        Array<Integer> wrapperArray1 = new ArrayListWrapper<>(1000);
        Array<Integer> wrapperArray2 = new ArrayListWrapper<>(10000);

        int n = Integer.parseInt(String.valueOf(arg.get()[0]));
        setRunNumber(5);

        return new Actions(
                "Dynamic Arrays add() " + n,
                new Actions.ActionDetail("Vector 10000", () -> fillArray(vectorArray, n)),
                new Actions.ActionDetail("Factor 50", () -> fillArray(factorArray1, n)),
                new Actions.ActionDetail("Factor 100", () -> fillArray(factorArray2, n)),
                new Actions.ActionDetail("Matrix 1000", () -> fillArray(matrixArray1, n)),
                new Actions.ActionDetail("Matrix 10000", () -> fillArray(matrixArray2, n)),
                new Actions.ActionDetail("ArrayList Wrapper 1000", () -> fillArray(wrapperArray1, n)),
                new Actions.ActionDetail("ArrayList Wrapper 10000", () -> fillArray(wrapperArray2, n)));
    }
}
