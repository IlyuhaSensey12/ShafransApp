import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Delete extends JFrame {
    static Connection connection = Main.Con();
    Statement statement;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    JButton delete = new JButton("Delete");
    JTextField deleteIndex = new JTextField();
    JButton back = new JButton("Back");
    static ArrayList<Menu> foods = getMenu();
    public static String text = foods.toString();
    static JTextArea menushow = new JTextArea(text);

    public Delete(){

       // ArrayList<Menu> foods = getMenu();
//        menushow = new JLabel(foods.toString());
        setSize(1000,800);
        setLayout(null);

        delete.setBounds(300,600,100,50);
        add(delete);

        deleteIndex.setBounds(400,600,100,50);
        add(deleteIndex);


        menushow.setBounds(0, 100, 1000,400);
        add(menushow);

        back.setBounds(30,30,100,50);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Main.adminMenuFrame.setVisible(true);
            }
        });

        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Index = deleteIndex.getText();
                deleteFood(Index);
                getMenu();
            }
        });



    }
    private static ArrayList<Menu> getMenu(){
        ArrayList<Menu> foods = new ArrayList<>();
        try{
            Statement statement = connection.createStatement();
            String query = "select * from Menu";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                int food_id = Integer.parseInt(resultSet.getString("foodId"));
                String foodName = resultSet.getString("foodName");
                String foodPrice = resultSet.getString("foodPrice" );
                String foodType = resultSet.getString("foodType");

                foods.add(new Menu(food_id,foodName,foodPrice,foodType));
            }
        }catch(Exception e){
           e.printStackTrace();
        }
        return foods;
    }

    private static void deleteFood(String Index){
        try{
            Statement statement = connection.createStatement();

            String query = "delete from Menu where foodId = " + Index;
            statement.executeUpdate(query);
            statement.close();
        }catch(Exception e){
          e.printStackTrace();
        }
    }



}
