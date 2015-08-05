/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zaille.zark.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        startServerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String start = "SteamCmd +login anonymous +force_install_dir ..\\ArkServer +app_update 376030 +quit";
                try {
                    Runtime.getRuntime().exec( new String[]{start});
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        stopServerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String stop = "";
            }
        });
        updateServerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String update = "";
            }
        });
        
        add(startServerButton, "sgx buttons, span");
        add(stopServerButton, "sgx buttons, span");
        add(updateServerButton, "sgx buttons, span");
    }
    
    private void startServer() {
        
    }
    
    private void stopServer() {
        
    }
    
    private void updateServer() {
        
    }
    
    private final JButton startServerButton = new JButton("Start Server");
    private final JButton stopServerButton = new JButton("Stop Server");
    private final JButton updateServerButton = new JButton("Update Server");
}
