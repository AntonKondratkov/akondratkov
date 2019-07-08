package ru.job4j.student;
/**
 *Class Student содержит описание объекта студент.
 *@author Anton Kondratkov
 *@since 08.07.2019
 */
public class Student implements Comparable<Student> {
    //Поле хранит общий балл по всем предметам.
    private int score;
    //Поле хранит фамилию студента.
    private String secondName;

    public Student(int score, String secondName) {
        this.score = score;
        this.secondName = secondName;

    }
    public String getSecondName() {
        return secondName;
    }
    public int getScore() {
        return score;
    }
    @Override
    public int compareTo(Student o) {
        return (this.score > o.getScore()) ? -1 : ((this.score == o.getScore()) ? 0 : 1);
    }
}
