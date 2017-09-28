package com.example.sandbox.mains;

import javax.swing.*;
import java.awt.*;

class SwingExperiments {
    SwingExperiments() {
        JFrame f = new JFrame();
        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\temp\\tempbilder\\Elschema Planritning (1).png");
        f.setIconImage(icon);
        f.setLayout(null);
        f.setSize(400, 400);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String args[]) {
        new SwingExperiments();
    }
}