package ru.job4j.io.zip;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;
/**
 *Данный класс тестирует работу класса Zip.
 *@author Anton Kondratkov
 *@since 27.07.2019
 */
public class ZipTest {
    @Before
    public void setUp() {
        File testDir = new File(System.getProperty("java.io.tmpdir") + "/FolderForTestingZipping");
        testDir.mkdirs();
    }

    @After
    public void tearDown() throws Exception {
        new File(System.getProperty("java.io.tmpdir") + "/FolderForTestingZipping", "testFileOne.abc").delete();
        new File(System.getProperty("java.io.tmpdir") + "/FolderForTestingZipping", "testFileTwo.cba").delete();
        new File(System.getProperty("java.io.tmpdir") + "/FolderForTestingZipping").delete();
        new File("ZipTestFile.zip").delete();
    }

    @Test
    public void whenPackIntoTempFolder() throws IOException {
        new File(System.getProperty("java.io.tmpdir") + "/FolderForTestingZipping", "testFileOne.abc").createNewFile();
        new File(System.getProperty("java.io.tmpdir") + "/FolderForTestingZipping", "testFileTwo.cba").createNewFile();
        String[] args = {"-d", System.getProperty("java.io.tmpdir") + "/FolderForTestingZipping", "-e", "cba", "-o", "ZipTestFile.zip"};
        Zip.main(args);
        assertTrue(new File("ZipTestFile.zip").exists());
    }
}
