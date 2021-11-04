package Oving9.arraylist;
import Oving9.Student;
import java.util.ArrayList;

public class ViewTasksList {
    private ArrayList<Student> students;
    private int numberOfStudents = 0;

    public ViewTasksList(){
        students = new ArrayList<Student>();
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public int getNumberOfTasks(String name){
        String studentName = name.toLowerCase();
        int tasks = 0;
        if (nameTest(name)) {
            for (int i = 0; i < numberOfStudents; i++) {
                if (students.get(i).getName().equals(studentName)) {
                    tasks = students.get(i).getNrOfTasks();
                }
            }
        }
        else{
            System.out.println("Navnet eksisterer ikke i biblioteket. Tast 1 for å se studenter i biblioteket.");
        }
        return tasks;
    }

    public void increaseTasks(String name, int number){
        String studentName = name.toLowerCase();
        if (nameTest(name)) {
            for (int i = 0; i < getNumberOfStudents(); i++) {
                if (students.get(i).getName().equals(studentName)) {
                    students.get(i).increaseNrOfTasks(number);
                }
            }
        }
        else{
            System.out.println("Navnet eksisterer ikke i biblioteket. Tast 1 for å se studenter i biblioteket. ");
        }
    }

    public void newStudent(String name, int numTasks){
        if (!nameTest(name)){
            Student newStudent = new Student(name,numTasks);
            students.add(newStudent);
        }
        else{
            System.out.println("Navn er i bruk, vennligst bruk et annet navn.");
        }
        numberOfStudents ++;
    }

    public boolean nameTest(String name){
        String studentName = name.toLowerCase();
        boolean nameExists = false;

        for (int i = 0; i < getNumberOfStudents(); i++){
            if (students.get(i).getName().equals(studentName)){
                nameExists = true;
            }
        }
        return nameExists;
    }

    @Override
    public String toString() {
        String text = "";
        if (numberOfStudents == 0){
            return "Det er ingen studenter registrert i biblioteket enda. Tast 2 for å registrere ny student";
        }
        else {
            for (int i = 0; i < numberOfStudents; i++) {
                text += students.get(i).getName();
                text += " har gjort " + students.get(i).getNrOfTasks() + " oppgaver. \n";
            }
        }
        return text;
    }
}
