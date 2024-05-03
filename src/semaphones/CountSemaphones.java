package semaphones;

public class CountSemaphones {

    private int single = 0;

    public synchronized void take() {
        single += 1;
        notify();
    }

    public synchronized void release() throws InterruptedException {
        while (single == 0) {
            wait();
        }
        single--;
    }
}
