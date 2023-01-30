import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ClientReg extends JFrame {
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;

    private JLabel Time = new JLabel();
    private JLabel login = new JLabel("Login");;
    private JLabel password = new JLabel("Password");
    private JTextField loginText = new JTextField();
    private JPasswordField passwordField = new JPasswordField();

    private JButton enter = new JButton("LOGIN");
    private JButton signup = new JButton("SIGNUP");

    public ClientReg() {
        connection = ClientApp.Con();
        clock();
        setSize(500, 400);
        setTitle("Registration Client");
        setLayout(null);
        Time.setBounds(900, 30, 100,50);
        add(Time);


        login.setBounds(100,100,70,20);
        add(login);

        password.setBounds(100,125,70,20);
        add(password);

        loginText.setBounds(180,100,170,20);
        add(loginText);

        passwordField.setBounds(180,125,170,20);
        add(passwordField);

        enter.setBounds(125,155,100,20);
        add(enter);

        signup.setBounds(225,155,100,20);
        add(signup);

        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String query = "select* from Clients where Mail=? and Password=?";

                    preparedStatement = connection.prepareStatement(query);

                    preparedStatement.setString(1,loginText.getText());
                    preparedStatement.setString(2,passwordField.getText());
                    resultSet = preparedStatement.executeQuery();

                    if(resultSet.next())
                    {
                        resultSet.close();
                        preparedStatement.close();
                        setVisible(false);
                        ClientApp.clientMainframe.setVisible(true);
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
                ClientSignUp s = new ClientSignUp();

                s.setVisible(true);
            }
        });

    }
    public void clock() {
        Thread clock = new Thread() { // Используем много поточность для регулярного обновления выражжения часов
            public void run() {
                try {
                    for(;;){
                        Calendar cal = new GregorianCalendar(); // Получени нынешнего времени с компьютера
                        int minute = cal.get(Calendar.MINUTE); // Присваевание значения минут
                        int hour = cal.get(Calendar.HOUR); // Присваевание значения часов

                        Time.setText("Time: " + hour + ":" + minute);
                        Thread.sleep(1000);// Функция sleep для интервала в 1 сек
                    }
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        clock.start();
    }
}
