package producerConsumer;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class App {
    public static void main(String[] args) {

        BlockingQueue blockingQueue = new ArrayBlockingQueue(5);

        Producer producer = new Producer(blockingQueue);
        Consumer consumer = new Consumer(blockingQueue);

        producer.start();
        consumer.start();


    }
}
