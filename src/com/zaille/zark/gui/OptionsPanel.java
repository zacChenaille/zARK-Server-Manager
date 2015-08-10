/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zaille.zark.gui;

import com.google.common.collect.ImmutableList;
import com.zaille.zark.config.ConfigManager;
import com.zaille.zark.gui.controls.KPanel;
import java.util.Set;
import javax.swing.JCheckBox;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

/**
 *
 * @author Zac
 */
public class OptionsPanel extends KPanel {
    
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
        super("");
        initComponents();
    }
    
    private void initComponents() {
        Set<String> categories = ConfigManager.getCategories();
        for (String category : categories) {
            KPanel optionsPanel = new KPanel("");
            for (String setting : ConfigManager.getSettingsForCategory(category)) {
                addOptionToPanel(optionsPanel, setting, ConfigManager.getValueFor(category, setting));
            }
            categoryTabs.add(category, optionsPanel);
        }
        
        add(categoryTabs, "push, grow, span");
    }

    private void addOptionToPanel(KPanel panel, String setting, String value) {
        if (checkBoxOptions.contains(setting)) {
            JCheckBox checkBox = new JCheckBox(setting);
            checkBox.setSelected(value.equalsIgnoreCase("true"));
            panel.add(checkBox, "span");
        } else {
            JTextField textField = new JTextField();
            textField.setText(value);
            panel.add(setting, "align right");
            panel.add(textField, "span");
        }
    }
    
    private final JTabbedPane categoryTabs = new JTabbedPane();
}