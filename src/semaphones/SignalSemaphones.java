package semaphones;

public class SignalSemaphones {

    private boolean signal;

    //this used to send the signal
    public synchronized void take(){
        signal = true;
        notify();
    }

    //this is used to receive the signal
    public synchronized void release() throws InterruptedException {
        while (!signal);{
            wait();
        }
        signal = false;
    }
}
