package ru.job4j.threads;
import javafx.scene.shape.Rectangle;

/**
 * Class RectangleMove. Задаёт логику движения квадратика.
 * @author Anton Kondratkov
 * @since 11.09.2018
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
                    while (this.rect.getX() != 0 && !Thread.interrupted()) {
                        this.rect.setX(this.rect.getX() - 2);
                        Thread.sleep(50);
                    }
                }
                this.rect.setX(this.rect.getX() + 10);

                Thread.sleep(50);
            }
        }  catch (InterruptedException e) {
        }
    }
}
