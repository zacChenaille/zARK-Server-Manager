/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zaille.zark.gui.properties;

import com.zaille.zark.gui.properties.PropertyField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JComponent;

/**
 *
 * @author Garrett
 */
public class ComboBoxProperty extends PropertyField {
    
    private final JComboBox comboBox;
        
    public ComboBoxProperty(String propertyName, String value, String[] possibleValues) {
        super(propertyName);
        DefaultComboBoxModel model = new DefaultComboBoxModel(possibleValues);
        comboBox = new JComboBox(model);
    }

    @Override
    public String getPropertyValue() {
        return comboBox.getSelectedItem().toString();
    }

    @Override
    public JComponent getComponent() {
        return comboBox;
    }

    @Override
    public void setPropertyValue(String value) {
        try {
            comboBox.setSelectedItem(value);
            if (!comboBox.getSelectedItem().equals(value)) {
                // Invalid value, reset to index 0
                comboBox.setSelectedIndex(0);
            }
        } catch (Exception ex) {}
    }
}