package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class Converter. Осуществляет преобразование итератора итераторов в итератор чисел.
 * @author Anton Kondratkov
 * @since 02.08.2018
 */

public class Converter{

    class IterateInteger {
        private Iterator<Integer> integerIterator;
    }

    private Iterator<Integer> iteratorInt = new IterateInteger().integerIterator;
    /**
     * Метод принимает объект итератор итераторов и возвращает итератор чисел.
     */
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
       return new Iterator<Integer>() {
           @Override
           public boolean hasNext() {
               selectIterator();
               if (iteratorInt == null) {
                   return false;
               }
               if (iteratorInt.hasNext()) {
                   return true;
               }
               if (it.hasNext()) {
                   iteratorInt = it.next();
               }
               return iteratorInt.hasNext();
           }

           @Override
           public Integer next() {
               selectIterator();
               if (iteratorInt == null) {
                   throw new NoSuchElementException();
               }
               if (!iteratorInt.hasNext() && it.hasNext()) {
                   iteratorInt = it.next();
               }
               return iteratorInt.next();
           }

           private void selectIterator() {
               if (iteratorInt == null && it.hasNext()) {
                   iteratorInt = it.next();
               }
           }
       };
    }
}
