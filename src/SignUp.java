import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SignUp extends JFrame {
    Connection connection;
    PreparedStatement preparedStatement;
    private JLabel id;
    private JLabel name;
    private JLabel surname;
    private JLabel password;
    private JLabel email;

    private JTextField TextId;
    private JTextField TextName;
    private JTextField TextSurname;
    private JTextField TextPassword;
    private JTextField TextEmail;

    private JButton create;

    private JButton back;

  //  private String [] questions = {"Your lovely country", "Your lovely football team", "Your first car"};

    public SignUp(){

        connection = Main.Con();

        setSize(500,400);
        setTitle("SignUp");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        id = new JLabel("Id");
        id.setBounds(50,20,100,20);
        add(id);

        name = new JLabel("Name");
        name.setBounds(50,50,100,20);
        add(name);

        surname = new JLabel("Surname");
        surname.setBounds(50,80,100,20);
        add(surname);

        email = new JLabel("Email");
        email.setBounds(50,110,100,20);
        add(email);

        password = new JLabel("Password");
        password.setBounds(50,140,100,20);
        add(password);

        TextId= new JTextField();
        TextId.setBounds(170,20,200,20);
        add(TextId);

        TextName= new JTextField();
        TextName.setBounds(170,50,200,20);
        add(TextName);

        TextSurname = new JTextField();
        TextSurname.setBounds(170,80,200,20);
        add(TextSurname);

        TextEmail = new JTextField();
        TextEmail.setBounds(170,110,200,20);
        add(TextEmail);


        TextPassword = new JTextField();
        TextPassword.setBounds(170,140,200,20);
        add(TextPassword);


        create = new JButton("Create");
        create.setBounds(50,200,90,20);
        add(create);

        back = new JButton("Back");
        back.setBounds(160,200,90,20);
        add(back);


        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {

                try{
                    String query = "insert into Admin (adminId, adminName,adminSurname, adminEmail, adminPass) values (?,?,?,?,?)";

                    preparedStatement = connection.prepareStatement(query);

                    preparedStatement.setString(1,null);
                    preparedStatement.setString(2,TextName.getText());
                    preparedStatement.setString(3,TextSurname.getText());
                    preparedStatement.setString(4,TextEmail.getText());
                    preparedStatement.setString(5,TextPassword.getText());

                    preparedStatement.execute();

                    JOptionPane.showMessageDialog(null, "New acoount created");
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

                Registration r = new Registration();
                r.setVisible(true);


            }
        });
    }



}