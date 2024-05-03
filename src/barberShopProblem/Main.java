package barberShopProblem;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Customer[] customers = new Customer[Constants.NUMBER_OF_CUSTOMER];

        Barber barber = new Barber();

        for (int i = 0; i < Constants.NUMBER_OF_CUSTOMER; i++) {
            customers[i] = new Customer(i, barber);

        }

        for (int i = 0; i < Constants.NUMBER_OF_CUSTOMER; i++) {
            customers[i].start();
        }
    }
}
