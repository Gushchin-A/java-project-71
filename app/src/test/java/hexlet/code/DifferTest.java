package hexlet.code;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DifferTest {
    /** Путь к файлу №1 json. */
    private static final String JSON_FILE_1 =
            "src/test/resources/fixtures/file1.json";
    /** Путь к файлу №2 json. */
    private static final String JSON_FILE_2 =
            "src/test/resources/fixtures/file2.json";
    /** Путь к файлу №1 yml. */
    private static final String YML_FILE_1 =
            "src/test/resources/fixtures/file1.yml";
    /** Путь к файлу №2 yml. */
    private static final String YML_FILE_2 =
            "src/test/resources/fixtures/file2.yml";

    /** Путь к результату в формате "Stylish". */
    private static final String STYLISH_RESULT =
            "src/test/resources/fixtures/stylish-result.txt";
    /** Путь к результату в формате "Plain". */
    private static final String PLAIN_RESULT =
            "src/test/resources/fixtures/plain-result.txt";
    /** Путь к результату в формате "Json". */
    private static final String JSON_RESULT =
            "src/test/resources/fixtures/json-result.txt";



    @DisplayName("Вывод сравнения JSON файлов без выбора формата")
    @Test
    void testFileDiffJson() throws Exception {
        String actual = Differ.generate(JSON_FILE_1, JSON_FILE_2);
        String expected = Differ.readFile(STYLISH_RESULT);

        assertEquals(expected, actual);
    }

    @DisplayName("Вывод сравнения YML файлов без выбора формата")
    @Test
    void testFileDiffYml() throws Exception {
        String actual = Differ.generate(YML_FILE_1, YML_FILE_2);
        String expected = Differ.readFile(STYLISH_RESULT);

        assertEquals(expected, actual);
    }

    @DisplayName("Вывод сравнения JSON файлов в формате \"stylish\"")
    @Test
    void testFileDiffJsonWithStylish() throws Exception {
        String actual = Differ.generate(JSON_FILE_1, JSON_FILE_2, "stylish");
        String expected = Differ.readFile(STYLISH_RESULT);

        assertEquals(expected, actual);
    }

    @DisplayName("Вывод сравнения JSON файлов в формате \"plain\"")
    @Test
    void testFileDiffJsonWithPlain() throws Exception {
        String actual = Differ.generate(JSON_FILE_1, JSON_FILE_2, "plain");
        String expected = Differ.readFile(PLAIN_RESULT);

        assertEquals(expected, actual);
    }

    @DisplayName("Вывод сравнения JSON файлов в формате \"json\"")
    @Test
    void testFileDiffJsonWithJson() throws Exception {
        String actual = Differ.generate(JSON_FILE_1, JSON_FILE_2, "json");
        String expected = Differ.readFile(JSON_RESULT);

        assertEquals(expected, actual);
    }

    @DisplayName("Вывод сравнения YML файлов в формате \"stylish\"")
    @Test
    void testFileDiffYmlWithStylish() throws Exception {
        String actual = Differ.generate(YML_FILE_1, YML_FILE_2, "stylish");
        String expected = Differ.readFile(STYLISH_RESULT);

        assertEquals(expected, actual);
    }

    @DisplayName("Вывод сравнения YML файлов в формате \"plain\"")
    @Test
    void testFileDiffYmlWithPlain() throws Exception {
        String actual = Differ.generate(YML_FILE_1, YML_FILE_2, "plain");
        String expected = Differ.readFile(PLAIN_RESULT);

        assertEquals(expected, actual);
    }

    @DisplayName("Вывод сравнения YML файлов в формате \"json\"")
    @Test
    void testFileDiffYmlWithJson() throws Exception {
        String actual = Differ.generate(YML_FILE_1, YML_FILE_2, "json");
        String expected = Differ.readFile(JSON_RESULT);

        assertEquals(expected, actual);
    }
}
