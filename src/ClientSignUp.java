import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ClientSignUp extends JFrame{
    Connection connection;
    PreparedStatement preparedStatement;
    private JLabel id;
    private JLabel name;
    private JLabel surname;
    private JLabel mail;
    private JLabel password;
    private JLabel adress;

    private JTextField TextId;
    private JTextField TextName;
    private JTextField TextSurname;
    private JTextField TextPassword;
    private JTextField TextMail;
    private JTextField TextAdress;

    private JButton create;

    private JButton back;

    //  private String [] questions = {"Your lovely country", "Your lovely football team", "Your first car"};

    public ClientSignUp(){

        connection = ClientApp.Con();
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

        mail = new JLabel("Email");
        mail.setBounds(50,110,100,20);
        add(mail);

        password = new JLabel("Password");
        password.setBounds(50,140,100,20);
        add(password);

        adress = new JLabel("Adress");
        adress.setBounds(50,170,100,20);
        add(adress);

        TextId = new JTextField();
        TextId.setBounds(170,20,200,20);
        add(TextId);

        TextName= new JTextField();
        TextName.setBounds(170,50,200,20);
        add(TextName);

        TextSurname = new JTextField();
        TextSurname.setBounds(170,80,200,20);
        add(TextSurname);

        TextMail = new JTextField();
        TextMail.setBounds(170,110,200,20);
        add(TextMail);

        TextPassword = new JTextField();
        TextPassword.setBounds(170,140,200,20);
        add(TextPassword);

        TextAdress = new JTextField();
        TextAdress.setBounds(170,170,200,20);
        add(TextAdress);


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
                    String query = "insert into Clients (id, Name, Surname, Mail, Password, Adress) values (?,?,?,?,?,?)";

                    preparedStatement = connection.prepareStatement(query);

                    preparedStatement.setString(1,null);
                    preparedStatement.setString(2,TextName.getText());
                    preparedStatement.setString(3,TextSurname.getText());
                    preparedStatement.setString(4,TextMail.getText());
                    preparedStatement.setString(5,TextPassword.getText());
                    preparedStatement.setString(6,TextAdress.getText());

                    preparedStatement.execute();

                    JOptionPane.showMessageDialog(null, "New acoont created");
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

                ClientReg r = new ClientReg();
                r.setVisible(true);


            }
        });
    }

}
