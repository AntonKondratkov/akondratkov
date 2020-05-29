package ru.job4j.threads.synchronizy;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.io.*;
/**
 * Парсер файла.
 * @author Anton Kondratkov
 * @since 24.05.2020
 */
@ThreadSafe
public class ParseFile {
    @GuardedBy("this")
    private volatile File file;
    /**
     * Конструктор.
     * @param file Файл, который необходимо пропарсить.
     */
    public ParseFile(File file) {
        this.file = file;
    }
    /**
     * Геттер.
     * @return this.file
     */
    public File getFile() {
        return file;
    }
    /**
     * Метод считывает содержимое файла.
     * @return Строковое представление содержимого файла.
     */
    public synchronized String getContent() {
        String line;
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(getFile()))) {
            while ((line = reader.readLine()) != null) {
                sb.append(line)
                        .append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
    /**
     * Метод считывает содержимое файла без символов русского алфавита.
     * @return Строковое представление содержимого файла.
     */
    public synchronized String getContentWithoutUnicode() {
        StringBuilder sb = new StringBuilder();
        char[] buffer = new char[1024];
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(getFile())))) {
            while ((br.read(buffer, 0, buffer.length)) != -1) {
                for (char c : buffer) {
                    if (c < 0x80) {
                        sb.append((c));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
    /**
     * Метод записывает информацию в файл.
     * @param content Информация для записи в файл.
     */
    public synchronized void saveContent(String content) {
        try (BufferedWriter bf = new BufferedWriter(new FileWriter(getFile()))) {
            char[] buffer = content.toCharArray();
            bf.write(buffer, 0, buffer.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
