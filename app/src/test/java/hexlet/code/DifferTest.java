package hexlet.code;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DifferTest {

    @DisplayName("Вывод сравнения JSON файлов")
    @Test
    void testFileDiffJson() throws Exception {
        String p1 = "src/test/resources/fixtures/file1.json";
        String p2 = "src/test/resources/fixtures/file2.json";

        String actual = Differ.generate(p1, p2);
        String expected = Differ.readFile(
                "src/test/resources/fixtures/stylish-result.txt");

        assertEquals(expected, actual);
    }

    @DisplayName("Вывод сравнения YML файлов")
    @Test
    void testFileDiffYml() throws Exception {
        String p1 = "src/test/resources/fixtures/file1.yml";
        String p2 = "src/test/resources/fixtures/file2.yml";

        String actual = Differ.generate(p1, p2);
        String expected = Differ.readFile(
                "src/test/resources/fixtures/stylish-result.txt");

        assertEquals(expected, actual);
    }

    @DisplayName("Вывод сравнения файлов в формате Stylish")
    @Test
    void testFileDiffJsonWithStylish() throws Exception {
        String p1 = "src/test/resources/fixtures/file1.json";
        String p2 = "src/test/resources/fixtures/file2.json";

        String actual = Differ.generate(p1, p2, "stylish");
        String expected = Differ.readFile(
                "src/test/resources/fixtures/stylish-result.txt");

        assertEquals(expected, actual);
    }

    @DisplayName("Вывод сравнения файлов в формате Plain")
    @Test
    void testFileDiffJsonWithPlain() throws Exception {
        String p1 = "src/test/resources/fixtures/file1.json";
        String p2 = "src/test/resources/fixtures/file2.json";

        String actual = Differ.generate(p1, p2, "plain");
        String expected = Differ.readFile(
                "src/test/resources/fixtures/plain-result.txt");

        assertEquals(expected, actual);
    }

    @DisplayName("Вывод сравнения файлов в формате Json")
    @Test
    void testFileDiffJsonWithJson() throws Exception {
        String p1 = "src/test/resources/fixtures/file1.yml";
        String p2 = "src/test/resources/fixtures/file2.yml";

        String actual = Differ.generate(p1, p2, "json");
        String expected = Differ.readFile(
                "src/test/resources/fixtures/json-result.txt");

        assertEquals(expected, actual);
    }
}
