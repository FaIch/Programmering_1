import java.util.*;
class Klient{
    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Skriv inn fornavn: ");
        String firstName = in.nextLine();

        System.out.print("Skriv inn etternavn: ");
        String lastName = in.nextLine();

        System.out.print("Skriv inn fødselsår: ");
        int birthyear = in.nextInt();

        Person person = new Person(firstName,lastName,birthyear);

        System.out.print("Skriv inn ansattnummer: ");
        long workNr = in.nextInt();

        System.out.print("Skriv inn ansettelsesår: ");
        int hiringYear = in.nextInt();

        System.out.print("Skriv inn månedslønn: ");
        long monthlySalary = in.nextLong();

        System.out.print("Skriv inn skatteprosent: ");
        float tax = in.nextFloat();

        ArbTaker arbTaker = new ArbTaker(person, workNr, hiringYear, monthlySalary, tax);
        printAll(arbTaker);

        while (true){
            System.out.println("");
            System.out.println("Skriv 1 for å endre månedslønn");
            System.out.println("Skriv 2 for å endre skatteprosent");
            System.out.println("Skriv 3 for å se om personen har jobbet mer enn x antall år");
            System.out.println("Skriv 4 for å skrive ut all informasjon");
            System.out.println("Skriv 5 for å avslutte menyen");
            int choice = in.nextInt();

            if (choice == 1){
                System.out.println("Tidligere månedslønn:" + arbTaker.getMonthlySalary());
                System.out.print("Skriv ny månedslønn: ");
                long newSalary = in.nextLong();
                arbTaker.setMonthlySalary(newSalary);
                System.out.println("Ny månedslønn er: " + arbTaker.getMonthlySalary());
            }

            else if (choice == 2){
                System.out.println("Tidligere skatteprosent: " + arbTaker.getTax());
                System.out.print("Skriv ny skatteprosent: ");
                float newTax = in.nextFloat();
                arbTaker.setTax(newTax);
                System.out.println("Ny skatteprosent er: " + arbTaker.getTax());
            }

            else if(choice == 3){
                System.out.println("Gi antall år du lurer på om personen har jobbet mer eller mindre enn: ");
                int numYears = in.nextInt();
                System.out.println("Har personen jobbet mer enn " + numYears + " år? " + arbTaker.getMorethan(numYears));
            }

            else if (choice == 4){
                printAll(arbTaker);
            }
            else if (choice == 5){
                break;
            }
            else{
                System.out.println("Vennligst velg et tall mellom 1-5");
            }
        }
    }

    public static void printAll(ArbTaker arbTaker) {
        System.out.println("");
        System.out.println("Navn: " + arbTaker.getName());
        System.out.println("Alder: " + arbTaker.getAge());
        System.out.println("Ansattnummer: " + arbTaker.getworkNr());
        System.out.println("Skatt per måned: " + arbTaker.getTaxPerMonth());
        System.out.println("Skatt per år: " + arbTaker.getYearlyTax());
        System.out.println("Bruttolønn per år: " + arbTaker.getgrossYearlyIncome());
        System.out.println("År ansatt: " + arbTaker.getHiringYear());
    }


}
