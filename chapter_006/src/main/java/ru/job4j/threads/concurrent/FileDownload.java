package ru.job4j.threads.concurrent;

import java.io.*;
import java.net.URL;

public class FileDownload {
    public static void main(String[] args) throws Exception {
        String file = args[0];
        try (BufferedInputStream in = new BufferedInputStream(new URL(file).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream("pom_tmp.xml")) {
            byte[] dataBuffer = new byte[500];
            int bytesRead;
            int result = 0;
            long before = System.currentTimeMillis();
            while ((bytesRead = in.read(dataBuffer, 0, 500)) != -1) {
                result += bytesRead;
                long after = System.currentTimeMillis();
                if (result >= Integer.valueOf(args[1])) {
                    System.out.println(result);
                    result = 0;
                    Thread.sleep(1000);
                }
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}