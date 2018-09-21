package ru.job4j.threads;
import javafx.scene.shape.Rectangle;

/**
 * Class RectangleMove. Задаёт логику движения квадратика.
 * @author Anton Kondratkov
 * @since 21.09.2018
 */

public class RectangleMove implements Runnable {
    private final Rectangle rect;

    public RectangleMove(Rectangle rect) {
        this.rect = rect;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                if (this.rect.getX() == 290) {
                    Thread.sleep(50);
                    this.rect.setX(0);
                } else {
                    this.rect.setX(this.rect.getX() + 5);
                    Thread.sleep(50);
                }
            }
        }  catch (InterruptedException e) {
            System.out.println("Поток прерван");
        }
    }
}
