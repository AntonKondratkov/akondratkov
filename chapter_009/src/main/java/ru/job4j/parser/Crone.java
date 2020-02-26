package ru.job4j.parser;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * Класс содержит описывает работу планировщика задач quartz.
 */
public class Crone {
    /**
     * Метод запускает парсер согласно заданному графику.
     * @throws SchedulerException
     * @throws InterruptedException
     */
    public void croneTrigger() throws SchedulerException, InterruptedException {
        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler scheduler = sf.getScheduler();
        JobDetail job = newJob(ParserSQL.class)
                .withIdentity("sql", "parser")
                .build();
        CronTrigger trigger = newTrigger()
                .withIdentity("trigger1", "group1")
                .withSchedule(cronSchedule("0/30 * * * * ?")) //cronSchedule("0 0/1 * 1/1 * ? *"))
                .build();
        scheduler.scheduleJob(job, trigger);
        scheduler.start();
        Thread.sleep(300L * 1000L);
        scheduler.shutdown(true);
    }
    public static void main(String[] args) throws InterruptedException, SchedulerException {
        new Crone().croneTrigger();
    }
}
