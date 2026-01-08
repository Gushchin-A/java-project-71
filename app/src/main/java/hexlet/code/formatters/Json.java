package hexlet.code.formatters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import hexlet.code.DiffStructure;

import java.util.List;

/** Класс форматера "Json". */
public final class Json {

    private Json() { }

    /** Метод форматирования "Json".
     *
     * @param diff список статусов изменений, новых и старых значений
     * @return строка в формате JSON
     * @throws Exception если серилизация не удалась
     */
    public static String formatJson(final List<DiffStructure> diff)
            throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        return mapper.writeValueAsString(diff);
    }
}
