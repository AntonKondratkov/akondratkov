package ru.job4j.comparator;

import java.util.Comparator;

/**
 * @author Anton Kondratkov
 * @since 27.07.18.
 * Класс реализует компаратор для сравнения двух массивов символов.
 * Поэлементно сравнивает элементы в лексикографическом порядке.
 */
public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
      int result = -1;
      int wordLength = o1.length() < o2.length() ? o1.length() : o2.length();
      for (int i = 0; i < wordLength; i++) {
          if (o1.charAt(i) != o2.charAt(i)) {
              result = i;
              break;
          }
      }
      return result == -1 ? Integer.compare(o1.length(), o2.length()) : Character.compare(o1.charAt(result), o2.charAt(result));
    }
}
