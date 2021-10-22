package Oving9;

import java.util.Locale;
import java.util.Scanner;

public class Student {
    private final String name;
    private int nrOfTasks;

    public Student(String name, int nrOfTasks){
        this.name = name.toLowerCase(Locale.ROOT);
        this.nrOfTasks = nrOfTasks;
    }

    public int getNrOfTasks() {
        return nrOfTasks;
    }

    public String getName() {
        return name;
    }

    public void increaseNrOfTasks(int nrOfTasks) {
        this.nrOfTasks += nrOfTasks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", nrOfTasks=" + nrOfTasks +
                '}';
    }
}

class test {
    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        Student newStudent = new Student("Joakim",2);
        System.out.println(newStudent.getNrOfTasks());
        newStudent.increaseNrOfTasks(4);
        System.out.println(newStudent.getNrOfTasks());
    }
}
