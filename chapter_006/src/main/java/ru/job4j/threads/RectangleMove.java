package ru.job4j.threads;
import javafx.scene.shape.Rectangle;

/**
 * Class RectangleMove. Задаёт логику движения квадратика.
 * @author Anton Kondratkov
 * @since 14.09.2018
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
                    for (int i = 290; i > 0; i -= 5) {
                        this.rect.setX(this.rect.getX() - 5);
                        Thread.sleep(50);
                    }
                }
                this.rect.setX(this.rect.getX() + 5);
                Thread.sleep(50);
            }
        }  catch (InterruptedException e) {
            System.out.println("Поток прерван");
        }
    }
}
