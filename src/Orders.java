import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Orders extends JFrame {
    private JButton Back = new JButton("Back");

    public Orders() {
        setSize(1000, 800);
        setTitle("Order");
        setLayout(null);

        Back.setBounds(30,30,100,50);
        add(Back);
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Main.mainframe.setVisible(true);
            }
        });
    }
}
