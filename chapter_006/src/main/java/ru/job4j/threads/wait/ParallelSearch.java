package ru.job4j.threads.wait;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.stream.IntStream;

@ThreadSafe
public class ParallelSearch {
    @GuardedBy("queue")
    private static final SimpleBlockingQueue<Integer> QUEUE = new SimpleBlockingQueue<>();
    public static void main(String[] args) throws InterruptedException {
        final Thread producer = new Thread(()-> IntStream.range(0, 7).forEach(QUEUE::offer));
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
