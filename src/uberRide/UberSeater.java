//package uberRide;
//
//import java.util.Random;
//
//public class UberSeater {
//
//    public UberSeater() {}
//
//    private int seaterCount = 0;
//
//    public void seatDemocrat(){
//
//        if(seaterCount < Constant.NUMBER_OF_SEATER){
//            seated();
//        }
//
//
//    }
//
//
//    public synchronized void seated() throws InterruptedException {
//        seaterCount++;
//        System.out.println("seated selected by candidate "+ Thread.currentThread().getName() + "seat count : "+ seaterCount);
//        Thread.sleep(new Random().nextInt(1000));
//    }
//
//    public synchronized boolean drive() {
//        if (seaterCount == Constant.NUMBER_OF_SEATER) {
//            System.out.println("driver start the ride !" + Thread.currentThread().getName());
//            return true;
//        }
//        return false;
//    }
//}
