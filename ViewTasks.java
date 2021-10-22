package Oving9;

import java.util.Locale;

public class ViewTasks {
    private Student[] students;
    private int numberOfStudents = 0;

    public ViewTasks(){
        students = new Student[1];
    }

    public int getNrOfStudents() {
        return numberOfStudents;
    }

    public int getTasks(String name){
        String studentName = name.toLowerCase(Locale.ROOT);
        int tasks = 0;
        for (int i = 0; i < numberOfStudents; i++){
            if (studentName.equals(students[i].getName())){
                tasks = students[i].getNrOfTasks();
            }
        }
        return tasks;
    }

    public String newStudent(String name, int nrOfTasks){
        String studentName = name.toLowerCase(Locale.ROOT);
        if (!nameTest(studentName)){
            enlargeArray();
            students[numberOfStudents] = new Student(studentName,nrOfTasks);
            numberOfStudents ++;
            return "Registration completed";
        }
        return "Registration failed, name is already registered";
    }

    public void increaseTasks(String name, int number){
        String studentName = name.toLowerCase(Locale.ROOT);
        for (int i = 0; i < numberOfStudents; i++){
            if (students[i].getName().equals(studentName)){
                students[i].increaseNrOfTasks(number);
            }
        }
    }

    public void enlargeArray(){
        Student[] temporaryArray = new Student[numberOfStudents +1];

        for (int i = 0; i < numberOfStudents; i++){
            temporaryArray[i] = students[i];
        }
        students = temporaryArray;
    }

    public boolean nameTest(String name){
        for (int i = 0; i < numberOfStudents; i ++){
            if (name.equals(students[i].getName())) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "There are " + numberOfStudents + " students in this library";
    }
}