package producerConsumer;

import java.util.concurrent.BlockingQueue;

public class Consumer extends Thread{
    int taken = -1;

    private BlockingQueue blockingQueue;
    public Consumer(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {

        try {
            while (taken <= 5){
                Object obj = blockingQueue.take();
                System.out.println("message received :" + obj);
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
