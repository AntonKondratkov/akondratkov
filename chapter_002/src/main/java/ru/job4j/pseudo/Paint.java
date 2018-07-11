package ru.job4j.pseudo;

/**
 * @author Anton Kondratkov
 * @since 12.07.18.
 */
public class Paint {

    public void draw(Shape shape){
        System.out.println(shape.draw());
    }

    public static void main(String[] args) {
        new Paint().draw(new Triangle());

    }
}
