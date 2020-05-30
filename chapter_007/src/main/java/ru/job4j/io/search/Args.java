package ru.job4j.io.search;
/**
 * В классе происходит валидация аргументов, а также инициализация параметров.
 * @author Anton Kondratkov
 * @since 28.05.2020
 */
public class Args {
    /**
     * Параметр содержит в себе массив аргументов, указанных при запуске.
     */
    private String[] args;
    /**
     * Путь к корневому каталогу, где будет происходить поиск файла.
     */
    private String directory;
    /**
     * Параметр содержит имя файла, который нужно искать.
     */
    private String inputFilename;
    /**
     * Параметр содержит маску, необходим при поиске файла по маске.
     */
    private String mask;
    /**
     * Параметр содержит регулярное выражение, необходим при поиске файла по регулярному выражению.
     */
    private String regExp;
    /**
     * Путь к файлу, в который будет записан результат поиска.
     */
    private String outputFilename;
    /**
     * Конструктор.
     * @param args Входящие параметры.
     */
    public Args(String[] args) {
        this.args = args;
        validate();
    }
    /**
     * Метод инициализирует переменные, значения берутся из аргументов.
     * Также в методе происходит проверка аргументов.
     * Если аргументы не были указаны, то в консоль выводится подсказка.
     */
    public void validate() {
        if (args.length == 0 || args.length < 7) {
            throw new IllegalArgumentException(
                    "Не найдено ключей!" + System.lineSeparator()
                            + "Ключи:" + System.lineSeparator()
                            + "        -d - директория в которая начинать поиск." + System.lineSeparator()
                            + "        -n - имя файл, маска, либо регулярное выражение." + System.lineSeparator()
                            + "        -m - искать по маске, либо -f - полное совпадение имени. -r регулярное выражение."
                            + System.lineSeparator()
                            + "        -o - результат записать в файл." + System.lineSeparator()
                            + "Пример использования: java -jar find.jar -d c:/ -n *.txt -m -o log.txt");
        } else {
            for (int i = 0; i < args.length; i++) {
                if (args[i].equals("-d")) {
                    directory = args[i + 1];
                } else if (args[i].equals("-n")) {
                    inputFilename = args[i + 1];
                } else if (args[i].equals("-o")) {
                    outputFilename = args[i + 1];
                } else if (args[i].equals("-m")) {
                    mask = inputFilename;
                    inputFilename = null;
                } else if (args[i].equals("-r")) {
                    regExp = inputFilename;
                    inputFilename = null;
                } else if (args[i].equals("-f")) {
                    regExp = null;
                    mask = null;
                }
            }
        }
    }
    public String getDirectory() {
        return directory;
    }
    public String getInputFilename() {
        return inputFilename;
    }
    public String getMask() {
        return mask;
    }
    public String getRegExp() {
        return regExp;
    }
    public String getOutputFilename() {
        return outputFilename;
    }
}
