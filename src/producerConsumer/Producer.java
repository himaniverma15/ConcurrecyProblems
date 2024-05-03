package producerConsumer;

import java.util.concurrent.BlockingQueue;

public class Producer extends Thread {

    private BlockingQueue blockingQueue;

    public Producer(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {

        for (int i = 0; i < 5; i++) {

            try {

                blockingQueue.put(new Integer(i));
                System.out.println("producer message :" + i);


            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
