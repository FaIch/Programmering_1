package Oving9.arraylist;

import javax.swing.*;
import java.util.Scanner;

public class Klient {
    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        ViewTasksList reg = new ViewTasksList();

        while(true){
            System.out.println("");
            System.out.println("Hva ønsker du å gjøre?");
            System.out.println("Skriv 1 for å se studenter i registerert, med antall oppgaver gjennomført");
            System.out.println("Skriv 2 for å registrere ny student");
            System.out.println("Skriv 3 for å øke antall oppgaver på gitt student");
            System.out.println("Skriv 4 for å finne antall oppgaver på en gitt student");
            System.out.println("Skriv 5 for å finne antall registrerte studenter");
            System.out.println("Skriv 6 for å avslutte programmet");
            int input = in.nextInt();

            if (input == 1){
                System.out.println(reg);
            }
            else if (input == 2){
                String name = JOptionPane.showInputDialog("Skriv inn navn: ");

                int tasks = Integer.parseInt(JOptionPane.showInputDialog("Skriv inn antall oppgaver gjort:"));

                reg.newStudent(name, tasks);
            }

            else if (input == 3){
                String name = JOptionPane.showInputDialog("Skriv inn navn på student: ");

                int num = Integer.parseInt(JOptionPane.showInputDialog("Skriv inn antall oppgaver du vil øke med: "));

                reg.increaseTasks(name, num);
            }

            else if (input == 4){
                String name = JOptionPane.showInputDialog("Skriv inn navn på student: ");

                System.out.println(name + " har " + reg.getNumberOfTasks(name) + " utførte oppgaver.");
            }

            else if (input == 5){
                System.out.println("Det er " + reg.getNumberOfStudents() + " registrerte studenter.");
            }

            else if (input == 6){
                break;
            }
            else{
                System.out.println("Vennligst skriv ett tall mellom 1-6");
            }
        }
    }
}
