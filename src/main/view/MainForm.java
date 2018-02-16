package main.view;

import main.server.Server;

import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class MainForm {
    public JTextArea textArea1;
    public JPanel mainPanel;
    private JButton startButton;
    private JButton stopButton;

    private Server server;

    public MainForm() {
        textArea1.setEditable(false);
        textArea1.setText("Welcome to ProjectStarterServer! Press 'Start' to start server, 'Stop' to end your work!" );
        server = new Server();
        startButton.addActionListener((event)->{
            server.start();
        });
        stopButton.addActionListener((event)->{
            try {
                server.stop();
                Timer t = new Timer();
                t.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        System.exit(1);
                    }
                }, 2000);
                //System.exit(1);
            } catch (Exception ex){
                ex.printStackTrace();
            }
        });
    }
}
