package be.uantwerpen.fti.ei.bc.Graphics.Main;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * config file loader
 *
 * @author Bas Calders
 */
public class ConfigLoader {

    /**
     * load new config from file
     *
     * @return config
     */
    public static Config getConfig() {
        Properties prop = new Properties();
        String filePath = "src/be/uantwerpen/fti/ei/bc/Resources/Data/config.properties";

        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(filePath);
            prop.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
            return new Config(800, 600, 1.0f, 0.1f);
        }

        return new Config(Integer.parseInt(prop.getProperty("HEIGHT")), Integer.parseInt(prop.getProperty("WIDTH")), Float.parseFloat(prop.getProperty("SFXVOL")), Float.parseFloat(prop.getProperty("MVOL")));
    }
}
