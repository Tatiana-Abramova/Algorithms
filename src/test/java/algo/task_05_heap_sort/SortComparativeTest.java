package algo.task_05_heap_sort;

import algo.Actions;
import org.junit.Test;
import org.junit.jupiter.params.provider.Arguments;

import java.util.List;
import java.util.stream.Collectors;

public class SortComparativeTest extends SortTest {

    @Test
    public void comparativeTest() throws Exception {
        List<Arguments> args = getAllArgsRandom().collect(Collectors.toList());
        args.addAll(getAllArgsDigits().collect(Collectors.toList()));
        args.addAll(getAllArgsSorted().collect(Collectors.toList()));
        args.addAll(getAllArgsRevers().collect(Collectors.toList()));
        Object[][] table = getComparativeTable(args);
        printTable(table);
    }

    @Override
    public Actions getActions(Arguments arg) {
        int[] arraySelection = toArray(String.valueOf(arg.get()[1]));
        int[] arrayInsertion = toArray(String.valueOf(arg.get()[1]));
        int[] arrayShell = toArray(String.valueOf(arg.get()[1]));
        int[] arrayShellH = toArray(String.valueOf(arg.get()[1]));
        int[] arrayShellP = toArray(String.valueOf(arg.get()[1]));
        int[] arrayHeap = toArray(String.valueOf(arg.get()[1]));
        return new Actions(
                "Random array sort ",
                new Actions.ActionDetail("Selection sort", () -> SelectionSort.sort(arraySelection)),
                new Actions.ActionDetail("Insertion sort", () -> InsertionSort.sort(arrayInsertion)),
                new Actions.ActionDetail("Shell (Shell)", () -> ShellSort.sortShell(arrayShell)),
                new Actions.ActionDetail("Shell (Hibbard)", () -> ShellSort.sortHibbard(arrayShellH)),
                new Actions.ActionDetail("Shell (Papernov)", () -> ShellSort.sortPapernov(arrayShellP)),
                new Actions.ActionDetail("Heap sort", () -> HeapSort.sort(arrayHeap)));
    }
}
