/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zaille.zark.config;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author Zac
 */
public class ConfigManager {
    
    private static final Table<String, String, String> configs = HashBasedTable.create();
    
    public static void registerConfig(String category, String config) {
        if (category == null || category.isEmpty()) {
            throw new IllegalArgumentException("Category must be specified");
        }
        if (!config.contains("=")) {
            throw new IllegalArgumentException("Config must be in the format [setting]=[value]");
        }
        
        String[] parts = config.split("=");
        String setting = parts[0];
        String value;
        if (parts.length > 1) {
            value = parts[1];
        } else {
            value = "";
        }
        
        configs.put(category, setting, value);
    }
    
    public static Set<String> getCategories() {
        Set<String> categories = new HashSet<>();
        for (String category : configs.rowKeySet()) {
            categories.add(category);
        }
        return categories;
    }
    
    public static Set<String> getSettingsForCategory(String category) {
        Set<String> settings = new HashSet<>();
        for (String setting : configs.row(category).keySet()) {
            settings.add(setting);
        }
        return settings;
    }
    
    public static String getValueFor(String category, String setting) {
        return configs.get(category, setting);
    }
    
    public static void readConfiguration() {
        try {
            FileReader reader = new FileReader("D:\\Develop\\zARK-Server-Manager-master\\GameUserSettings.ini");
            BufferedReader textReader = new BufferedReader(reader);
            
            String category = null;
            String line;
            while((line = textReader.readLine()) != null) {
                if (line.matches("\\[(.*?)\\]")) {
                    category = line.replace("[", "").replace("]", "");
                } else if (!line.isEmpty()) {
                    registerConfig(category, line);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    
}
