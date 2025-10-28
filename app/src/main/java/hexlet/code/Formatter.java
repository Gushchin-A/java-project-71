package hexlet.code;

import java.util.List;

/**
 * Класс для форматирования diff.
 */
public final class Formatter {
    /** Стиль форматирования "Stylish". */
    public static final String STYLISH = "stylish";

    private Formatter() { }

    /** Форматирование diff в строку по заданному стилю.
     *
     * @param diff список статусов изменений, новых и старых значений
     * @param style формат вывода
     * @return отформатированная строка в заданном формате
     */
    public static String format(
            final List<DiffStructure> diff, final String style) {
        return switch (style) {
            case STYLISH -> formatStylish(diff);
            default -> throw new IllegalArgumentException(
                    "Неизвестный формат: " + style
            );
        };
    }

    /** Приватный метод форматирования "Stylish".
     *
     * @param diff список статусов изменений, новых и старых значений
     * @return отформатированная строка
     */
    private static String formatStylish(final List<DiffStructure> diff) {
        String ln = System.lineSeparator();
        StringBuilder sb = new StringBuilder();

        sb.append("{").append(ln);

        for (DiffStructure e : diff) {
            String key = e.getKey();
            String status = e.getStatus();
            Object oldV = e.getOldValue();
            Object newV = e.getNewValue();

            if (DiffBuilder.UNCHANGED.equals(status)) {
                sb.append("    ").append(key).append(": ")
                        .append(String.valueOf(oldV)).append(ln);
            } else if (DiffBuilder.REMOVED.equals(status)) {
                sb.append("  - ").append(key).append(": ")
                        .append(String.valueOf(oldV)).append(ln);
            } else if (DiffBuilder.ADDED.equals(status)) {
                sb.append("  + ").append(key).append(": ")
                        .append(String.valueOf(newV)).append(ln);
            } else if (DiffBuilder.UPDATED.equals(status)) {
                sb.append("  - ").append(key).append(": ")
                        .append(String.valueOf(oldV)).append(ln);
                sb.append("  + ").append(key).append(": ")
                        .append(String.valueOf(newV)).append(ln);
            }
        }
        sb.append("}");

        return sb.toString();
    }
}
