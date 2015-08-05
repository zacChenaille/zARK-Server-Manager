/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zaille.zark.gui;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Table;
import com.zaille.zark.config.ConfigManager;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Set;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Zac
 */
public class OptionsPanel extends JPanel {
    
    private final ImmutableList<String> checkBoxOptions = ImmutableList.<String>of(
            "RCONEnabled",
            "ShowMapPlayerLocation",
            "ServerHardcore",
            "GlobalVoiceChat",
            "ProximityChat",
            "NoTributeDownloads",
            "AllowThirdPersonPlayer",
            "DontAlwaysAllowNotifyPlayerJoined",
            "ServerPVE",
            "ServerCrosshair",
            "ServerForceNoHud",
            "bDisableStructureDecayPvE",
            "bAllowFlyerCarryPvE",
            "EnablePvPGamma",
            "ProximityVoiceChat",
            "AlwaysNotifyPlayerLeft",
            "DontAlwaysNotifyPlayerJoined");
    
    public OptionsPanel() {
        setLayout(new MigLayout());
        initComponents();
    }
    
    private void initComponents() {
        Set<String> categories = ConfigManager.getCategories();
        for (String category : categories) {
            JPanel optionsPanel = new JPanel();
            optionsPanel.setLayout(new MigLayout());
            for (String setting : ConfigManager.getSettingsForCategory(category)) {
                optionsPanel.add(new JLabel(setting), "span");
            }
            categoryTabs.add(category, optionsPanel);
        }
        
        add(categoryTabs, "push, grow, span");
    }

    private void addOptionToPanel(String setting, String value) {
        if (checkBoxOptions.contains(setting)) {
            JCheckBox checkBox = new JCheckBox(setting);
            checkBox.setSelected(value.equalsIgnoreCase("true"));
            add(checkBox, "span");
        } else {
            JTextField textField = new JTextField();
            textField.setText(value);
            add(new JLabel(setting), "split 2, span");
            add(textField, "sgx fields");
        }
    }
    
    private final JTabbedPane categoryTabs = new JTabbedPane();
    
}
