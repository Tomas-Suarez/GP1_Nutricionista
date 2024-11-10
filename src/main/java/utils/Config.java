package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cisco
 */
public final class Config {

    private Properties props;

    private static Config instance;

    private Config() {
        this.props = new Properties();
        load();
    }

    public static Config getInstance() {
        if (instance == null) {
            instance = new Config();
        }
        return instance;
    }

    public void load() {
        try {
            var path = Path.of("./nutricionista.cfg");
            var reader = Files.newInputStream(path);
            props.load(reader);
        } catch (IOException ex) {
            Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void save() {
        try {
            var path = Path.of("./nutricionista.cfg");
            var out = Files.newOutputStream(path);
            props.store(out, null);
        } catch (IOException ex) {
            Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getDbURL() {
        if (!props.containsKey("dbURL")) {
            setProp("dbURL", "localhost/nutricionistagp1");
        }
        return props.getProperty("dbURL");
    }

    public String getDbUser() {
        if (!props.containsKey("dbUser")) {
            setProp("dbUser", "root");
        }
        return props.getProperty("dbUser");
    }

    public String getDbPasswd() {
        if (!props.containsKey("dbPasswd")) {
            setProp("dbPasswd", "");
        }
        return props.getProperty("dbPasswd");
    }

    public Integer getTheme() {
        if (!props.containsKey("theme")) {
            setTheme(0);
        }
        return Integer.valueOf(props.getProperty("theme"));
    }

    public void setTheme(int theme) {
        props.setProperty("theme", String.valueOf(theme));
        save();
    }

    public void setProp(String key, String value) {
        props.setProperty(key, value);
    }

    public String getProp(String prop) {
        return props.getProperty(prop);
    }
}
