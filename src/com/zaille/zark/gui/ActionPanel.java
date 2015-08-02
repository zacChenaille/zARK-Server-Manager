/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zaille.zark.gui;

import javax.swing.JButton;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Zac
 */
public class ActionPanel extends JPanel {
    
    public ActionPanel() {
        setLayout(new MigLayout());
        initComponents();
    }
    
    private void initComponents() {
        add(startServerButton, "sgx buttons, span");
        add(stopServerButton, "sgx buttons, span");
        add(updateServerButton, "sgx buttons, span");
    }
    
    private final JButton startServerButton = new JButton("Start Server");
    private final JButton stopServerButton = new JButton("Stop Server");
    private final JButton updateServerButton = new JButton("Update Server");
}
