/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zaille.zark.config;

import com.zaille.zark.gui.properties.ComboBoxProperty;
import com.zaille.zark.gui.properties.PropertyField;
import com.zaille.zark.gui.properties.NumberProperty;
import com.google.common.collect.ImmutableList;

/**
 *
 * @author Garrett
 */
public class DefaultProperties {
    public static final ImmutableList<PropertyField> defaultFieldList = new ImmutableList.Builder<PropertyField>()
            .add(new ComboBoxProperty("ShowMapPlayerLocation", "False", new String[]{"True", "False"}))
            .add(new NumberProperty("DifficultyOffset", "4.00"))
            .build();
}
