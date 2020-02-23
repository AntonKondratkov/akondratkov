package ru.job4j.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParserSQL {
    public static void main(String[] args) {

        Document htmlFile = null;
        try {
            htmlFile = Jsoup.connect("http://sql.ru/forum/job-offers/3").get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements listVacancy = htmlFile.select("td.postslisttopic > a");

        Elements elementList = new Elements();
        List<String> links = new ArrayList<>();
        List<String> names = new ArrayList<>();
        List<String> commnets = new ArrayList<>();

        for (Element element : listVacancy) {
            if (element.text().matches("(.*)[Jj][Aa][Vv][Aa]\\s*[^Ss](.*)")) {
                elementList.add(element);
                links.add(element.attr("href"));
                names.add(element.text());
            }
        }

        Document htmlFile2;
        Element body;
        try {
            for (int i = 0; i < links.size(); i++) {
                htmlFile2 = Jsoup.connect(links.get(i)).get();
                body = htmlFile2.select("table.msgTable").get(0);
                commnets.add(body.select("td.msgBody").get(1).text());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String s: links) {
            System.out.println(s);
        }

//        System.out.println(elementList);
//        System.out.println();
//        System.out.println(links);
//        System.out.println();
//        System.out.println(names);

        for (String s: names) {
            System.out.println(s);
        }

    }
}
