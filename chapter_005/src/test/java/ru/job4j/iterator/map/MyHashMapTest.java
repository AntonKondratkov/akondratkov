package ru.job4j.iterator.map;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;
/**
 *@author Anton Kondratkov
 *@since 16.07.2019
 */
public class MyHashMapTest {
    private MyHashMap<Integer, String> hashMap;
    @Before
    public void onStart() {
       hashMap = new MyHashMap<>();
    }
    @Test
    public void whenAddElementThenCollectionHasIt() {
        for (int i = 0; i < 100; i++) {
            assertTrue(hashMap.insert(i, Integer.toString(i)));
        }
        for (int i = 0; i < 100; i++) {
            assertTrue(Integer.toString(i).equals(hashMap.get(i)));
        }
    }
    @Test
    public void whenRemoveElementThenCollectionNotHasIt() {
        Integer el1 = 1;
        Integer el2 = 2;
        hashMap.insert(el1, el1.toString());
        hashMap.insert(el2, el2.toString());
        hashMap.delete(el1);
        assertFalse(hashMap.get(el1) != null);
    }
    @Test
    public void whenAddElementTwiceThenAddIsFalse() {
        Integer one = 1;
        assertTrue(hashMap.insert(one, one.toString()));
        assertFalse(hashMap.insert(one, one.toString()));
    }
    @Test
    public void iteratorTest() {
        hashMap.insert(1, "one");
        hashMap.insert(2, "two");
        hashMap.insert(3, "three");
        for (String el : hashMap) {
            assertNotNull(el);
        }
        Iterator it = hashMap.iterator();
        it.next();
        it.remove();
        for (String el : hashMap) {
            assertNotNull(el);
        }
    }
}
