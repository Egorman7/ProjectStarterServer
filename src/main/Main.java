package main;

import main.server.Log;
import main.view.MainForm;

import javax.swing.*;

public class Main {
    public static void main(String[] args){
        JFrame frame = new JFrame("Project Starter Server");
        MainForm mf = new MainForm();
        frame.setContentPane(mf.mainPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(640, 480);
        Log.setText(mf.textArea1);
    }
}
