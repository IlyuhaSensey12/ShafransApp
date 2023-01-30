import javax.swing.*;
import java.io.*;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

public class ClientApp extends JFrame implements Serializable {
//    public static ClientBasket clientBasketframe;
    public static ClientReg clientRegframe;
    public static ClientMainMenu clientMainframe;
//    public static ClientOrder clientOrder;
//    public static ClientHot clientHot;
//    public static ClientDrinks clientDrinks;
//    public static ClientSalads clientSalads;

    public static void connect(PackageData pd){
      try{
          Socket socket = new Socket("127.0.0.1", 1800);
          ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
          ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

          if(pd.getOperationType().equals("ADD")){
              outputStream.writeObject(pd);
          }
          else if(pd.getOperationType().equals("LIST")){
              outputStream.writeObject(pd);
              PackageData infoFromServer = (PackageData)inputStream.readObject();
              ArrayList<Order> arrayListFromServer = infoFromServer.getOrders();
              String s = "";

              for(int i=0; i < arrayListFromServer.size();i++){
                  s+=arrayListFromServer.get(i) + "\n";
              }
              ClientMainMenu.text.append(s);
          }
          inputStream.close();
          outputStream.close();
          socket.close();

      }catch (Exception e){
          e.printStackTrace();
      }
    }

    private static Connection connection;
    private static String url = "jdbc:mysql://localhost/Shafran?serverTimezone=Europe/Moscow&useSSL=false";
    private static String user = "root";
    private static String pass = "";

    public static void main(String[] args) throws IOException {

        clientRegframe = new ClientReg();
        clientRegframe.setVisible(true);

        clientMainframe = new ClientMainMenu();
        clientMainframe.setVisible(false);
        Con();

//        clientBasketframe = new ClientBasket();
//        clientBasketframe.setVisible(false);
//
//        clientDrinks = new ClientDrinks();
//        clientDrinks.setVisible(false);
//
//        clientOrder = new ClientOrder();
//        clientOrder.setVisible(false);
//
//        clientHot = new ClientHot();
//        clientHot.setVisible(false);
//
//        clientSalads = new ClientSalads();
//        clientSalads.setVisible(false);


    }
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
}
