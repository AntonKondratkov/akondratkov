package ru.job4j.student;
/**
 *Class Student содержит описание объекта студент.
 *@author Anton Kondratkov
 *@since 06.07.2019
 */
public class Student {
    //Поле хранит общий балл по всем предметам.
    int score;
    //Поле хранит фамилию студента.
    String secondName;

    public Student(int score, String secondName) {
        this.score = score;
        this.secondName = secondName;

    }
    public String getSecondName() {
        return secondName;
    }
}
