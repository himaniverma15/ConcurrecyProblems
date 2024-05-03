package diningPhilosophers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = null;
        Philosophers[] philosophers = null;
        Chopsticks[] chopsticks = null;

        try {
            chopsticks = new Chopsticks[Constants.NUMBER_OF_CHOPSTICKS];
            philosophers = new Philosophers[Constants.NUMBER_OF_PHILOSOPHERS];

            for (int i = 0; i < Constants.NUMBER_OF_CHOPSTICKS; i++)
                chopsticks[i] = new Chopsticks(i);

            executorService = Executors.newFixedThreadPool(Constants.NUMBER_OF_PHILOSOPHERS);

            for (int i = 0; i < Constants.NUMBER_OF_PHILOSOPHERS; i++) {
                philosophers[i] = new Philosophers(i, chopsticks[i], chopsticks[(i + 1) % Constants.NUMBER_OF_PHILOSOPHERS]);
                executorService.execute(philosophers[i]);
            }

            Thread.sleep(Constants.SIMULATION_RUNNING_TIME);

            for (Philosophers philosopher : philosophers) philosopher.setFull(true);

        } finally {
            executorService.shutdown();

            while (!executorService.isTerminated()) Thread.sleep(1000);

            for (Philosophers philosopher : philosophers) {
                System.out.println(philosopher + " eat #" + philosopher.getEatCounter() + "times !");
            }
        }
    }
}
