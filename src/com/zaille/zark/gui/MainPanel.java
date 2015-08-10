/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zaille.zark.gui;

import com.zaille.zark.gui.controls.KPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

/**
 *
 * @author Zac
 */
public class MainPanel extends KPanel {
    
    public MainPanel() {
        super("");
        initComponents();
    }
    
    private void initComponents() {
        tabbedPane.add("Actions", actionPanel);
        JScrollPane optionScroll = new JScrollPane(optionsPanel);
        optionScroll.getVerticalScrollBar().setUnitIncrement(16);
        tabbedPane.add("Server Options", optionScroll);
        
        add(tabbedPane, "push, grow, span");
    }
    
    private final JTabbedPane tabbedPane = new JTabbedPane();
    private final OptionsPanel optionsPanel = new OptionsPanel();
    private final ActionPanel actionPanel = new ActionPanel();
}