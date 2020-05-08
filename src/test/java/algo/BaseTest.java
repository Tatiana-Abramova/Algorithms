package algo;

import org.junit.jupiter.params.provider.Arguments;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BaseTest {
    protected static final String ROOT_DATA_PATH = "./tasks";

    /**
     * Creates and returns a stream of arguments for unit tests.
     * @param fileNames a map of input and output file names.
     */
    protected static Stream<Arguments> getArguments(Map<String, String> fileNames) throws Exception {
        List<Arguments> args = new ArrayList<>();

        for (Map.Entry<String, String> entry : fileNames.entrySet()) {
            args.add(Arguments.of(
                    getFileContent(entry.getKey()),
                    getFileContent(entry.getValue())
            ));
        }
        Arguments[] argsArr = new Arguments[args.size()];
        return Stream.of(args.toArray(argsArr));
    }

    /**
     * Creates and returns a sorted map of input and output file names.
     * @param path a path to a directory with files.
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
     */
    protected static String getFileContent(String filename) throws Exception {
        if (filename == null) {
            return null;
        }
        try {
            return new String(Files.readAllBytes(Paths.get(filename))).trim();
        } catch (IOException e) {
            throw new Exception("Cannot read file '" + filename + "' content: " +
                    e.getLocalizedMessage(), e);
        }
    }
}
