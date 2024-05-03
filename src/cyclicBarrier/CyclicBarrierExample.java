package cyclicBarrier;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("All tasks have been finished!!");
            }
        });
        for (int i = 0; i < 10; i++) {
            executorService.execute(new Worker(i, cyclicBarrier));
        }
        executorService.shutdown();
    }
}
