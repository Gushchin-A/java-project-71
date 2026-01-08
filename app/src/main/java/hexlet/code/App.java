package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Option;
import picocli.CommandLine.Help;

import java.util.concurrent.Callable;

/** Утилита gendiff. Сравнивает два файла. */
@Command(
        name = "gendiff",
        mixinStandardHelpOptions = true,
        version = "gendiff 0.1.0",
        description = "Compares two configuration files and shows a difference."
)
public final class App implements Callable<Integer> {
    /** Путь к файлу №1. */
    @Parameters(index = "0", paramLabel = "filepath1",
            description = "path to first file")
    private String filepath1;

    /** Путь к файлу №2. */
    @Parameters(index = "1", paramLabel = "filepath2",
            description = "path to second file")
    private String filepath2;

    /** Вывод результата. */
    @Option(
            names = {"-f", "--format"},
            paramLabel = "format",
            description = "Output format: stylish | plain | json",
            defaultValue = "stylish",
            showDefaultValue = Help.Visibility.ALWAYS
    )
    private String format;

    /**
     * Запускает сравнение файлов.
     *
     * @return код возврата приложения
     * @throws Exception для ошибок чтения/парсинга
     */
    public Integer call() throws Exception {
        String diff = Differ.generate(filepath1, filepath2, format);
        System.out.println(diff);
        return 0;
    }

    /**
     * Точка входа.
     *
     * @param args аргументы командной строки
     */
    public static void main(final String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
