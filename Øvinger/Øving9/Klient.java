package Oving9;

import java.util.Scanner;
import javax.swing.JOptionPane;
class Klient{
    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        ViewTasks reg = new ViewTasks();

        String name1 = "Henrik";
        int nrOfTasks1 = 3;
        reg.newStudent(name1,nrOfTasks1);


        while(true){
            System.out.println("");
            System.out.println("Hva ønsker du å gjøre?");
            System.out.println("Skriv 1 for å registrere ny student");
            System.out.println("Skriv 2 for å øke antall oppgaver på gitt student");
            System.out.println("Skriv 3 for å finne antall oppgaver på en gitt student");
            System.out.println("Skriv 4 for å finne antall registrerte studenter");
            System.out.println("Skriv 5 for å avslutte programmet");
            int input = in.nextInt();

            if (input == 1){
                String name = JOptionPane.showInputDialog("Skriv inn navn: ");

                int tasks = Integer.parseInt(JOptionPane.showInputDialog("Skriv inn antall oppgaver gjort:"));

                System.out.println(reg.newStudent(name, tasks));
            }

            else if (input == 2){
                String name = JOptionPane.showInputDialog("Skriv inn navn på student: ");

                int num = Integer.parseInt(JOptionPane.showInputDialog("Skriv inn antall oppgaver du vil øke med: "));

                reg.increaseTasks(name, num);

                System.out.println(name + " har nå " + reg.getTasks(name) + " oppgaver fullført.");
            }

            else if (input == 3){
                String name = JOptionPane.showInputDialog("Skriv inn navn på student: ");

                System.out.println(name + " har " + reg.getTasks(name) + " utførte oppgaver.");
            }

            else if (input == 4){
                System.out.println("Det er " + reg.getNrOfStudents() + " registrerte studenter.");
            }

            else if (input == 5){
                break;
            }
            else{
                System.out.println("Vennligst skriv ett tall mellom 1-51");
            }
        }
    }
}
