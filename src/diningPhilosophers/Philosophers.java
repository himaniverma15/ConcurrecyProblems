package diningPhilosophers;

import java.util.Random;

public class Philosophers implements Runnable {

    private int id;
    private volatile boolean full;
    private Chopsticks leftChopstick;
    private Chopsticks rightChopstick;
    private Random random;
    private int eatCounter;

    public Philosophers(int id, Chopsticks leftChopstick, Chopsticks rightChopstick) {
        this.id = id;
        this.leftChopstick = leftChopstick;
        this.rightChopstick = rightChopstick;
        this.random = new Random();
    }

    @Override
    public void run() {
        while (!full) {
            try {
                if (leftChopstick.pickUp(this, State.LEFT)) {
                    if (rightChopstick.pickUp(this, State.RIGHT)) {
                        think();
                        eat();
                        rightChopstick.putDown(this, State.RIGHT);
                    }
                    leftChopstick.putDown(this, State.LEFT);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void think() throws InterruptedException {
        System.out.println(this + " is thinking ");
        //philosophers thinks for the random time
        Thread.sleep(random.nextInt(1000));
    }

    private void eat() throws InterruptedException {
        eatCounter++;
        System.out.println(this + " is eating ");
        //philosophers eat for the random time
        Thread.sleep(random.nextInt(1000));
    }

    public int getEatCounter() {
        return eatCounter;
    }

    public void setFull(boolean full) {
        this.full = full;
    }

    public boolean isFull() {
        return full;
    }


    @Override
    public String toString() {
        return "Philosophers" + id;
    }
}
