package hexlet.code.formatters;

import hexlet.code.DiffBuilder;
import hexlet.code.DiffStructure;

import java.util.List;
import java.util.Map;

/**
 * Класс форматера "Plain".
 */
public final class Plain {

    private Plain() { }

    /** Метод форматирования "Plain".
     *
     * @param diff список статусов изменений, новых и старых значений
     * @return отформатированная строка
     */
    public static String formatPlain(final List<DiffStructure> diff) {
        String ln = System.lineSeparator();
        StringBuilder sb = new StringBuilder();

        for (DiffStructure e : diff) {
            String key = e.getKey();
            String status = e.getStatus();
            Object oldV = e.getOldValue();
            Object newV = e.getNewValue();

            if (DiffBuilder.REMOVED.equals(status)) {
                sb.append("Property ").append(formatCheck(key))
                        .append(" was removed").append(ln);
            } else if (DiffBuilder.UPDATED.equals(status)) {
                sb.append("Property ").append(formatCheck(key))
                        .append(" was updated.")
                        .append(" From ").append(formatCheck(oldV))
                        .append(" to ").append(formatCheck(newV))
                        .append(ln);
            } else if (DiffBuilder.ADDED.equals(status)) {
                sb.append("Property ").append(formatCheck(key))
                        .append(" was added with value: ")
                        .append(formatCheck(newV)).append(ln);
            }
        }

        return sb.toString().trim();
    }

    /** Приватный метод проверки значения.
     *
     * @param value новое или старое значение
     * @return отформатированное значение
     */
    private static String formatCheck(final Object value) {
        if (value == null) {
            return "null";
        }
        if (value instanceof Map || value instanceof List) {
            return "[complex value]";
        }
        if (value instanceof String) {
            return "'" + value + "'";
        }

        return String.valueOf(value);
    }
}
