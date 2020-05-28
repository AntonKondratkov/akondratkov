package ru.job4j.io.search;

import org.apache.commons.io.filefilter.RegexFileFilter;
import org.apache.commons.io.filefilter.WildcardFileFilter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        this.directory = args.getDirectory();
        this.inputFilename = args.getInputFilename();
        this.mask = args.getMask();
        this.regExp = args.getRegExp();
        this.outputFilename = args.getOutputFilename();
        if (this.inputFilename != null) {
            this.listMap.put(this.inputFilename, findByName(this.inputFilename));
        } else if (this.mask != null) {
            this.listMap.put(this.mask, findByMask(this.mask));
        } else if (this.regExp != null) {
            this.listMap.put(this.regExp, findByRegExp(this.regExp));
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
        try (Stream<Path> filesStream = Files.walk(Paths.get(this.directory))) {
            return filesStream
                    .filter(f -> f.toFile().getName().equals(filename))
                    .collect(Collectors.toList());
        }
    }
    /**
     * Метод осуществляет поиск файлов по маске.
     * @param mask Маска.
     * @return List<Path>
     * @throws IOException Ошибка ввода-вывода при обращении к файлу.
     */
    private List<Path> findByMask(String mask) throws IOException {
        FileFilter fileFilter = new WildcardFileFilter(mask);
        try (Stream<Path> filesStream = Files.walk(Paths.get(this.directory))) {
            return filesStream
                    .map(Path::toFile)
                    .filter(fileFilter::accept)
                    .map(File::toPath)
                    .collect(Collectors.toList());
        }
    }
    /**
     * Метод осуществляет поиск файлов по регулярному выражению.
     * @param regExp Регулярное выражение.
     * @return List<Path>
     * @throws IOException Ошибка ввода-вывода при обращении к файлу.
     */
    private List<Path> findByRegExp(String regExp) throws IOException {
        FileFilter fileFilter = new RegexFileFilter(regExp);
        try (Stream<Path> filesStream = Files.walk(Paths.get(this.directory))) {
            return filesStream
                    .map(Path::toFile)
                    .filter(fileFilter::accept)
                    .map(File::toPath)
                    .collect(Collectors.toList());
        }
    }
    /**
     * Метод записывает пути найденных файлов из List в какой-либо файл указанный в аргументах.
     * @throws IOException Ошибка ввода-вывода при обращении к файлу.
     */
    public void writeToFile() throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(new File(outputFilename)))) {
            this.fileList.forEach(pw::println);
        }
    }
}
