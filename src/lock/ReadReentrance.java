package lock;

import java.util.HashMap;
import java.util.Map;

public class ReadReentrance {
    int reader = 0;
    int writer = 0;
    int writeRequest = 0;
    Map<Thread, Integer> readingThreads = new HashMap<>();

    public synchronized void acquireReadLock() throws InterruptedException {
        Thread callingThread = Thread.currentThread();
        while (!canGrantReadAccess(callingThread)) {
            wait();
        }
        readingThreads.put(callingThread, getReadCount(callingThread) + 1);
    }

    public synchronized void releaseReadLock() {
        Thread callingThread = Thread.currentThread();
        if (isReader(callingThread)) {
            int count = getReadCount(callingThread);
            if (count == 1) readingThreads.remove(callingThread);
            else readingThreads.put(callingThread, count-1);
            notifyAll();
        }
    }

    public boolean canGrantReadAccess(Thread callingThread) {
        if (writer > 0) return false;
        if (writeRequest > 0) return false;
        if (isReader(callingThread)) return true;
        return true;
    }

    private boolean isReader(Thread callingThread) {
        if (readingThreads.get(callingThread) != null) return true;
        return false;
    }

    private int getReadCount(Thread callingThread) {
        int count = readingThreads.get(callingThread);
        if (count == 0) return 0;
        else return count;
    }
}
