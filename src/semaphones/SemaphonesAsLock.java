package semaphones;

public class SemaphonesAsLock {
    public static void main(String[] args) throws InterruptedException {
        BoundedSemaphones boundedSemaphones = new BoundedSemaphones(1);
        try {
            boundedSemaphones.take();
            int a = +1;
        } finally {
            boundedSemaphones.release();
        }
    }
}
