package lock;

public class ReadWriteLock {
    int reader = 0;
    int writer = 0;
    int writeRequest = 0;

    public synchronized void acquireReadLock() throws InterruptedException {
        while (writer > 0 && writeRequest > 0) {
            System.out.println("can't acquire read lock " + Thread.currentThread().getName());
            wait();
        }
        System.out.println("acquired read lock by :" + Thread.currentThread().getName());
        reader++;
    }

    public synchronized void acquireWriteLock() throws InterruptedException {
        writeRequest++;
        while (writer > 0 || reader > 0) {
            System.out.println("can't acquire write lock " + Thread.currentThread().getName());
            wait();
        }
        writeRequest--;
        System.out.println("acquired write lock by :" + Thread.currentThread().getName());
        writer++;
    }

    public synchronized void releaseReadLock() {
        reader--;
        System.out.println("write lock release! :" + Thread.currentThread().getName());
        notifyAll();
    }

    public synchronized void releaseWriteLock() {
        writer--;
        System.out.println("read lock release! : " + Thread.currentThread().getName());
        notifyAll();
    }
}
