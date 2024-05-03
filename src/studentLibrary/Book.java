package studentLibrary;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Book {
    private int id;
    private Lock lock;

    public Book(int id) {
        this.id = id;
        this.lock = new ReentrantLock();
    }

    public boolean readBook(Student student) throws InterruptedException {
        if (lock.tryLock(10, TimeUnit.MILLISECONDS)) {
            System.out.println("student " + student.getId() + " took book from library with  book " + id);
            return true;
        }
        return false;
    }

    public void returnBook(Student student) {
        System.out.println("student " + student.getId() +" return book to the library with book : " + id);
        lock.unlock();
    }
}
