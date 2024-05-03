//package uberRide;
//
//import diningPhilosophers.Constants;
//import diningPhilosophers.Philosophers;
//
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//public class App {
//    static UberSeater[] uberSeaters = null;
//    static ExecutorService executorService = null;
//
//    public static void main(String[] args) throws InterruptedException {
//
//        int number = Constant.NUMBER_OF_DEMOCRATS
//                + Constant.NUMBER_OF_REPUBLICANS;
//
//        uberSeaters = new UberSeater[number];
//
//        executorService = Executors.newFixedThreadPool(number);
//
//        for (int i = 0; i < number; i++) {
//            uberSeaters[i] = new UberSeater();
//        }
//
//        try {
//            for (UberSeater seater : uberSeaters) {
//                executorService.execute(seater);
//            }
//
//            Thread.sleep(Constants.SIMULATION_RUNNING_TIME);
//
//            for (UberSeater uberSeater : uberSeaters) uberSeater.drive();
//        } finally {
//            executorService.shutdown();
//
//            while (!executorService.isTerminated()) Thread.sleep(1000);
//        }
//    }
//}
//package uberRide;
//
//import diningPhilosophers.Constants;
//import diningPhilosophers.Philosophers;
//
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//public class App {
//    static UberSeater[] uberSeaters = null;
//    static ExecutorService executorService = null;
//
//    public static void main(String[] args) throws InterruptedException {
//
//        int number = Constant.NUMBER_OF_DEMOCRATS
//                + Constant.NUMBER_OF_REPUBLICANS;
//
//        uberSeaters = new UberSeater[number];
//
//        executorService = Executors.newFixedThreadPool(number);
//
//        for (int i = 0; i < number; i++) {
//            uberSeaters[i] = new UberSeater();
//        }
//
//        try {
//            for (UberSeater seater : uberSeaters) {
//                executorService.execute(seater);
//            }
//
//            Thread.sleep(Constants.SIMULATION_RUNNING_TIME);
//
//            for (UberSeater uberSeater : uberSeaters) uberSeater.drive();
//        } finally {
//            executorService.shutdown();
//
//            while (!executorService.isTerminated()) Thread.sleep(1000);
//        }
//    }
//}
