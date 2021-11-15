package Oving11;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    PropertyRegister reg = new PropertyRegister();
    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        Client c = new Client();
        c.start();
    }
    /**
            * Starts the application. This is the main loop of the application,
    * presenting the menu, retrieving the selected menu choice from the user,
    * and executing the selected functionality.
    */
    public void start() {
        reg.newProperty(1445, "Gloppen", 77, 631, "", 1017.6,"Jens Olsen");
        reg.newProperty(1445, "Gloppen", 77, 131, "Syningom", 661.3,"Nicolay Madsen");
        reg.newProperty(1445, "Gloppen", 75, 19, "Fugletun", 650.6,"Evilyn Jensen");
        reg.newProperty(1445, "Gloppen", 74, 188, "", 1457.2,"Karl Ove Bråten");
        reg.newProperty(1445, "Gloppen", 69, 47, "Høiberg", 1339.4,"Elsa Indregård");
        final int ADD_PROPERTY = 1;
        final int LIST_ALL_PROPERTIES = 2;
        final int FIND_PROPERTY = 3;
        final int CALCULATE_AVERAGE_AREA = 4;
        final int DELETE_PROPERTY = 5;
        final int LIST_BY_LOT_NUMBER = 6;
        final int CHANGE_LOT_NAME = 7;
        final int CHANGE_LOT_AREA = 8;
        final int CHANGE_OWNER = 9;
        final int EXIT = 10;
        boolean finished = false;
    // The while-loop will run as long as the user has not selected
    // to quit the application
        while (!finished) {
            int menuChoice = this.showMenu();
            switch (menuChoice) {
                case ADD_PROPERTY -> addProperty();
                case LIST_ALL_PROPERTIES -> printAll();
                case FIND_PROPERTY -> findProperty();
                case CALCULATE_AVERAGE_AREA -> calcAverageArea();
                case DELETE_PROPERTY -> deleteProperty();
                case LIST_BY_LOT_NUMBER -> listByLotNumber();
                case CHANGE_LOT_NAME -> changeLotName();
                case CHANGE_LOT_AREA -> changeArea();
                case CHANGE_OWNER -> changeOwner();
                case EXIT -> {
                    System.out.println("Thank you for using the Properties app!\n");
                    finished = true;
                }
                default -> System.out.println("Unrecognized menu selected..");
            }
        }
    }
    /**
     * Presents the menu for the user, and awaits input from the user. The menu
     * choice selected by the user is being returned.
     *
     * @return the menu choice by the user as a positive number starting from 1.
     * If 0 is returned, the user has entered a wrong value
     */
    private int showMenu()
    {
        int menuChoice = 0;
        System.out.println("\n***** Property Register Application v0.1 *****\n");
        System.out.println("1. Add property");
        System.out.println("2. List all properties");
        System.out.println("3. Search for a property");
        System.out.println("4. Calculate average area");
        System.out.println("5. Delete a property");
        System.out.println("6. Find all properties by lot number");
        System.out.println("7. Change lot name");
        System.out.println("8. Change lot area");
        System.out.println("9. Change lot owner");
        System.out.println("10. Quit");
        System.out.println("\nPlease enter a number between 1 and 9.\n");
        if (in.hasNextInt()) {
            menuChoice = in.nextInt();
        } else {
            System.out.println("You must enter a number, not text");
        }
        return menuChoice;
    }

    /**
     * Method for adding a property to the list, takes input from user, and if it does not catch an illegal arguement. it adds it to the list.
     */
    public void addProperty(){
        System.out.println("Municipality number: "); int municipalityNumber = in.nextInt();
        in.nextLine();
        System.out.println("Municipality name: "); String municipalityName = in.nextLine();
        System.out.println("Lot number: "); int lotNumber = in.nextInt();
        System.out.println("Section number: "); int sectionNumber = in.nextInt();
        in.nextLine();
        System.out.println("Lot name: "); String lotName = in.nextLine();
        System.out.println("Area of property: "); double area = in.nextDouble();
        in.nextLine();
        System.out.println("Name of owner: "); String nameOfOwner = in.nextLine();
        System.out.println(" ");
        try {
            reg.newProperty(municipalityNumber,municipalityName,lotNumber,sectionNumber,lotName,area,nameOfOwner);
        }catch (IllegalArgumentException e){
            System.out.println("Only positive numbers accepted, property not registered.");
        }
    }

    /**
     * Universal method for printing out properties, uses toString from the property class. And prints out all objects in the list
     * @param list an arraylist must be a parameter when calling this method. It uses this list and the toString, to print.
     *             If the given list is empty, it prints out "No properties found"
     */
    public void printProperties(ArrayList<Property> list){
        if (list.size() > 0){
            for (Property property : list) {
                System.out.println(property.toString());
            }
        }
        else {
            System.out.println("No properties found.");
        }
    }

    /**
     * Method for printing out all properties in the list, not given any parameters.
     */
    public void printAll(){
        printProperties(reg.getProperties());
    }

    /**
     * Finds property based on the input from user, the method getPropertyByNumbers returns an arraylist, so calling the
     * printProperties method here will print out all properties with the same property number as given by the user.
     */
    public void findProperty(){
        System.out.println("Municipality number: "); int municipalityNumber = in.nextInt();
        System.out.println("Lot number: "); int lotNumber = in.nextInt();
        System.out.println("Section number: "); int sectionNumber = in.nextInt();
        try {
            printProperties(reg.getPropertyByNumbers(municipalityNumber,lotNumber,sectionNumber));
        }catch (IllegalArgumentException e){
            System.out.println("Only positive numbers accepted");
        }

    }

    /**
     * Calculates the average area of all properties in the list. Given that the list has any objects.
     */
    public void calcAverageArea(){
        if (reg.getNumberOfProperties() == 0){
            System.out.println("There are no properties in the library. Please register a new property.");
        }
        else {
            System.out.println(reg.getAverageArea());
        }
    }

    /**
     * Deletes a property if the numbers are matching with an existing object of property.
     */
    public void deleteProperty(){
        System.out.println("Municipality number: "); int municipalityNumber = in.nextInt();
        System.out.println("Lot number: "); int lotNumber = in.nextInt();
        System.out.println("Section number: "); int sectionNumber = in.nextInt();
        try {
            reg.deleteProperty(municipalityNumber, lotNumber, sectionNumber);
        }catch (IllegalArgumentException e){
            System.out.println("Only positive numbers accepted, property was not deleted.");
        }
        if (!reg.deleteProperty(municipalityNumber, lotNumber, sectionNumber)){
            System.out.println("Property was deleted");
        }
        else{
            System.out.println("Property with given numbers, was not found.");
        }
    }

    /**
     * Creates a list based on lot number input from user, uses the printProperties method to print the properties
     * that are in the list.
     */
    public void listByLotNumber(){
        System.out.println("Lot number: "); int lotNumber = in.nextInt();
        try {
            printProperties(reg.getPropertiesByLotNumber(lotNumber));
        }catch (IllegalArgumentException e){
            System.out.println("Only positive numbers accepted.");
        }
    }

    /**
     * Lets the user change the name of a lot.
     */
    public void changeLotName(){
        System.out.println("Municipality number: "); int municipalityNumber = in.nextInt();
        System.out.println("Lot number: "); int lotNumber = in.nextInt();
        System.out.println("Section number: "); int sectionNumber = in.nextInt();
        in.nextLine();
        System.out.println("New lot name:"); String newLotName = in.nextLine();

        try {
            reg.setLotName(municipalityNumber, lotNumber, sectionNumber, newLotName);
        }catch (IllegalArgumentException e){
            System.out.println("Only positive numbers accepted, the name was not changed.");
        }
        if (!reg.setLotName(municipalityNumber, lotNumber, sectionNumber, newLotName)){
            System.out.println("Lot name changed.");
        }
        else {
            System.out.println("Lot with given numbers not found.");
        }
    }

    /**
     * Changes the area of given lot, if lot not found, user is noted
     */
    public void changeArea(){
        System.out.println("Municipality number: "); int municipalityNumber = in.nextInt();
        System.out.println("Lot number: "); int lotNumber = in.nextInt();
        System.out.println("Section number: "); int sectionNumber = in.nextInt();
        System.out.println("New lot area:"); double newLotArea = in.nextDouble();

        try {
            reg.setLotArea(municipalityNumber, lotNumber, sectionNumber, newLotArea);
        }catch (IllegalArgumentException e){
            System.out.println("Only positive numbers accepted, the name was not changed.");
        }
        if (!reg.setLotArea(municipalityNumber, lotNumber, sectionNumber, newLotArea)){
            System.out.println("Lot name changed.");
        }
        else {
            System.out.println("Lot with given numbers not found.");
        }
    }

    /**
     * Changes owner of lot
     */
    public void changeOwner(){
        System.out.println("Municipality number: "); int municipalityNumber = in.nextInt();
        System.out.println("Lot number: "); int lotNumber = in.nextInt();
        System.out.println("Section number: "); int sectionNumber = in.nextInt();
        in.nextLine();
        System.out.println("New owner name:"); String newOwner = in.nextLine();

        try {
            reg.setOwner(municipalityNumber, lotNumber, sectionNumber, newOwner);
        }catch (IllegalArgumentException e){
            System.out.println("Only positive numbers accepted, the name was not changed.");
        }
        if (!reg.setOwner(municipalityNumber, lotNumber, sectionNumber, newOwner)){
            System.out.println("Owner changed.");
        }
        else {
            System.out.println("Lot with given numbers not found.");
        }
    }

}
