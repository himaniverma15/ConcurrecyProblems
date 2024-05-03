package studentLibrary;

import java.util.concurrent.atomic.AtomicBoolean;

public class Student implements Runnable {
    private int id;
    private Book book;
    private AtomicBoolean isDoneWithReading = new AtomicBoolean(false);
    private int numberOfTimesReadBook;

    public Student(int id, Book book) {
        this.id = id;
        this.book = book;
    }

    @Override
    public void run() {
        try {
            while (!isDoneWithReading.get()) {
                numberOfTimesReadBook++;
                book.readBook(this);
                book.returnBook(this);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void setDoneWithReading(boolean doneWithReading) {
        isDoneWithReading.set(doneWithReading);
    }

    public int getNumberOfTimesReadBook() {
        return numberOfTimesReadBook;
    }

    public int getId() {
        return id;
    }
}
