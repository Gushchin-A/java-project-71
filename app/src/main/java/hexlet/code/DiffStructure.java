package hexlet.code;

/** Класс с результатом diff: ключи, статусы, изменения. */
public final class DiffStructure {
    /** Статус сравнения «Добавлено новое». */
    public static final String ADDED = "added";
    /** Статус сравнения «Удалено». */
    public static final String REMOVED = "removed";
    /** Статус сравнения «Без изменений». */
    public static final String UNCHANGED = "unchanged";
    /** Статус сравнения «Обновлено». */
    public static final String UPDATED = "updated";

    /** Ключ для сравнения файлов. */
    private final String key;
    /** Статус изменения. */
    private final String status;
    /** Старое значение ключа. */
    private final Object oldValue;
    /** Новое значение ключа. */
    private final Object newValue;

    /**
     * Конструктор diff.
     *
     * @param keyValue ключ
     * @param statusValue статус
     * @param oldVal старое значение
     * @param newVal новое значение
     */
    public DiffStructure(final String keyValue, final String statusValue,
                         final Object oldVal, final Object newVal) {
        this.key = keyValue;
        this.status = statusValue;
        this.oldValue = oldVal;
        this.newValue = newVal;
    }

    /** @return ключ для сравнения */
    public String getKey() {
        return key;
    }

    /** @return статус изменения */
    public String getStatus() {
        return status;
    }

    /** @return старое значение */
    public Object getOldValue() {
        return oldValue;
    }

    /** @return новое значение ключа */
    public Object getNewValue() {
        return newValue;
    }
}
