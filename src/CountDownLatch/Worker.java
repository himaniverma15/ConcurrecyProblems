package CountDownLatch;

import java.util.concurrent.CountDownLatch;

public class Worker implements Runnable{

    private int id ;
    private CountDownLatch latch;

    public Worker(int id, CountDownLatch latch) {
        this.id = id;
        this.latch = latch;
    }

    @Override
    public void run() {
        doWork();
        latch.countDown();
    }

    private void doWork(){
        System.out.println("Thread with id "+ id + " started working ");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
