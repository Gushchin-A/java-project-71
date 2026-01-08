package hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

/** Класс для сравнения файлов и составление списка отличий. */
public final class DiffBuilder {

    private DiffBuilder() { }

    /** Построение diff.
     *
     * @param data1 данные после парсинга файла №1
     * @param data2 данные после парсинга файла №2
     * @return diff списком
     */
    public static List<DiffStructure> build(
            final Map<String, Object> data1, final Map<String, Object> data2) {
        Set<String> allKeys = new TreeSet<>();
        allKeys.addAll(data1.keySet());
        allKeys.addAll(data2.keySet());

        List<DiffStructure> diff = new ArrayList<>();

        for (String key : allKeys) {
            boolean hasData1 = data1.containsKey(key);
            boolean hasData2 = data2.containsKey(key);

            Object value1 = data1.get(key);
            Object value2 = data2.get(key);

            if (hasData1 && hasData2) {
                if (Objects.equals(value1, value2)) {
                    diff.add(new DiffStructure(key,
                            DiffStructure.UNCHANGED, value1, value2));
                } else {
                    diff.add(new DiffStructure(key,
                            DiffStructure.UPDATED, value1, value2));
                }
            } else if (hasData1) {
                diff.add(new DiffStructure(key,
                        DiffStructure.REMOVED, value1, null));
            } else {
                diff.add(new DiffStructure(key,
                        DiffStructure.ADDED, null, value2));
            }
        }

        return diff;
    }
}
