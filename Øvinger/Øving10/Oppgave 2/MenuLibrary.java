import java.util.ArrayList;

public class MenuLibrary {
    private ArrayList<Menu> menus;
    private ArrayList<Dish> dishes;

    public MenuLibrary(){
        menus = new ArrayList<Menu>();
        dishes = new ArrayList<Dish>();
    }

    public ArrayList<Dish> getDishes() {
        return dishes;
    }

    public ArrayList<Menu> getMenus() {
        return menus;
    }

    public void newDish(String name, String type, float price, String recipe){
        Dish newDish = new Dish(name, type, price, recipe);
        dishes.add(newDish);
    }

    public ArrayList<Dish> getDishByName(String name){
        ArrayList<Dish> nameList = new ArrayList<Dish>();
        for (int i = 0; i < getDishes().size(); i++){
            if (getDishes().get(i).getName().equalsIgnoreCase(name)){
                 nameList.add(getDishes().get(i));
            }
        }
        return nameList;
    }


    public String getDishByType(String type){
        String text = "";
        for (int i = 0; i < dishes.size(); i++){
            if (dishes.get(i).getType().toLowerCase().equals(type.toLowerCase())){
                text += dishes.get(i).toString() + "\n";
            }
        }
        return text;
    }

    public void regMenu(ArrayList<Dish> menuDish){
        Menu newMenu = new Menu(menuDish);
        getMenus().add(newMenu);
    }

    public ArrayList<Menu> findMenus(float from, float to){
        ArrayList<Menu> menuList = new ArrayList<Menu>();

        for (int i = 0; i < getMenus().size(); i++){
            if (getMenus().get(i).totalPrice() >= from && getMenus().get(i).totalPrice() <= to){
                menuList.add(getMenus().get(i));
            }
        }
        return menuList;
    }
}
