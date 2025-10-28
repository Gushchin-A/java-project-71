package hexlet.code;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DifferTest {

    @DisplayName("Сравнение JSON файлов")
    @Test
    void testFileDiffJson() throws Exception {
        String p1 = "src/test/resources/fixtures/file1.json";
        String p2 = "src/test/resources/fixtures/file2.json";

        String actual = Differ.generate(p1, p2);

        String expected = "{"
                        + System.lineSeparator()
                        + "    chars1: [a, b, c]"
                        + System.lineSeparator()
                        + "  - chars2: [d, e, f]"
                        + System.lineSeparator()
                        + "  + chars2: false"
                        + System.lineSeparator()
                        + "  - checked: false"
                        + System.lineSeparator()
                        + "  + checked: true"
                        + System.lineSeparator()
                        + "  - default: null"
                        + System.lineSeparator()
                        + "  + default: [value1, value2]"
                        + System.lineSeparator()
                        + "  - id: 45"
                        + System.lineSeparator()
                        + "  + id: null"
                        + System.lineSeparator()
                        + "  - key1: value1"
                        + System.lineSeparator()
                        + "  + key2: value2"
                        + System.lineSeparator()
                        + "    numbers1: [1, 2, 3, 4]"
                        + System.lineSeparator()
                        + "  - numbers2: [2, 3, 4, 5]"
                        + System.lineSeparator()
                        + "  + numbers2: [22, 33, 44, 55]"
                        + System.lineSeparator()
                        + "  - numbers3: [3, 4, 5]"
                        + System.lineSeparator()
                        + "  + numbers4: [4, 5, 6]"
                        + System.lineSeparator()
                        + "  + obj1: {nestedKey=value, isNested=true}"
                        + System.lineSeparator()
                        + "  - setting1: Some value"
                        + System.lineSeparator()
                        + "  + setting1: Another value"
                        + System.lineSeparator()
                        + "  - setting2: 200"
                        + System.lineSeparator()
                        + "  + setting2: 300"
                        + System.lineSeparator()
                        + "  - setting3: true"
                        + System.lineSeparator()
                        + "  + setting3: none"
                        + System.lineSeparator()
                        + "}";

        assertEquals(expected, actual);
    }

    @DisplayName("Сравнение YML файлов")
    @Test
    void testFileDiffYml() throws Exception {
        String p1 = "src/test/resources/fixtures/file1.yml";
        String p2 = "src/test/resources/fixtures/file2.yml";

        String actual = Differ.generate(p1, p2);

        String expected = "{"
                        + System.lineSeparator()
                        + "    chars1: [a, b, c]"
                        + System.lineSeparator()
                        + "  - chars2: [d, e, f]"
                        + System.lineSeparator()
                        + "  + chars2: false"
                        + System.lineSeparator()
                        + "  - checked: false"
                        + System.lineSeparator()
                        + "  + checked: true"
                        + System.lineSeparator()
                        + "  - default: null"
                        + System.lineSeparator()
                        + "  + default: [value1, value2]"
                        + System.lineSeparator()
                        + "  - id: 45"
                        + System.lineSeparator()
                        + "  + id: null"
                        + System.lineSeparator()
                        + "  - key1: value1"
                        + System.lineSeparator()
                        + "  + key2: value2"
                        + System.lineSeparator()
                        + "    numbers1: [1, 2, 3, 4]"
                        + System.lineSeparator()
                        + "  - numbers2: [2, 3, 4, 5]"
                        + System.lineSeparator()
                        + "  + numbers2: [22, 33, 44, 55]"
                        + System.lineSeparator()
                        + "  - numbers3: [3, 4, 5]"
                        + System.lineSeparator()
                        + "  + numbers4: [4, 5, 6]"
                        + System.lineSeparator()
                        + "  + obj1: {nestedKey=value, isNested=true}"
                        + System.lineSeparator()
                        + "  - setting1: Some value"
                        + System.lineSeparator()
                        + "  + setting1: Another value"
                        + System.lineSeparator()
                        + "  - setting2: 200"
                        + System.lineSeparator()
                        + "  + setting2: 300"
                        + System.lineSeparator()
                        + "  - setting3: true"
                        + System.lineSeparator()
                        + "  + setting3: none"
                        + System.lineSeparator()
                        + "}";

        assertEquals(expected, actual);
    }

    @DisplayName("Сравнение JSON файлов c выставлением стиля")
    @Test
    void testFileDiffJsonWithStyle() throws Exception {
        String p1 = "src/test/resources/fixtures/file1.json";
        String p2 = "src/test/resources/fixtures/file2.json";

        String actual = Differ.generate(p1, p2, "stylish");

        String expected = "{"
                        + System.lineSeparator()
                        + "    chars1: [a, b, c]"
                        + System.lineSeparator()
                        + "  - chars2: [d, e, f]"
                        + System.lineSeparator()
                        + "  + chars2: false"
                        + System.lineSeparator()
                        + "  - checked: false"
                        + System.lineSeparator()
                        + "  + checked: true"
                        + System.lineSeparator()
                        + "  - default: null"
                        + System.lineSeparator()
                        + "  + default: [value1, value2]"
                        + System.lineSeparator()
                        + "  - id: 45"
                        + System.lineSeparator()
                        + "  + id: null"
                        + System.lineSeparator()
                        + "  - key1: value1"
                        + System.lineSeparator()
                        + "  + key2: value2"
                        + System.lineSeparator()
                        + "    numbers1: [1, 2, 3, 4]"
                        + System.lineSeparator()
                        + "  - numbers2: [2, 3, 4, 5]"
                        + System.lineSeparator()
                        + "  + numbers2: [22, 33, 44, 55]"
                        + System.lineSeparator()
                        + "  - numbers3: [3, 4, 5]"
                        + System.lineSeparator()
                        + "  + numbers4: [4, 5, 6]"
                        + System.lineSeparator()
                        + "  + obj1: {nestedKey=value, isNested=true}"
                        + System.lineSeparator()
                        + "  - setting1: Some value"
                        + System.lineSeparator()
                        + "  + setting1: Another value"
                        + System.lineSeparator()
                        + "  - setting2: 200"
                        + System.lineSeparator()
                        + "  + setting2: 300"
                        + System.lineSeparator()
                        + "  - setting3: true"
                        + System.lineSeparator()
                        + "  + setting3: none"
                        + System.lineSeparator()
                        + "}";

        assertEquals(expected, actual);
    }
}
