package ru.job4j.threads.wait;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class ParallelSearch {
    @GuardedBy("queue")
    private static final SimpleBlockingQueue<Integer> QUEUE = new SimpleBlockingQueue<Integer>();
    public static void main(String[] args) throws InterruptedException {
        final Thread producer = new Thread(
                ()-> {
                    for (int index = 0; index != 7; index++) {
                        try {
                            QUEUE.offer(index);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );
        final Thread consumer = new Thread(
                ()-> {
                    while (!Thread.currentThread().isInterrupted() || QUEUE.size() > 0) {
                        try {
                            System.out.println(QUEUE.poll());
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();

                        }
                    }
                }
        );
        producer.start();
        consumer.start();
        producer.join();
        consumer.interrupt();
        consumer.join();
    }
}
