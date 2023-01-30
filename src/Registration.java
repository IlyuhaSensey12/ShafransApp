import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Registration extends JFrame{
   Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
   private JLabel login = new JLabel("Login");;
   private JLabel password = new JLabel("Password");
   private JLabel Shafran = new JLabel("Shafran");

   private JTextField loginText = new JTextField();
   private JPasswordField passwordField = new JPasswordField();

   private JButton enter = new JButton("LOGIN");
   private JButton signup = new JButton("SIGNUP");
   private JLabel back = new JLabel();

    public Registration() {
        connection = Main.Con();
        setSize(500, 400);
        setTitle("Registration");
        setLayout(null);

        Shafran.setBounds(200,10,150,20);
        Shafran.setForeground(Color.white);
        Shafran.setFont(new Font("Cooper Black", Font.BOLD ,25));
        add(Shafran);

        login.setBounds(100,100,70,20);
        add(login);

        password.setBounds(100,125,70,20);
        add(password);

        loginText.setBounds(180,100,170,20);
        add(loginText);

        passwordField.setBounds(180,125,170,20);
        add(passwordField);

        enter.setForeground(Color.white);
        enter.setBorderPainted(true);
        enter.setFocusPainted(true);
        enter.setContentAreaFilled(true);
        enter.setBackground(new Color(30,133,201));
        enter.setBounds(125,155,100,20);
        add(enter);

        signup.setBounds(225,155,100,20);
        add(signup);

        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String query = "select* from Admin where adminEmail=? and adminPass=?";

                    preparedStatement = connection.prepareStatement(query);

                    preparedStatement.setString(1,loginText.getText());
                    preparedStatement.setString(2,passwordField.getText());
                    resultSet = preparedStatement.executeQuery();

                    if(resultSet.next())
                    {
                        resultSet.close();
                        preparedStatement.close();
                        setVisible(false);
                        Main.mainframe.setVisible(true);
                    }else{
                        JOptionPane.showMessageDialog(null,"Incorrect login and password");
                    }
                }catch (Exception et){
                    et.printStackTrace();
                }
            }
        });

        signup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                SignUp s = new SignUp();

                s.setVisible(true);
            }
        });

        back.setBounds(0,0,500,50);
        back.setBackground(new Color(32,136,189));
        back.setOpaque(true);
        add(back);

    }
}
