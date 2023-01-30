import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminClients extends JFrame {
    private JButton Back = new JButton("Back");
    public AdminClients(){
        setSize(1000, 800);
        setTitle("Clients");
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
