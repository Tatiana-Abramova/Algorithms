package algo;

import org.junit.jupiter.params.provider.Arguments;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static algo.Actions.*;

public class BaseTest {
    /** Tests files location */
    protected static final String ROOT_DATA_PATH = "./tasks";

    /** Number of runs for comparative tests */
    private int runNumber = 1;

    protected void setRunNumber(int runNum) {
        this.runNumber = runNum;
    }

    /**
     * Creates and returns a stream of arguments for unit tests.
     * @param fileNames a map of input and output file names.
     * @return a stream of testName arguments
     */
    protected static Stream<Arguments> getArguments(Map<String, String> fileNames) throws Exception {
        List<Arguments> args = new ArrayList<>();

        for (Map.Entry<String, String> entry : fileNames.entrySet()) {
            String[] arrayIn = getFileContent(entry.getKey()).split("\\n|\\r\\n");
            String[] arrayOut = getFileContent(entry.getValue()).split("\\n|\\r\\n");
            Object[] array = new Object[arrayIn.length + arrayOut.length];
            System.arraycopy(arrayIn, 0, array, 0, arrayIn.length);
            System.arraycopy(arrayOut, 0, array, arrayIn.length, arrayOut.length);
            args.add(Arguments.of(array));
        }
        Arguments[] argsArr = new Arguments[args.size()];
        return Stream.of(args.toArray(argsArr));
    }

    /**
     * Creates and returns a sorted map of input and output file names.
     * @param path a path to a directory with files.
     * @return a a sorted map of input and output file names.
     */
    protected static Map<String, String> getFilesList(String path) throws Exception {
        try (Stream<Path> paths = Files.walk(Paths.get(path))) {

            return paths.map(Path::toString)
                    .filter(f -> f.endsWith(".in"))
                    .collect(Collectors.toMap(f -> f, f -> f.replace(".in", ".out"), (f1, f2) -> f1, TreeMap::new));

        } catch (IOException e) {
            throw new Exception("Cannot get a list of files from '" + path + "' directory: " +
                    e.getLocalizedMessage(), e);
        }
    }

    /**
     * Reads and returns a content of a given file.
     * @param filename a path to a files.
     * @return file content.
     */
    protected static String getFileContent(String filename) throws Exception {
        if (filename == null) {
            throw new Exception("Null filename");
        }
        try {
            return new String(Files.readAllBytes(Paths.get(filename))).trim();
        } catch (IOException e) {
            throw new Exception("Cannot read file '" + filename + "' content: " +
                    e.getLocalizedMessage(), e);
        }
    }

    /**
     * Reads and returns a content of a given file.
     * @param content content to write.
     * @return file content.
     */
    protected static void writeFileContent(String content, String filename) throws Exception {
        if (content == null) {
            throw new Exception("Null content");
        }
        try {
            Files.write(Paths.get(filename), content.getBytes());
        } catch (IOException e) {
            throw new Exception("Cannot write file '" + filename + "' content: " +
                    e.getLocalizedMessage(), e);
        }
    }

    /**
     * Runs a function and calculates its execution time.
     * @param fn a function.
     * @return average execution time in ns.
     */
    protected String execute(Action fn) {
        long startTime = System.nanoTime();

        for (int i = 0; i < runNumber; i++) {
            fn.action();
        }

        long stopTime = System.nanoTime();
        return String.valueOf((stopTime - startTime) / runNumber);
    }

    /**
     * Takes a list of calcMoves argument as input data.
     * Calls {@link #getActions(Arguments)} getActions} and {@link #execute(Action)} and build a table with execution times of different methods:
     * Test case    Method_1    Method_#
     * Case_1       123         001
     * Case_#       345         002
     * @param args a list of calcMoves data to run methods under calcMoves with.
     * @return comparative table.
     */
    protected Object[][] getComparativeTable(List<Arguments> args) {
        final Object[][] table = new String[args.size() + 1][];

        for (int i = 0; i < args.size(); i++) {
            System.out.println("Measuring execution time...");
            ActionDetail[] actions = getActions(args.get(i)).getActions();

            if (i == 0) {
                Object[] names = Arrays.stream(actions).map(ActionDetail::getActionName).toArray();
                table[0] = new String[names.length + 1];
                table[0][0] = "Test case";
                System.arraycopy(names, 0, table[0], 1, names.length);
            }

            table[i + 1] = new String[actions.length + 1];
            table[i + 1][0] = getActions(args.get(i)).getTestName();

            for (int j = 0; j < actions.length; j++) {
                table[i + 1][j + 1] = execute(actions[j].getAction());
            }
        }
        System.out.println("Comparative table has been created.");
        return table;
    }

    /**
     * Prints table to console.
     * @param table a table to be printed.
     */
    protected void printTable(Object[][] table) {
        System.out.println("Comparative table in ns:");
        int n = table[0].length;
        String pattern = "";
        for (int i = 0; i < n; i++) {
            pattern += "%-30s";
        }
        for (final Object[] row : table) {
            System.out.format(pattern + "\n", row);
        }
    }

    /**
     * Returns an array of actions (lambdas with methods) that we are going to measure.
     * Should be implemented in a calcMoves class.
     * @param arg calcMoves data that should be passed as parameters to methods under calcMoves.
     * @return an array of actions.
     */
    protected Actions getActions(Arguments arg) {
        return null;
    }
}
