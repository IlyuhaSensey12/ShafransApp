import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Hot extends JFrame{
    Connection connection;
    PreparedStatement preparedStatement;
    private JLabel foodId = new JLabel("foodId");
    private JLabel name = new JLabel("foodName");
    private JLabel price = new JLabel("price");;
    private JLabel type = new JLabel("Type");

    private JTextField TextId = new JTextField();
    private JTextField TextName = new JTextField();
    private JTextField TextPrice = new JTextField();
    private JTextField TextType = new JTextField();

    private JButton create;

    private JButton back;

    //  private String [] questions = {"Your lovely country", "Your lovely football team", "Your first car"};

    public Hot(){

        connection = Main.Con();
        setSize(1000,800);
        setTitle("SignUp");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        foodId.setBounds(100,40,200,40);
        add(foodId);

        name.setBounds(100,100,200,40);
        add(name);

        price.setBounds(100,160,200,40);
        add(price);

        type.setBounds(100,220,200,40);
        add(type);


        TextId.setBounds(370,40,200,40);
        add(TextId);

        TextName.setBounds(370,100,200,40);
        add(TextName);

        TextPrice.setBounds(370,160,200,40);
        add(TextPrice);

        TextType.setBounds(370,220,200,40);
        add(TextType);

        create = new JButton("Create");
        create.setBounds(100,400,90,20);
        add(create);

        back = new JButton("Back");
        back.setBounds(160,400,90,20);
        add(back);


        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {

                try{
                    String query = "insert into Menu (foodId,foodName,foodPrice,foodtype) values (?,?,?,?)";

                    preparedStatement = connection.prepareStatement(query);

                    preparedStatement.setString(1,null);
                    preparedStatement.setString(2,TextName.getText());
                    preparedStatement.setString(3,TextPrice.getText());
                    preparedStatement.setString(4,TextType.getText());

                    preparedStatement.execute();

                    JOptionPane.showMessageDialog(null, "New food created");
                    //resultSet.close();

                    //preparedStatement.close();

                }catch (Exception ex){
                    ex.printStackTrace();
                }


            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {

                setVisible(false);
                AdminMenu m = new AdminMenu();
                m.setVisible(true);
            }
        });
    }

}
