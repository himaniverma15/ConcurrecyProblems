package lock;

import lock.ReadWriteLock;

public class Main {

    public static void main(String[] args) {

        Thread1 t1 = new Thread1();
        t1.setName("Thread1");
        t1.start();

        Thread2 t2 = new Thread2();
        t2.setName("Thread2");
        t2.start();
    }

    static class Thread1 extends Thread {
        @Override
        public void run() {

            ReadWriteLock readAndWriteLock = new ReadWriteLock();

            //read
            try {
                readAndWriteLock.acquireReadLock();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            //write
            try {
                readAndWriteLock.acquireWriteLock();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            //relase read
            readAndWriteLock.releaseReadLock();

            //write
            try {
                readAndWriteLock.acquireWriteLock();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            //release read
            readAndWriteLock.releaseReadLock();

            //realease erite
            readAndWriteLock.releaseWriteLock();

            //release read
            try {
                readAndWriteLock.acquireReadLock();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        }
    }

    static class Thread2 extends Thread {
        @Override
        public void run() {
            ReadWriteLock readAndWriteLock = new ReadWriteLock();

            //read
            try {
                readAndWriteLock.acquireReadLock();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            //write
            try {
                readAndWriteLock.acquireWriteLock();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            //relase read
            readAndWriteLock.releaseReadLock();

            //write
            try {
                readAndWriteLock.acquireWriteLock();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            //release read
            readAndWriteLock.releaseReadLock();

            //realease erite
            readAndWriteLock.releaseWriteLock();

            //release read
            try {
                readAndWriteLock.acquireReadLock();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
