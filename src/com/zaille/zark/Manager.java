/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zaille.zark;

import com.zaille.zark.config.ConfigManager;
import com.zaille.zark.gui.MainPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

/**
 *
 * @author Zac
 */
public class Manager extends JFrame {
    
    public Manager() {
        super();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
    }
    
    private void initComponents() {
        setContentPane(new MainPanel());
    }
    
    public void run() {
        setTitle("ZG-ARK Server Manager");
        setBackground(Color.WHITE);
//        setIconImage();
        setSize(new Dimension(800, 700));
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // For some reason we didn't find nimbus...
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, 
                    "Exception setting Nimbus L/F", e);
        }
        ConfigManager.readConfiguration();
        new Manager().run();
    }
}