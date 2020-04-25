package ru.job4j.io.stream;

import java.io.FileInputStream;

/**
 *Класс построчно считывает числа из файла и проверяет их на чётность.
 *@author Anton Kondratkov
 *@since 25.04.2020
 */
public class EvenNumberFile {
    public static void main(String[] args) {
//        try (BufferedReader in = new BufferedReader(new FileReader("even.txt"))) {
//            String line;
//            while ((line = in.readLine()) != null) {
//                System.out.println(Integer.valueOf(line) % 2 == 0);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        try (FileInputStream in = new FileInputStream("even.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
            String [] strings = text.toString().split("\n");
            for (String s : strings) {
                System.out.println(Long.valueOf(s.trim()) % 2 == 0);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}