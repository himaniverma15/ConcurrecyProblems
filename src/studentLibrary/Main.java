package studentLibrary;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(Constants.NUMBER_OF_STUDENTS);
        Student[] students = new Student[Constants.NUMBER_OF_STUDENTS];
        Book[] books = new Book[Constants.NUMBER_OF_BOOKS];
        try {
            for (int i = 0; i < books.length; i++) {
                books[i] = new Book(i);
            }

            for (int i = 0; i < students.length; i++) {
                students[i] = new Student(i, books[(i + 1) % books.length]);
                executorService.execute(students[i]);
            }
            Thread.sleep(Constants.SIMULATION_RUNNING_TIME);

            for (Student student : students) student.setDoneWithReading(true);
        } finally {
            executorService.shutdown();

            while (!executorService.isTerminated()) Thread.sleep(1000);

            for (Student student : students) {
                System.out.println(student.getId() + " read #" + student.getNumberOfTimesReadBook() + "times !");
            }
        }
    }
}
