package main.server;

import javax.swing.*;

public class Log {
    private static JTextArea text;
    public Log(JTextArea text){
        this.text = text;
    }
    public static void setText(JTextArea t){
        text = t;
    }
    public static void e(String message){
        String s = "\n[ERROR]: " + message;
        text.append(s);
    }
    public static void d(String flag, String message){
        String s = "\n[" + flag + "]: " + message;
        text.append(s);
     }
}
