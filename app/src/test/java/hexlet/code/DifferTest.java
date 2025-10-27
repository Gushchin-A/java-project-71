package hexlet.code;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DifferTest {

    @DisplayName("Сравнение плоских JSON файлов")
    @Test
    void testFlatFileDiffJson() throws Exception {
        String p1 = "src/test/resources/fixtures/file1.json";
        String p2 = "src/test/resources/fixtures/file2.json";

        String actual = Differ.generate(p1, p2);

        String expected = "{"
                        + System.lineSeparator()
                        + "  - follow: false"
                        + System.lineSeparator()
                        + "    host: hexlet.io"
                        + System.lineSeparator()
                        + "  - proxy: 123.234.53.22"
                        + System.lineSeparator()
                        + "  - timeout: 50"
                        + System.lineSeparator()
                        + "  + timeout: 20"
                        + System.lineSeparator()
                        + "  + verbose: true"
                        + System.lineSeparator()
                        + "}";

        assertEquals(expected, actual);
    }

    @DisplayName("Сравнение плоских YML файлов")
    @Test
    void testFlatFileDiffYml() throws Exception {
        String p1 = "src/test/resources/fixtures/file1.yml";
        String p2 = "src/test/resources/fixtures/file2.yml";

        String actual = Differ.generate(p1, p2);

        String expected = "{"
                + System.lineSeparator()
                + "  - follow: false"
                + System.lineSeparator()
                + "    host: hexlet.io"
                + System.lineSeparator()
                + "  - proxy: 123.234.53.22"
                + System.lineSeparator()
                + "  - timeout: 50"
                + System.lineSeparator()
                + "  + timeout: 20"
                + System.lineSeparator()
                + "  + verbose: true"
                + System.lineSeparator()
                + "}";

        assertEquals(expected, actual);
    }
}
