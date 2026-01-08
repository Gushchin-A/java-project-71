package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.util.Map;

/** Класс для парсинга. */
public final class Parser {

    private Parser() {
    }

    /** Проверка расширения. В зависимости от расширения файла
     * вызывает парсер JSON или YML.
     *
     * @param file файл
     * @param type тип расширения
     * @return вызов соответствующего парсинга с возвратом ключ-значение
     * @throws Exception если парсинг не удался
     */
    public static Map<String, Object> chooseParser(
            final String file, final String type) throws Exception {
        return switch (type) {
            case "json" -> parsingJson(file);
            case "yml", "yaml" -> parsingYml(file);
            default -> throw new IllegalArgumentException(
                    "Неизвестное расширение.");
        };
    }

    /** Парсинг JSON в Map.
     *
     * @param dataJson строка JSON
     * @return отображение в формате ключ-значение
     * @throws Exception если парсинг не удался
     */
    private static Map<String, Object> parsingJson(
            final String dataJson) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(dataJson, Map.class);
    }

    /** Парсинг YML в Map.
     *
     * @param dataYml строка YML
     * @return отображение в формате ключ-значение
     * @throws Exception если парсинг не удался
     */
    private static Map<String, Object> parsingYml(
            final String dataYml) throws Exception {
        ObjectMapper mapper = new YAMLMapper();
        return mapper.readValue(dataYml, Map.class);
    }
}
