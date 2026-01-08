package hexlet.code;

import hexlet.code.formatters.Formatter;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

/** Класс с методами для генерации diff. */
public final class Differ {

    private Differ() {
    }

    /** Генерация diff без указания формата. По умолчанию "Stylish".
     *
     * @param p1 путь к файлу №1
     * @param p2 путь к файлу №2
     * @return отформатированная строка
     * @throws Exception при ошибке чтения или парсинга
     */
    public static String generate(
            final String p1, final String p2) throws Exception {
        return generate(p1, p2, Formatter.STYLISH);
    }

    /** Генерация diff.
     *
     * @param p1 путь к файлу №1
     * @param p2 путь к файлу №2
     * @param style формат
     * @return отформатированная строка
     * @throws Exception при ошибке чтения или парсинга
     */
    public static String generate(
            final String p1, final String p2,
            final String style) throws Exception {
        String file1 = readFile(p1);
        String file2 = readFile(p2);

        String type1 = determineFileType(p1);
        String type2 = determineFileType(p2);
        if (!type1.equals(type2)) {
            throw new IllegalArgumentException("Расширения файлов разные.");
        }

        Map<String, Object> data1 = Parser.chooseParser(file1, type1);
        Map<String, Object> data2 = Parser.chooseParser(file2, type2);

        List<DiffStructure> diff = DiffBuilder.build(data1, data2);

        return Formatter.format(diff, style);
    }

    /** Чтение файла.
     * @param path путь до файла
     * @return содержимое файла
     * @throws Exception если чтение не удалось
     */
    public static String readFile(final String path) throws Exception {
        final Path p = Path.of(path);

        if (!Files.exists(p)) {
            throw new IllegalArgumentException(
                    "Файл не найден или путь не верный: " + path);
        }

        return Files.readString(p);
    }

    /** Проверка расширения файла.
     *
     * @param p путь до файла
     * @return расширение файла
     */
    public static String determineFileType(final String p) {
        int indexDot = p.lastIndexOf('.');
        if (indexDot == -1) {
            throw new IllegalArgumentException(
                    "Путь к файлу указан с ошибкой.");
        }

        return p.substring(indexDot + 1).toLowerCase();
    }
}
