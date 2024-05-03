package queue;

import java.util.LinkedList;
import java.util.List;

public class BlockingQueueExample {

    private static List queue = new LinkedList();
    private int limit = 10;


    public static void main(String[] args) throws InterruptedException {

        for(int i = 0 ; i< 10 ; i++){
            queue.add(new Integer(i+1));
        }

        BlockingQueueExample blockingQueue = new BlockingQueueExample();

        blockingQueue.put(new Integer(11));

        blockingQueue.take();

    }

    //enqueue from tail
    public synchronized void put(Object item) throws InterruptedException {

        if (queue.size() == limit) wait();

        queue.add(item);

        if (queue.size() == 1) notifyAll();

    }

    //dequeue from head
    public synchronized void take() throws InterruptedException {

        if (queue.size() == 0) wait();

        if (queue.size() == limit) notifyAll();

        queue.remove(0);

    }
}
