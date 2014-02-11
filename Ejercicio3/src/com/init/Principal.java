package com.init;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Principal {

    public static void main(String args[]) {
        setLookAndFeel();
        PrincipalForm init = new PrincipalForm();
        init.setVisible(true);
        init.setLocationRelativeTo(null);
        init.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(PrincipalForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
