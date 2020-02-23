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

public class FindFile {
    private List<Path> fileList;
    private Args args;
    private String directory;
    private String inputFilename;
    private String mask;
    private String regExp;
    private String outputFilename;
    private Map<String, List<Path>> listMap = new HashMap<>();

    public FindFile(String[] args) {
        this.args = new Args(args);
    }

    public void init() throws IOException {
        this.directory = args.getDirectory();
        this.inputFilename = args.getInputFilename();
        this.mask = args.getMask();
        this.regExp = args.getRegExp();
        this.outputFilename = args.getOutputFilename();
        this.listMap.put("this.inputFilename", findByName(this.inputFilename));
        this.listMap.put("this.mask", findByMask(this.mask));
        this.listMap.put("this.regExp", findByRegExp(this.regExp));
    }

    public static void main(String[] args) throws IOException {
        FindFile finder = new FindFile(args);
        finder.init();
        finder.find();
        finder.writeToFile();
    }
    /**
     * Метод ищет и записывает найденные файлы в List.
     * @throws IOException
     */
    public void find() throws IOException {
        for (Map.Entry<String, List<Path>> entry: listMap.entrySet()) {
            if (entry.getValue() != null) {
                this.fileList = entry.getValue();
            }
        }
//        if (this.inputFilename != null) {
//            this.fileList = findByName(this.inputFilename);
//        } else if (this.mask != null) {
//            this.fileList = findByMask(this.mask);
//        } else if (this.regExp != null) {
//            this.fileList = findByRegExp(this.regExp);
//        }

    }
    /**
     * Метод осуществляет поиск файлов по имени.
     * @param filename Имя файла.
     * @return List<Path>
     * @throws IOException
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
     * @throws IOException
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
     * @throws IOException
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
     * Метод записывает файлы из List в файл.
     * @throws IOException
     */
    public void writeToFile() throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(new File(outputFilename)))) {
            this.fileList.forEach(pw::println);
        }
    }
}
