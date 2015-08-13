/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zaille.zark.gui;

import com.zaille.zark.config.ConfigManager;
import com.zaille.zark.gui.controls.KPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Zac
 */
public class ActionPanel extends KPanel {
    
    private static Process serverProcess;
    
    public ActionPanel() {
        super("");
        initComponents();
    }
    
    private void initComponents() {
        startServerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startServer();
            }
        });
        stopServerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopServer();
            }
        });
        updateServerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateServer();
            }
        });
        
        add(startServerButton, "sgx buttons, span");
        add(stopServerButton, "sgx buttons, span");
        add(updateServerButton, "sgx buttons, span");
        
        stopServerButton.setEnabled(false);
    }
    
    private void startServer() {
        String serverDir = ConfigManager.getArkInstallPath() + "/ShooterGame/Binaries/Win64/ShooterGameServer";
        
        String arguments = 
                "\"" +
                "TheIsland" +
                "?listen" +
                "?SessionName=Imperium of Prehistoric Man" + //TODO
                "?ServerPassword=funkersnickles" + //TODO
                "?ServerAdminPassword=kawaiibutts" + //TODO
                "\"";
        try {
            ProcessBuilder pb = new ProcessBuilder(serverDir, arguments);
            serverProcess = pb.start();
            startServerButton.setEnabled(false);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private void stopServer() {
        if (serverProcess != null) {
            serverProcess.destroy();
            stopServerButton.setEnabled(false);
            startServerButton.setEnabled(true);
        }
        stopServerButton.setEnabled(false);
        startServerButton.setEnabled(true);
    }
    
    private void updateServer() {
        String steamCmd = ConfigManager.getSteamCmdPath();
        String installDir = ConfigManager.getArkInstallPath();
        
        try {
            startServerButton.setEnabled(false);
            stopServerButton.setEnabled(false);
            updateServerButton.setEnabled(false);
            
            ProcessBuilder pb = new ProcessBuilder(steamCmd, 
                                                   "+login", "anonymous", 
                                                   "+force_install_dir", installDir, 
                                                   "+app_update", "376030", 
                                                   "+quit");
            Process updateProcess = pb.start();
            updateProcess.waitFor();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            startServerButton.setEnabled(true);
            stopServerButton.setEnabled(false);
            updateServerButton.setEnabled(true);
        }
    }
    
    private final JButton startServerButton = new JButton("Start Server");
    private final JButton stopServerButton = new JButton("Stop Server");
    private final JButton updateServerButton = new JButton("Update Server");
}
