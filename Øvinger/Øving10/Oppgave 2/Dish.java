public class Dish {
    private String name;
    private String type;
    private float price;
    private String recipe;

    public Dish(String name, String type, float price, String recipe){
        this.name = name;
        this.type = type;
        this.price = price;
        this.recipe = recipe;
    }

    public float getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getRecipe() {
        return recipe;
    }

    public String toString(){
        return "Type: " + this.type + ", navn: " + this.name + ", pris: " + this.price;
    }
}
