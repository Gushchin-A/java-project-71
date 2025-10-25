package hexlet.code;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DifferTest {

    @DisplayName("Сравнение плоских JSON файлов")
    @Test
    void testFlatFileDiff() throws Exception {
        String p1 = "src/test/resources/fixtures/file1.json";
        String p2 = "src/test/resources/fixtures/file2.json";

        String actual = Differ.generate(p1, p2);

        String expected =
                "{\n"
                        + "  - follow: false\n"
                        + "    host: hexlet.io\n"
                        + "  - proxy: 123.234.53.22\n"
                        + "  - timeout: 50\n"
                        + "  + timeout: 20\n"
                        + "  + verbose: true\n"
                        + "}";

        assertEquals(expected, actual);
    }
}
