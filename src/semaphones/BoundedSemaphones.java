package semaphones;

public class BoundedSemaphones {
    private int single = 0;
    private int bound = 0;

    BoundedSemaphones(int bound) {
        this.bound = bound;
    }

    public synchronized void take() throws InterruptedException {
        if (single == bound) wait();
        single += 1;
        notify();
    }

    public synchronized void release() throws InterruptedException {
        if (single == 0) wait();
        single--;
        notify();
    }
}
