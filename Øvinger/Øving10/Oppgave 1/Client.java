package Oving10.Oppgave1;

import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    EventLibrary reg = new EventLibrary();
    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        Client c = new Client();
        while (true){
            c.showMenu();
        }
    }
    public void showMenu(){
        while (true) {
            System.out.println("");
            System.out.println("");
            System.out.println("Hva ønsker du å gjøre?");
            System.out.println("Skriv 1 for å registrere ett nytt arrangement");
            System.out.println("Skriv 2 for å finne alle arrangementer på gitt sted");
            System.out.println("Skriv 3 for å finne alle arrangementer på gitt tid");
            System.out.println("Skriv 4 for å finne alle arrangementer innefor et gitt tidsintervall");
            System.out.println("Skriv 5 for å lage lister over arrangementene, sortert på sted, type eller tidspunkt");
            int input = in.nextInt();

            switch (input) {
                case 1 -> makeEvent();
                case 2 -> findPlace();
                case 3 -> findDate();
                case 4 -> findFromTo();
                case 5 -> sortedLists();
            }

        }
    }

    public void printEvents(ArrayList<Event> list){
        System.out.println("");
        if (list.size() > 0){
            for (int i = 0; i < list.size(); i++){
                System.out.println(list.get(i).toString());
            }
        }
        else {
            System.out.println("Ingen arrangementer funnet.");
        }
    }

    public void makeEvent(){
        in.nextLine();
        System.out.println("Navn på arrangement: "); String name = in.nextLine();
        System.out.println("Sted: "); String place = in.nextLine();
        System.out.println("Arrangør: "); String host = in.nextLine();
        System.out.println("Type arrangement: "); String type = in.nextLine();
        System.out.println("Tidspunkt på format (YYYYMMDDTTMM)"); long date = in.nextLong();
        reg.newEvent(name,place,host,type,date);
    }

    public void findPlace(){
        in.nextLine();
        System.out.println("Sted: "); String place = in.nextLine();
        printEvents(reg.getPlaceEvents(place));
    }

    public void findDate(){
        System.out.println("Dato(YYYYMMDDTTMM): "); long date = in.nextLong();
        printEvents(reg.getTimeEvents(date));
    }

    public void findFromTo(){
       System.out.println("Fra(YYYYMMDDTTMM): "); long from = in.nextLong();
       System.out.println("Til(YYYYMMDDTTMM): "); long to = in.nextLong();
       printEvents(reg.getTimeToTimeEvents(from, to));
    }

     public void sortedLists() {
         System.out.println("");
         System.out.println("Skriv 1 for å sortere arrangementene etter sted");
         System.out.println("Skriv 2 for å sortere arrangementene etter type");
         System.out.println("Skriv 3 for å sortere arrangementene etter tidspunkt");
         int input = in.nextInt();
         while (true) {
             if (input == 1) {
                 printEvents(reg.listSortedByPlace());
                 break;
             } else if (input == 2) {
                 printEvents(reg.listSortedByType());
                 break;
             } else if (input == 3) {
                 printEvents(reg.listSortedByDate());
                 break;
             } else {
                 System.out.println("Skriv inn et tall mellom 1-3");
             }
         }
     }
}
