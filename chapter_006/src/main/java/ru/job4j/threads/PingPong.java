package ru.job4j.threads;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * Class PingPong. Задаёт параметры окна в котором происходит анимация.
 * @author Anton Kondratkov
 * @since 08.11.2018
 */

public class PingPong extends Application {
    private static final String JOB4J = "Пинг-понг www.job4j.ru";

    @Override
    public void start(Stage stage) {
        int limitX = 300;
        int limitY = 300;
        Group group = new Group();
        Rectangle rect = new Rectangle(0, 100, 10, 10);
        group.getChildren().add(rect);
        Thread t = new Thread(new RectangleMove(rect));
        t.start();
        stage.setScene(new Scene(group, limitX, limitY));
        stage.setTitle(JOB4J);
        stage.setResizable(true);
        stage.show();
        stage.setOnCloseRequest(
                event -> t.interrupt()
        );
    }
}
