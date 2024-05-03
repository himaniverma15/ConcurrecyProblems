package lock;

import java.util.HashMap;
import java.util.Map;

public class WriteReentrance {
    int writer = 0;
    int writeRequest = 0;
    Map<Thread, Integer> readingThreads = new HashMap<>();
    Thread writerThread = null;

    public synchronized void acquireWriteLock() throws InterruptedException {
        Thread callingThread = Thread.currentThread();
        writeRequest++;
        while (canGrantWriteAccess(callingThread)) {
            wait();
        }
        writeRequest--;
        writer++;
        writerThread = callingThread;
    }

    public synchronized void releaseWriteLock() {
        writer--;
        if (writer == 0) {
            writerThread = null;
        }
        notifyAll();
    }

    public boolean canGrantWriteAccess(Thread callingThread) {
        if (readingThreads.size() > 0) return false;
        if (writerThread == null) return true;
        if (isWriter(callingThread)) return true;
        return true;
    }

    private boolean isWriter(Thread callingThread) {
        if (callingThread == writerThread) return true;
        else return false;
    }
}
