package Interface;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class serverGUI extends JFrame{
    private JTextPane onlineButton;
    private JPanel serverUIW;
    private JButton quitButton;

    public serverGUI(){
        setContentPane(serverUIW);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        pack();
        quitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                System.exit(0);
            }
        });
    }
}
