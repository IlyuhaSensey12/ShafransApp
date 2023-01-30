public class Menu {
    private int food_id;
    private String food_Name;
    private String food_Price;
    private String type;

    public Menu(int food_id, String food_Name, String food_Price, String type) {
        this.food_id = food_id;
        this.food_Name = food_Name;
        this.food_Price = food_Price;
        this.type = type;
    }

    public int getFood_id() {
        return food_id;
    }

    public void setFood_id(int food_id) {
        this.food_id = food_id;
    }

    public String getFood_Name() {
        return food_Name;
    }

    public void setFood_Name(String food_Name) {
        this.food_Name = food_Name;
    }

    public String getFood_Price() {
        return food_Price;
    }

    public void setFood_Price(String food_Price) {
        this.food_Price = food_Price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return food_id + "," + food_Name + "," + food_Price + "," + type;
    }
}
