package ru.job4j.parser;

import java.util.Objects;
/**
 * Класс описывает структуру объекта "Вакансия".
 */
public class Vacancy {
    private int id;
    private String name;
    private String comment;
    private String link;

    public Vacancy(String name, String comment, String link) {
        this.name = name;
        this.comment = comment;
        this.link = link;
    }
    public String getName() {
        return name;
    }
    public String getComment() {
        return comment;
    }
    public String getLink() {
        return link;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "Vacancy{" + "name='" + name + '\''
                + ", comment='" + comment + '\''
                + ", link='" + link + '\'' + '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Vacancy vacancy = (Vacancy) o;
        return Objects.equals(name, vacancy.name)
                && Objects.equals(comment, vacancy.comment)
                && Objects.equals(link, vacancy.link);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, comment, link);
    }
}
