package ru.job4j.io.search;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**
 * Класс задаёт логику поиска файла в каталоге и подкаталогах по одному из критериев:
 * 1. Имя файла,
 * 2. Регулярное выражение,
 * 3. Маска.
 * @author Anton Kondratkov
 * @since 28.05.2020
 */
public class FindFile {
    /**
     * Список, который содержит пути к найденным файлам.
     */
    private List<Path> fileList;
    /**
     * Параметр содержит в себе массив аргументов, указанных при запуске.
     */
    private Args args;
    /**
     * Карта содержит в качестве ключа содержит одно из значений: inputFilename, mask, regExp.
     * А в качестве значения результат работы одного из соответствующих методов поиска:
     * findByName, findByMask,findByRegExp.
     */
    private Map<String, List<Path>> listMap = new HashMap<>();
    /**
     * Конструктор.
     * @param args Параметры заданные при запуске класса.
     */
    public FindFile(String[] args) {
        this.args = new Args(args);
    }
    /**
     * Метод инициализирует переменные и вызывает один из методов поиска:
     * 1. findByName - поиск по имени файла;
     * 2. findByMask - поиск по маске;
     * 3. findByRegExp - поиск по регулярному выражению.
     * @throws IOException Ошибка ввода-вывода при обращении к файлу.
     */
    public void init() throws IOException {
        if (args.getInputFilename() != null) {
            this.listMap.put(args.getInputFilename(), findByName(args.getInputFilename()));
        } else if (args.getMask() != null) {
            this.listMap.put(args.getMask(), findByMask(args.getMask()));
        } else if (args.getRegExp() != null) {
            this.listMap.put(args.getRegExp(), findByRegExp(args.getRegExp()));
        }
    }

    public static void main(String[] args) throws IOException {
        FindFile finder = new FindFile(args);
        finder.init();
        finder.find();
        finder.writeToFile();
    }
    /**
     * Метод переписывает пути к найденным файлам из Map в List.
     */
    public void find() {
        for (Map.Entry<String, List<Path>> entry: listMap.entrySet()) {
            if (entry.getValue() != null) {
                this.fileList = entry.getValue();
            }
        }
    }
    /**
     * Метод осуществляет поиск файлов по имени.
     * @param filename Имя файла.
     * @return List<Path>
     * @throws IOException Ошибка ввода-вывода при обращении к файлу.
     */
    private List<Path> findByName(String filename) throws IOException {
        return findBy(file -> file.getName().equals(filename));
    }
    /**
     * Метод осуществляет поиск файлов по маске.
     * @param mask Маска.
     * @return List<Path>
     * @throws IOException Ошибка ввода-вывода при обращении к файлу.
     */
    private List<Path> findByMask(String mask) throws IOException {
        return findBy(file -> file.getName().matches(mask));
    }
    /**
     * Метод осуществляет поиск файлов по регулярному выражению.
     * @param regExp Регулярное выражение.
     * @return List<Path>
     * @throws IOException Ошибка ввода-вывода при обращении к файлу.
     */
    private List<Path> findByRegExp(String regExp) throws IOException {
        return findBy(file -> Pattern.matches(regExp, file.getName()));
    }
    /**
     * Общий метод для 3 методов поиска файлов. Принимает в качестве входящего параметра предикат.
     * @param predicate Условие поиска файлов.
     * @return List<Path>
     * @throws IOException Ошибка ввода-вывода при обращении к файлу.
     */
    public List<Path> findBy(Predicate<File> predicate) throws IOException {
        try (Stream<Path> filesStream = Files.walk(Paths.get(args.getDirectory()))) {
            return filesStream
                    .map(Path::toFile)
                    .filter(predicate)
                    .map(File::toPath)
                    .collect(Collectors.toList());
        }
    }
    /**
     * Метод записывает пути найденных файлов из List в какой-либо файл указанный в аргументах.
     * @throws IOException Ошибка ввода-вывода при обращении к файлу.
     */
    public void writeToFile() throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(new File(args.getOutputFilename())))) {
            this.fileList.forEach(pw::println);
        }
    }
}
