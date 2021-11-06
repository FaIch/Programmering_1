import java.util.ArrayList;
import java.util.Scanner;

public class TestClient {
    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        MenuLibrary regMenu = new MenuLibrary();
        ArrayList<Dish> dishes1 = new ArrayList<Dish>();
        ArrayList<Dish> dishes2 = new ArrayList<Dish>();

        regMenu.newDish("Alfredo", "Hovedrett",149,"Kremet pasta");
        regMenu.newDish("Bolognese", "Hovedrett", 129, "Rødsaus pasta");
        regMenu.newDish("Bruschetta", "Forrett", 79, "Brød med tomat");
        regMenu.newDish("Panna cotta", "Dessert", 99, "Italiensk dessert");

        System.out.println(regMenu.getDishByName("Alfredo"));
        System.out.println("");
        System.out.println(regMenu.getDishByType("Forrett"));


        ArrayList<Dish> newDish1 = regMenu.getDishByName("Bruschetta");
        ArrayList<Dish> newDish2 = regMenu.getDishByName("Bolognese");
        ArrayList<Dish> newDish3 = regMenu.getDishByName("Panna cotta");
        dishes1.add(newDish1.get(0));
        dishes1.add(newDish2.get(0));
        dishes1.add(newDish3.get(0));
        regMenu.regMenu(dishes1);

        while (true) {
            System.out.println("Skriv rett for å legge inn i meny");
            String name = in.nextLine();
            ArrayList<Dish> userDish = regMenu.getDishByName(name);
            if (userDish.size() > 0) {
                dishes2.add(userDish.get(0));
            }
            if (name.equals("1")){
                break;
            }
        }
        regMenu.regMenu(dishes2);

        ArrayList<Menu> menus = regMenu.findMenus(0,400);
        for (int i = 0; i < menus.size(); i ++){
            System.out.println(menus.get(i).toString());
        }

    }
}
