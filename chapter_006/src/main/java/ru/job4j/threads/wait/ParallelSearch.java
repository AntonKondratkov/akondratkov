package ru.job4j.threads.wait;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class ParallelSearch {
    @GuardedBy("queue")
    private static final SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<Integer>();
    public static void main(String[] args) throws InterruptedException {
        final Thread producer = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        for (int index = 0; index != 7; index++) {
                            try {
                                queue.offer(index);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
        );

        final Thread consumer = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        while (producer.isAlive()) {
                            while (queue.size()!= 0) {
                                try {
                                    System.out.println(queue.poll());
                                } catch (InterruptedException e) {
                                    e.printStackTrace();

                                }
                            }
                        }
                    }
                }
        );

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();
    }
}
