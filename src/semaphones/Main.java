package semaphones;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(1);


        semaphore.acquire();
        System.out.println("*****");

        semaphore.acquire();


        semaphore.release();

        semaphore.acquire();

    }
}
