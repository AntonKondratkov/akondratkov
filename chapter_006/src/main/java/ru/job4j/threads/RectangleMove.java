package ru.job4j.threads;
import javafx.scene.shape.Rectangle;

/**
 * Class RectangleMove. Задаёт логику движения квадратика
 * @author Anton Kondratkov
 * @since 08.11.2018
 */

public class RectangleMove implements Runnable {
    private final Rectangle rect;

    public RectangleMove(Rectangle rect) {
        this.rect = rect;
    }
    @Override
    public void run() {
        int direction = 1;
        try {
            while (!Thread.interrupted()) {
                if (this.rect.getX() == 290) {
                    direction = -1;
                } else if (this.rect.getX() == 0) {
                    direction = 1;
                }
                this.rect.setX(this.rect.getX() + 5 * (direction));
                Thread.sleep(50);
            }
        }  catch (InterruptedException e) {
            System.out.println("Поток прерван");
        }
    }
}
