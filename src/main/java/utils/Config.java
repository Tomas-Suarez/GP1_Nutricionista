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
    private static Config instance = new Config();

    private Config() {
        config = new HashMap();
        File file = new File("./nutricionista.cfg");
        Scanner scanner;
        try {
            scanner = new Scanner(file);

            while (scanner.hasNext()) {
                String[] line = scanner.nextLine().split("=");
                config.put(line[0], line[1]);
            }
        } catch (FileNotFoundException ex) {
            loadDefaults();
            Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadDefaults() {
        config.put("theme", "0");
        config.put("dbURL", "localhost/nutricionistagp1");
        config.put("dbUser", "root");
        config.put("dbPasswd", "null");
    }

    public static Config getInstance() {
        if (instance == null) {
            instance = new Config();
        }
        return instance;
    }

    public void save() {
        FileWriter writer;
        try {
            writer = new FileWriter(("./nutricionista.cfg"), false);
            config.forEach((k, v) -> {
                try {
                    writer.write(String.join("=", k, v + "\n"));
                } catch (IOException ex) {
                    Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            writer.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public String getDbURL() {
        return config.get("dbURL");
    }

    public String getDbUser() {
        return config.get("dbUser");
    }

    public String getDbPasswd() {
        var passwd = config.get("dbPasswd");
        return passwd == "null" ? "" : passwd;
    }

    public Integer getTheme() {
        return Integer.valueOf(config.get("theme"));
    }

    public void setTheme(int theme) {
        config.put("theme", String.valueOf(theme));
        save();
    }
}
