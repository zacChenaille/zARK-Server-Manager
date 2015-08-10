/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zaille.zark.gui.controls;

import java.awt.Color;
import java.awt.LayoutManager;
import javax.swing.JLabel;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Garrett Lund
 */
public class KPanel extends JPanel {
    
    public KPanel() {
        this("");
    }
    
    public KPanel(String constraints) {
        this(new MigLayout(constraints));
    }
    
    public KPanel(LayoutManager lm) {
        super(lm);
        setBackground(Color.WHITE);
    }
        
    public void add(String labelText, Object constraints) {
        super.add(new JLabel(labelText), constraints);
    }
}
