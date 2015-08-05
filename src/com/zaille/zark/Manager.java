/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zaille.zark;

import com.zaille.zark.config.ConfigManager;
import com.zaille.zark.gui.MainPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author Zac
 */
public class Manager {
    
    public static void main(String[] args) {
        ConfigManager.readConfiguration();
        
        JFrame frame = new JFrame("zARK Server Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new MainPanel(), BorderLayout.CENTER);
        frame.setSize(new Dimension(800, 700));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
