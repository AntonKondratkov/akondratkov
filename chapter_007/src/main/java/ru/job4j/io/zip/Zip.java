package ru.job4j.io.zip;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
/**
 *Класс архивирует директорию.
 *@author Anton Kondratkov
 *@since 27.07.2019
 */
public class Zip {

    private String directory;
    private String ext;
    private String filename;

    private Zip(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-d")) {
                directory = args[i + 1];
            } else if (args[i].equals("-e")) {
                ext = args[i + 1];
            } else if (args[i].equals("-o")) {
                filename = args[i + 1];
            }
        }
    }

    private void pack() throws IOException {
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(filename))) {
            Path pp = Paths.get(directory);
            Files.walk(pp)
                    .filter(path -> !Files.isDirectory(path))
                    .filter(path -> !path.toFile().getName().endsWith("." + ext))
                    .forEach(path -> {
                        ZipEntry zipEntry = new ZipEntry(pp.relativize(path).toString());
                        try {
                            zos.putNextEntry(zipEntry);
                            Files.copy(path, zos);
                            zos.closeEntry();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        }
    }


    public static void main(String[] args) throws IOException {
        Zip zip = new Zip(args);
        zip.pack();
    }
}
