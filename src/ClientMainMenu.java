import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ClientMainMenu extends JFrame{
//    private JButton Hot = new JButton("Hot");
//    private JButton Salads = new JButton("Salads");
//    private JButton Drinks = new JButton("Drinks");
    private JButton Back = new JButton("BACK");
    private JLabel Time = new JLabel();
//    private JButton Basket = new JButton("Basket");
    static Connection connection = ClientApp.Con();
    PreparedStatement preparedStatement;
    private JButton create = new JButton();
    private JLabel id = new JLabel("id");
    private JLabel name = new JLabel("name");
    private JLabel menu = new JLabel("menu");
    private JLabel price = new JLabel("price");
    private JLabel adress = new JLabel("adress");

    private JTextField TextId = new JTextField();
    private JTextField TextName = new JTextField();
    private JTextField TextMenu = new JTextField();
    private JTextField TextPrice = new JTextField();
    private JTextField TextAdress = new JTextField();

    private JButton list = new JButton("list");
    public static JTextArea text = new JTextArea();


    public ClientMainMenu(){
        setSize(1000, 800);
        setLayout(null);
        clock();

        setTitle("Main menu");
//        Hot.setBounds(300, 300,100,50);
//        add(Hot);

        id.setBounds(50,100,100,20);
        add(id);

        name.setBounds(50,130,100,20);
        add(name);

        menu.setBounds(50,160,100,20);
        add(menu);


        price.setBounds(50,190,100,20);
        add(price);

        adress.setBounds(50,220,100,20);
        add(adress);

        TextId.setBounds(170,100,200,20);
        add(TextId);

        TextName.setBounds(170,130,200,20);
        add(TextName);

        TextMenu.setBounds(170,160,200,20);
        add(TextMenu);


        TextPrice.setBounds(170,190,200,20);
        add(TextPrice);



        TextAdress.setBounds(170,220,200,20);
        add(TextAdress);

        text.setBounds(0,300,1000,400);
        add(text);



        create.setBounds(50,250,90,20);
        add(create);

        list.setBounds(150,250,90,20);
        add(list);

        list.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PackageData pd = new PackageData("LIST");
                ClientApp.connect(pd);
            }
        });

//
//        Salads.setBounds(450,300,100,50);
//        add(Salads);
//
//        Drinks.setBounds(600,300,100,50);
//        add(Drinks);

        Back.setBounds(30,30,100,50);
        add(Back);

        Time.setBounds(900, 30, 100,50);
        add(Time);
//
//        Basket.setBounds(450,600,100,50);
//        add(Basket);

        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                ClientApp.clientRegframe.setVisible(true);
            }
        });

//        Hot.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                setVisible(false);
//                ClientApp.clientHot.setVisible(true);
//            }
//        });

//        Salads.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                setVisible(false);
//                ClientApp.clientSalads.setVisible(true);
//            }
//        });
//
//        Drinks.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                setVisible(false);
//                ClientApp.clientDrinks.setVisible(true);
//            }
//        });

//        Basket.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                setVisible(false);
//                ClientApp.clientBasketframe.setVisible(true);
//            }
//        });


        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {

                try{
                    String query = "insert into Order (Id, Client_name, Menu, Price, Adress) values (?,?,?,?,?)";

//                    String query = "INSERT INTO Shafran.`Order` (Id, Client_Name, Menu, Price, Adress)\n" +
//                            "VALUES (?,?,?,?,?);";

                    preparedStatement = connection.prepareStatement(query);

                    preparedStatement.setString(1,null);
                    preparedStatement.setString(2,TextName.getText());
                    preparedStatement.setString(3,TextMenu.getText());
                    preparedStatement.setString(4,TextPrice.getText());
                    preparedStatement.setString(5,TextAdress.getText());
                    preparedStatement.execute();

                    int Id = Integer.parseInt(TextId.getText());
                    String Client_name = TextName.getText();
                    String Menu = TextMenu.getText();
                    int Price = Integer.parseInt(TextPrice.getText());
                    String Adress = TextAdress.getText();

                    Order order = new Order(Id,Client_name,Menu,Price,Adress);
                    PackageData pd = new PackageData("ADD",order);
                    ClientApp.connect(pd);
                    JOptionPane.showMessageDialog(null, "New Order created");
                    //resultSet.close();

                    preparedStatement.close();

                }catch (Exception ex){
                    ex.printStackTrace();
                }


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
