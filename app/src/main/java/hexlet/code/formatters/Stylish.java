package hexlet.code.formatters;

import hexlet.code.DiffStructure;

import java.util.List;

/**
 * Класс форматера "Stylish".
 */
public final class Stylish {

    private Stylish() { }

    /** Метод форматирования "Stylish".
     *
     * @param diff список статусов изменений, новых и старых значений
     * @return отформатированная строка
     */
    public static String formatStylish(final List<DiffStructure> diff) {
        String ln = System.lineSeparator();
        StringBuilder sb = new StringBuilder();

        sb.append("{").append(ln);

        for (DiffStructure e : diff) {
            String key = e.getKey();
            String status = e.getStatus();
            Object oldV = e.getOldValue();
            Object newV = e.getNewValue();

            if (DiffStructure.UNCHANGED.equals(status)) {
                sb.append("    ").append(key).append(": ")
                        .append(oldV).append(ln);
            } else if (DiffStructure.REMOVED.equals(status)) {
                sb.append("  - ").append(key).append(": ")
                        .append(oldV).append(ln);
            } else if (DiffStructure.ADDED.equals(status)) {
                sb.append("  + ").append(key).append(": ")
                        .append(newV).append(ln);
            } else if (DiffStructure.UPDATED.equals(status)) {
                sb.append("  - ").append(key).append(": ")
                        .append(oldV).append(ln);
                sb.append("  + ").append(key).append(": ")
                        .append(newV).append(ln);
            }
        }
        sb.append("}");

        return sb.toString();
    }
}
