package hexlet.code.formatters;

import hexlet.code.DiffStructure;

import static hexlet.code.formatters.Json.formatJson;
import static hexlet.code.formatters.Plain.formatPlain;
import static hexlet.code.formatters.Stylish.formatStylish;

import java.util.List;

/** Класс для форматирования diff. */
public final class Formatter {
    /** Стиль форматирования "Stylish". */
    public static final String STYLISH = "stylish";
    /** Стиль форматирования "Plain". */
    public static final String PLAIN = "plain";
    /** Стиль форматирования "Json". */
    public static final String JSON = "json";

    private Formatter() { }

    /** Форматирование diff в строку по заданному стилю.
     *
     * @param diff список статусов изменений, новых и старых значений
     * @param style формат вывода
     * @return отформатированная строка в заданном формате
     * @throws Exception если форматирование не удалось
     */
    public static String format(
            final List<DiffStructure> diff, final String style)
            throws Exception {

        return switch (style) {
            case STYLISH -> formatStylish(diff);
            case PLAIN -> formatPlain(diff);
            case JSON -> formatJson(diff);
            default -> throw new IllegalArgumentException(
                    "Неизвестный формат: " + style);
        };
    }
}
