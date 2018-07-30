package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class Converter. Осуществляет преобразование итератора итераторов в итератор чисел.
 * @author Anton Kondratkov
 * @since 30.07.2018
 */

public class Converter{

    private Iterator<Integer> integerIterator;
    /**
     * Метод принимает объект итератор итераторов и возвращает итератор чисел.
     */
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
       return new Iterator<Integer>() {
           @Override
           public boolean hasNext() {
               selectIterator();
               boolean result = false;
               if (integerIterator == null) {
                   return false;
               }
               if (integerIterator.hasNext()) {
                   return true;
               }
               if (it.hasNext()) {
                   integerIterator = it.next();
                   return integerIterator.hasNext();
               }
               return result;
           }

           @Override
           public Integer next() {
               selectIterator();
               if (integerIterator == null) {
                   throw new NoSuchElementException();
               }
               if (!integerIterator.hasNext() && it.hasNext()) {
                   integerIterator = it.next();
               }
               return integerIterator.next();
           }

           private void selectIterator() {
               if (integerIterator == null && it.hasNext()){
                   integerIterator = it.next();
               }
           }
       };
    }
}
