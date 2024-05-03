package barberShopProblem;

import java.util.concurrent.atomic.AtomicBoolean;

public class Customer extends Thread {
    private int id;

    private Barber barber;

    AtomicBoolean isHairCutDone = new AtomicBoolean(false);

    public Customer(int id, Barber barber) {
        this.id = id;
        this.barber = barber;
    }

    public void leave() {
        if (barber.chairs.availablePermits() > Constants.NUMBER_OF_CHAIRS)
            System.out.println("customer %d left the shop " + this.id);
    }

    public void sits() {
        System.out.println("customer %d waiting for the barber to be free " + this.id);
    }

    public void wakeUp() throws InterruptedException {
        if (barber.sleep()) {
            barber.wakedUp(this.id);
        }
    }

    public void haircut() throws InterruptedException {
        barber.busyWithHaircut(this.id);
    }

    public void haircutDone() {
        isHairCutDone.set(true);
        barber.doneWithHairut(this.id);
    }

    @Override
    public void run() {
        while (!isHairCutDone.get()) {
            try {
                if (barber.sleep()) {
                    wakeUp();
                    haircut();
                    haircutDone();
                }
                if (barber.isBarberFree.get() && !barber.sleep()) {
                    haircut();
                    haircutDone();
                }
                if (barber.chairs.availablePermits() <= Constants.NUMBER_OF_CHAIRS &&
                        !barber.isBarberFree.get()) {
                    sits();
                }
                if (barber.chairs.availablePermits() > Constants.NUMBER_OF_CHAIRS) {
                    leave();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
