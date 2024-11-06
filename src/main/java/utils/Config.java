/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cisco
 */
public final class Config {

    private static Map<String, String> config;
    
    private Config() {
    }

    public static void Load() {
        config = new HashMap();
        try {
            File file = new File("./nutricionista.cfg");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String[] line = scanner.nextLine().split("=");
                config.put(line[0], line[1]);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            config.put("theme", "0");
            config.put("dbURL", "localhost/nutricionistagp1");
            config.put("dbUser", "root");
            config.put("dbPasswd", "null");
            Save();
        }

    }

    public static void Save() {
        try {
            FileWriter writer = new FileWriter(("./nutricionista.cfg"), false);
            config.forEach((k, v) -> {
                try {
                    writer.write(String.join("=", k, v + "\n"));
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            });
            writer.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static String getDbURL() {
        Load();
        return config.get("dbURL");
    }

    public static String getDbUser() {
        Load();
        return config.get("dbUser");
    }

    public static String getDbPasswd() {
        Load();
        var passwd = config.get("dbPasswd");
        return passwd.equals("null") ? "" : passwd;
    }
    
    public static Integer getTheme() {
        Load();
        return Integer.valueOf(config.get("theme"));
    }
    
    public static void setTheme(int theme) {
        config.put("theme", String.valueOf(theme));
        Save();
    }
}
