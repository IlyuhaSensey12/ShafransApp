import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminMenu extends JFrame {
    private JButton Back = new JButton("Back");
    private JButton Hot = new JButton("Hot");
    private JButton Salads = new JButton("Salads");
    private JButton Drinks = new JButton("Drinks");
    private JButton Delete = new JButton("Delete");

    public AdminMenu(){
        setSize(1000, 800);
        setTitle("Menu");
        setLayout(null);

        Hot.setBounds(300, 200,400,50);
        add(Hot);

        Salads.setBounds(300, 300,400,50);
        add(Salads);

        Drinks.setBounds(300, 400,400,50);
        add(Drinks);

        Delete.setBounds(300,500,400,50);
        add(Delete);

        Hot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Hot h = new Hot();
                h.setVisible(true);
            }
        });

        Salads.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Salads s = new Salads();
                s.setVisible(true);
            }
        });

        Drinks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Drinks d = new Drinks();
                d.setVisible(true);
            }
        });

        Delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            setVisible(false);
            Delete del = new Delete();
            del.setVisible(true);
            }
        });

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
