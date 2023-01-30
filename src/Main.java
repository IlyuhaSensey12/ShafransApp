import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;
import java.util.ArrayList;

public class Main implements SayHello{
    PreparedStatement preparedStatement;
    public static Registration frame;
    public static MainMenu mainframe;

    public static Orders orderFrame;
    public static AdminClients adminClientsFrame;
    public static AdminMenu adminMenuFrame;

    public static Hot hotframe;
    public static Salads saladsframe;
    public static Drinks drinksframe;
    public static Delete deleteFrame;

    private static Connection connection;
    private static String url = "jdbc:mysql://localhost/Shafran?serverTimezone=Europe/Moscow&useSSL=false";
    private static String user = "root";
    private static String pass = "";

    public static void main(String[] args) throws IOException {

        try{
            ServerSocket serverSocket = new ServerSocket(1800);
            while(true)
            {
                System.out.println("Waiting orders");
                Socket socket = serverSocket.accept();
                System.out.println("Order is connected");

                ServerThread st = new ServerThread(socket);
                st.start();
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        frame = new Registration();
        frame.setVisible(true);
        Con();//conections

        mainframe = new MainMenu();
        mainframe.setVisible(false);

        orderFrame = new Orders();
        orderFrame.setVisible(false);

        adminClientsFrame = new AdminClients();
        adminClientsFrame.setVisible(false);

        adminMenuFrame = new AdminMenu();
        adminMenuFrame.setVisible(false);

        hotframe = new Hot();
        hotframe.setVisible(false);

        saladsframe = new Salads();
        saladsframe.setVisible(false);

        drinksframe = new Drinks();
        drinksframe.setVisible(false);

        deleteFrame = new Delete();
        deleteFrame.setVisible(false);
    }////main

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

    @Override
    public void SayHello1() {
        System.out.println("Connected");
    }
}///Main
