import java.io.Serializable;

public class Order implements Serializable {
    private int ID;
    private String Client_name;
    private String Menu;
    private int Price;
    private String Adress;

    public Order(int ID, String client_name, String menu, int price, String adress) {
        this.ID = ID;
        Client_name = client_name;
        Menu = menu;
        Price = price;
        Adress = adress;
    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getClient_name() {
        return Client_name;
    }

    public void setClient_name(String client_name) {
        Client_name = client_name;
    }

    public String getMenu() {
        return Menu;
    }

    public void setMenu(String menu) {
        Menu = menu;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public String getAdress() {
        return Adress;
    }

    public void setAdress(String adress) {
        Adress = adress;
    }

    @Override
    public String toString() {
        return "Order{" +
                "ID=" + ID +
                ", Client_name='" + Client_name + '\'' +
                ", Menu='" + Menu + '\'' +
                ", Price=" + Price +
                ", Adress='" + Adress + '\'' +
                '}';
    }
}
