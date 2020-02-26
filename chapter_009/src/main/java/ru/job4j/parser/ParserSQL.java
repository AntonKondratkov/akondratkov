package ru.job4j.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.quartz.Job;
import org.quartz.JobExecutionContext;

import java.io.IOException;

public class ParserSQL  implements Job {
    ScriptSQL scriptSQL = new ScriptSQL();
    Document page;
    Document vac;
    Elements listVacancy;
    /**
     * Метод парсит сайт sql.ru в разделе "Работа" и собирает Java вакансии.
     * Собранные вакансии метод помещает в три отдельных листа:
     * names - название вакансии; links - ссылка на вакансию; commnets - описание вакансии.
     * @param context
     */
    @Override
    public void execute(JobExecutionContext context) {
        try {
            page = Jsoup.connect("http://sql.ru/forum/job-offers/1").get();
            listVacancy = page.select("td.postslisttopic > a");
            for (Element element : listVacancy) {
                if (element.text().matches("(.*)[Jj][Aa][Vv][Aa]\\s*[^Ss](.*)")) {
                    if (scriptSQL.findByName(element.text()) == null) {
                        try {
                            vac = Jsoup.connect(element.attr("href")).get();
                            String result = vac.select("table.msgTable")
                                    .get(0)
                                    .select("td.msgBody").get(1).text();
                            scriptSQL.add(new Vacancy(element.text(), result, element.attr("href")));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else if (scriptSQL.findByName(element.text()).equals(element.text())) {
                        System.out.println("Вакансия - " + element.text() + " есть в БД");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
