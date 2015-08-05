/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zaille.zark.gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Zac
 */
public class MainPanel extends JPanel {
    
    public MainPanel() {
        setLayout(new MigLayout());
        initComponents();
    }
    
    private void initComponents() {
        tabbedPane.add("Actions", actionPanel);
        tabbedPane.add("Server Options", new JScrollPane(optionsPanel));
        
        add(tabbedPane, "push, grow, span");
    }
    
    private final JTabbedPane tabbedPane = new JTabbedPane();
    private final OptionsPanel optionsPanel = new OptionsPanel();
    private final ActionPanel actionPanel = new ActionPanel();
}
