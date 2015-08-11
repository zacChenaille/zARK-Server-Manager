/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zaille.zark.gui.properties;

import javax.swing.JComponent;

/**
 *
 * @author Garrett
 */
public abstract class PropertyField {
    
    private final String propertyName;
    
    public PropertyField(String propertyName) {
        this.propertyName = propertyName;
    }
    
    public String getPropertyName() {
        return propertyName;
    };
    public abstract String getPropertyValue();
    public abstract void setPropertyValue(String value);
    public abstract JComponent getComponent();
}