package ru.job4j.io;

import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.util.*;
/**
 *Класс сканирует файловую систему.
 *@author Anton Kondratkov
 *@since 25.07.2019
 */
public class Search {
    /**
     * Метод возвращает список всех файлов с конкретным расширением в директории.
     * @param parent - Путь до каталога, с которого нужно осуществлять поиск.
     * @param exts - Список расширений файлов, которые необходимо получить.
     * @return files - Список файлов.
     */
    List<File> files(String parent, List<String> exts) {
        List<File> files = new ArrayList<>();
        if (exts != null && exts.size() != 0) {
            File file = new File(parent);
            if (file.exists()) {
                Queue<File> filesForCheck = new LinkedList<>();
                filesForCheck.offer(file);
                files = checkingExtension(exts, filesForCheck);
            }
        }
        return files;
    }
    /**
     * Метод ищет в списке файлов, файлы с нужным расширением.
     * @param exts - Список с расширениями файлов.
     * @param filesForCheck - Файлы для проверки.
     * @return files - Список файлов с нужными расширениями.
     */
    public List<File> checkingExtension(List<String> exts, Queue<File> filesForCheck) {
        List<File> files = new ArrayList<>();
        while (!filesForCheck.isEmpty()) {
            File[] currentFiles = filesForCheck.poll().listFiles();
            if (currentFiles != null) {
                for (File f : currentFiles) {
                    if (f.isDirectory()) {
                        filesForCheck.offer(f);
                    } else if (exts.contains(FilenameUtils.getExtension(f.getName()))) {
                        files.add(f);
                    }
                }
            }
        }
        return files;
    }
}
