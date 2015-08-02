/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zaille.zark.gui;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import javax.swing.JLabel;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Zac
 */
public class OptionsPanel extends JPanel {
    
    private final HashMap<String, String> settings = new HashMap<>();
    
    public OptionsPanel() {
        setLayout(new MigLayout());
        initComponents();
    }
    
    private void initComponents() {
        readOptions();
    }
    
    private void readOptions() {
        try {
            FileReader reader = new FileReader("C:\\Users\\Zac\\Desktop\\GameUserSettings.ini");
            BufferedReader textReader = new BufferedReader(reader);
            
            boolean serverSettingsFound = false;
            String line;
            while((line = textReader.readLine()) != null) {
                if (serverSettingsFound) {
                    if (line.contains("SessionSettings")) {
                        break;
                    } else if (!line.isEmpty()) {
                        settings.put(line.split("=")[0], line.split("=")[1]);
                        add(new JLabel(line.split("=")[0]), "span");
                    }
                } else if (line.contains("ServerSettings")) {
                    serverSettingsFound = true;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}
