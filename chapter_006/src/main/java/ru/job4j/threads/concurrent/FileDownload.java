package ru.job4j.threads.concurrent;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
/**
 * Класс содержит метод uploadingFile, который реализует логику скачивания файла из сети
 * с ограничением по скорости скачивания.
 * @author Anton Kondratkov
 * @since 23.05.2020
 */
public class FileDownload {
    /**
     * Метод скачивает файл из сети с ограничением по скорости.
     * @param download Объём скачиваемых данных за секунду в байтах.
     * @throws InterruptedException Выбрасывается, если поток прерван во время работы метода sleep.
     */
    public void uploadingFile(int download) throws InterruptedException {
        String file = "https://raw.githubusercontent.com/peterarsentev/course_test/master/pom.xml";
        try (BufferedInputStream in = new BufferedInputStream(new URL(file).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream("pom_tmp.xml")) {
            byte[] dataBuffer = new byte[download];
            int bytesRead;
            long before = System.nanoTime();
            while ((bytesRead = in.read(dataBuffer, 0, download)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
                long millis = ((System.nanoTime() - before) / 1000);
                long waitTime = 1000 - millis;
                if (waitTime > 0) {
                    Thread.sleep(waitTime);
                }
                before = System.nanoTime();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws Exception {
        long startTime = System.nanoTime();
        new FileDownload().uploadingFile(Integer.valueOf(args[0]));
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000000;
        long fileSize = Files.size(Path.of("pom_tmp.xml")) / 1024;
        long downloadSpeed = fileSize / duration;

        System.out.println(String.format("Downloading time: %s sec", duration));
        System.out.println(String.format("File size: %s Kb", fileSize));
        System.out.println(String.format("Downloading speed : %s Kb/sec", downloadSpeed));
    }
}