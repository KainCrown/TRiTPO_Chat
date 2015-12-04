package Interface;

import server.Server;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu extends  JFrame{
    private JButton clientButton;
    private JButton serverButton;
    private JPanel mMenu;

    public Menu(){
        setContentPane(mMenu);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        pack();
        serverButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                new serverGUI();
                new Server();
            }
        });
        clientButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                new serverQueue();
            }
        });
    }
}
