/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zaille.zark.gui.properties;

import java.text.DecimalFormat;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;

/**
 *
 * @author Garrett
 */
public class NumberProperty extends PropertyField {
    
    private final JFormattedTextField textField;
    
    public NumberProperty(String propertyName, String defaultValue) {
        super(propertyName);
        textField = new JFormattedTextField(new DecimalFormat("#####0.00#####"));
        textField.setColumns(6);
        textField.setText(defaultValue);
    }

    @Override
    public String getPropertyValue() {
        return textField.getText();
    }

    @Override
    public void setPropertyValue(String value) {
        textField.setText(value);
    }

    @Override
    public JComponent getComponent() {
        return textField;
    }
}