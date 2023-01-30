import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBManager {

    private static Connection connection;
    private static String url = "jdbc:mysql://localhost/Shafran?serverTimezone=Europe/Moscow&useSSL=false";
    private static String user = "root";
    private static String pass = "";

    public static Connection Con()
    {
        try
        {
            connection = DriverManager.getConnection(url,user,pass);
            System.out.println("Connection");
            return connection;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public void addOrder(Order order){
        try{
            PreparedStatement statement = connection.prepareStatement("" + "INSERT INTO Order (id, Client_name, Menu,Price,Adress)" + "VALUES (Null,?,?,?,?)");

            statement.setString(1,order.getClient_name());
            statement.setString(2,order.getMenu());
            statement.setInt(3,order.getPrice());
            statement.setString(4,order.getAdress());
            statement.executeUpdate();

            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<Order> getAllOrders(){
        ArrayList<Order> orderList = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Order");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                Integer id = resultSet.getInt("Id");
                String Client_name = resultSet.getString("Client_name");
                String Menu = resultSet.getString("Menu");
                Integer Price = resultSet.getInt("Price");
                String Adress = resultSet.getString("Adress");

                orderList.add(new Order(id,Client_name,Menu,Price,Adress));
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return orderList;
    }
}
