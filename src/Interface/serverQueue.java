package Interface;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class serverQueue extends JFrame {
    private JTextField serverIP;
    private JButton findServerButton;
    private JPanel ipWin;
    private JTextField nameLogin;
    public serverQueue(){
        setContentPane(ipWin);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        pack();
        findServerButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                String ip = serverIP.getText();
                String name = nameLogin.getText();
                clientGUI lol = new clientGUI(ip, name);
                ipWin.setVisible(false);
            }
        });
    }
}
