import javax.swing.*;
import javax.swing.plaf.basic.BasicBorders;
import java.awt.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.color.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.geom.RoundRectangle2D;


public class MainMenu extends JFrame{
    private JButton Orders = new JButton("ORDERS");
    private JButton Menu = new JButton("MENU");
    private JButton Clients = new JButton("CLIENTS");
    private JButton Back = new JButton("BACK");

    private JLabel Time = new JLabel();
    private JLabel Shafran = new JLabel("Shafran");
    private JLabel back = new JLabel();


    public MainMenu(){
        setSize(1000, 800);
        setLayout(null);
        clock();
        Shafran.setBounds(450,30,150,40);//Название сверху
        Shafran.setFont(new Font("Cooper Black", Font.BOLD, 30));
        add(Shafran);


        //кнопка ORDERS
        Orders.setBounds(300,200,400,50);// setBound расположения в интерфейсе по пикселям
        Orders.setBorderPainted(true);
        Orders.setFocusPainted(true);
        Orders.setContentAreaFilled(true);
        Orders.setBackground(new Color(30, 133, 201));
        add(Orders);

        //кнопка MENU
        Menu.setBounds(300,300,400,50);// setBound расположения в интерфейсе по пикселям
        Menu.setBorderPainted(true);
        Menu.setFocusPainted(true);
        Menu.setContentAreaFilled(true);
        Menu.setBackground(new Color(30, 133, 201));
        add(Menu);

        //кнопка CLIENTS
        Clients.setBounds(300,400,400,50);// setBound расположения в интерфейсе по пикселям
        Clients.setBorderPainted(true);
        Clients.setFocusPainted(true);
        Clients.setContentAreaFilled(true);
        Clients.setBackground(new Color(30, 133, 201));
        add(Clients);


        Back.setForeground(Color.black);//кнопка BACK слева сверху
        Back.setBounds(30,30,100,50);// setBound расположения в интерфейсе по пикселям
        Back.setBorderPainted(true);
        Back.setFocusPainted(true);
        Back.setContentAreaFilled(true);
        Back.setBackground(new Color(255, 255, 255));
        add(Back);

        Time.setBounds(800, 30, 250,40);
        Time.setFont(new Font("", Font.BOLD, 30));
        add(Time);


        back.setBounds(0,0,1000,100);//это фон который стоит выше(back и Back это разное)
        back.setBackground(new Color(32,136,189));
        back.setOpaque(true);
        add(back);


        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Main.frame.setVisible(true);
            }
        });

        Orders.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Main.orderFrame.setVisible(true);
            }
        });

        Menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Main.adminMenuFrame.setVisible(true);
            }
        });

        Clients.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Main.adminClientsFrame.setVisible(true);
            }
        });
        back.setBounds(0,0,1000,100);
        back.setBackground(new Color(32,136,189));
        back.setOpaque(true);
        add(back);

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
