package Interface;

import main.Const;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * При этом сразу же производится подключение и можно передавать и считывать данные.
 * Но как это сделать, если данные передаются только через потоки? Каждый Socketсодержит
 * входной и выходной потоки класса InputStreamи OutputStream.
 */
public class clientGUI extends JFrame {
    private JTextField sendMSGField;
    private JButton sendButton;
    private JButton logoutButton;
    private JButton exitButton;
    private JPanel serverWin;
    public JTextArea getMSG;
    public BufferedReader in;
    public PrintWriter out;
    public Socket socket;
    public clientGUI(String ip, String name){

    setContentPane(serverWin);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        try {
            socket = new Socket(ip, Const.Port);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            out.println(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        exitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                System.exit(0);
            }
        });
        sendButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                String str1 = "";
                str1 = sendMSGField.getText();
                out.println(str1);
                sendMSGField.setText("");
            }
        });
        Resender resend = new Resender();
        resend.start();
    }

    private class Resender extends Thread {
        private boolean stoped;
         //Прекращает пересылку сообщений
        public void setStop() {
            stoped = true;
        }
        @Override
        public void run() {
            Scanner scan1 = new Scanner(System.in);
            try {
                while (!stoped) {
                    String str = in.readLine();
                    getMSG.setText(getMSG.getText()+str+"\n");
                }
            } catch (IOException e) {
                System.err.println("MSG receive error");
                e.printStackTrace();
            }
        }
    }
}
