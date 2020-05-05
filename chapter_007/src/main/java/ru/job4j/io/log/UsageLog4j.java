package ru.job4j.io.log;

import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Anton Kondratkov
 * @since 05.04.2020
 * Класс показывает работу библиотеки slf4j
 */
public class UsageLog4j {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());
    public static void main(String[] args) {
        BasicConfigurator.configure();
        String name = "Tom";
        int age = 25;
        long height = 180;
        short weight = 74;
        byte shoes = 41;
        float clothes = 40;
        double salary = 28000;
        boolean married = true;
        char driver = 'B';
        LOG.debug("User info name : {}, age : {},"
                + " height : {}, weight : {}, shoes : {},"
                + " clothes : {}, salary : {}, married : {}, driver : {}",
                name, age, height, weight, shoes, clothes, salary, married, driver);
    }
}
