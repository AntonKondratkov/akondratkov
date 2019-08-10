package ru.job4j.io.search;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FindFileTest {
    @Before
    public void setUp() throws Exception {
        File testDir = new File(System.getProperty("java.io.tmpdir") + "/test1/test1");
        testDir.mkdirs();
        File testOne = new File(System.getProperty("java.io.tmpdir") + "/test1/test1", "testdoc1.doc");
        File testTwo = new File(System.getProperty("java.io.tmpdir") + "/test1", "testdoc2.txt");
        testOne.createNewFile();
        testTwo.createNewFile();
    }

    @After
    public void tearDown() throws Exception {
        new File(System.getProperty("java.io.tmpdir") + "/test1/test1", "testdoc1.doc").delete();
        new File(System.getProperty("java.io.tmpdir") + "/test1", "testdoc2.txt").delete();
        new File(System.getProperty("java.io.tmpdir") + "/test1/test1", "log.txt").delete();
        new File(System.getProperty("java.io.tmpdir") + "/test1/test1").delete();
        new File(System.getProperty("java.io.tmpdir") + "/test1").delete();
    }


    public String finderTest(String[] args) throws IOException {
        FindFile.main(args);
        File f = new File(System.getProperty("java.io.tmpdir") + "/test1/log.txt");
        String readline;
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            readline = br.readLine();
        }
        return readline.substring(readline.length() - 12);
    }

    @Test
    public void whenFindFileByMaskInTempDir() throws IOException {
        String[] args = {
                "-d",
                System.getProperty("java.io.tmpdir") + "/test1",
                "-n", "*.doc", "-m", "-o",
                System.getProperty("java.io.tmpdir") + "/test1/log.txt"};
        String result = finderTest(args);
        String expected = "testdoc1.doc";
        assertThat(result, is(expected));
    }

    @Test
    public void whenFindFileByNameInTempDir() throws IOException {
        String[] args = {
                "-d",
                System.getProperty("java.io.tmpdir") + "/test1",
                "-n", "testdoc2.txt", "-f", "-o",
                System.getProperty("java.io.tmpdir") + "/test1/log.txt"};
        String result = finderTest(args);
        String expected = "testdoc2.txt";
        assertThat(result, is(expected));
    }

    @Test
    public void whenFindFileByRegexInTempDir() throws IOException {
        String[] args = {
                "-d",
                System.getProperty("java.io.tmpdir") + "/test1",
                "-n", "(testdoc1).*", "-r", "-o",
                System.getProperty("java.io.tmpdir") + "/test1/log.txt"};
        String result = finderTest(args);
        String expected = "testdoc1.doc";
        assertThat(result, is(expected));
    }
}
