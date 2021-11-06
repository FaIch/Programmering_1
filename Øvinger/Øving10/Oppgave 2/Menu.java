import java.util.ArrayList;

public class Menu {
    private ArrayList<Dish> menu;

    public Menu(ArrayList<Dish> menu){
        this.menu = menu;
    }

    public ArrayList<Dish> getMenu(){
        return menu;
    }

    public float totalPrice(){
        int price = 0;
        for (int i = 0; i < menu.size(); i++){
            price += getMenu().get(i).getPrice();
        }
        return price;
    }

    public String toString(){
        String menu ="";
        for (int i = 0; i < getMenu().size(); i++){
            menu += getMenu().get(i).toString() +", ";
        }
        menu += "\n" + "Totalpris: " + totalPrice();
        return menu;
    }
}
