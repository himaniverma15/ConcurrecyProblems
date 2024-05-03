package diningPhilosophers;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Chopsticks {
    private int id;
    private Lock lock;

    Chopsticks(int id) {
        this.id = id;
        lock = new ReentrantLock();
    }

    public boolean pickUp(Philosophers philosophers, State state) throws InterruptedException {
        // this is where we simulate deadlock
        if (lock.tryLock(10, TimeUnit.MILLISECONDS)) {
            System.out.println(philosophers + " picked up " + state.toString() + " " + this);
            return true;
        }
        return false;
    }

    public void putDown(Philosophers philosophers, State right) {
        lock.unlock();
        System.out.println(philosophers + " put down " + this);
    }

    @Override
    public String toString() {
        return "Chopsticks" + id;
    }
}
