package barberShopProblem;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Barber {
    Semaphore chairs = new Semaphore(Constants.NUMBER_OF_CHAIRS);
    AtomicBoolean isBarberFree = new AtomicBoolean(true);
    private Lock lock = new ReentrantLock();

    public boolean sleep() throws InterruptedException {
        if (chairs.availablePermits() == Constants.NUMBER_OF_CHAIRS) {
            System.out.println("Barber is sleeping ");
            return true;
        }
        return false;
    }

    public void wakedUp(int id) throws InterruptedException {
        lock.lock();
        System.out.println("Barber is wakeup by customer %d " + id);
    }

    public void busyWithHaircut(int id) throws InterruptedException {
        isBarberFree.set(false);
        chairs.acquire();
        System.out.println("Barber is busy cutting for customer %d  " + id);
    }

    public void doneWithHairut(int id) {
        chairs.release();
        System.out.println("Barber is done cutting hair for customer %d  " + id);
        isBarberFree.set(true);
        lock.unlock();
    }
}
