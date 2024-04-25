package org.example.jdbc.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

/**
 * Class provides configuration parameters from files set by system
 * properties.
 */
public final class ParametersProvider {
    /**
     * ParametersProvider instance holder.
     */
    private static ParametersProvider instance;
    /**
     * List of parameters holders.
     */
    private final ArrayList<Properties> propertiesList = new ArrayList<>();

    /**
     * ParametersProvider instance accessor.
     * @return ParametersProvider instance
     */
    private static ParametersProvider getInstance() {
        if (instance == null) {
            instance = new ParametersProvider();
        }
        return instance;
    }

    /**
     * ParametersProvider constructor.
     */
    private ParametersProvider() {
        ArrayList<String> configFileNames = getConfigFileNames();
        for (String fileName: configFileNames) {
            Properties properties = new Properties();
            try {
                properties.loadFromXML(new FileInputStream(fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
            propertiesList.add(properties);
        }
        fillProperties();
    }

    /**
     * Gets configuration file names from system properties.
     * @return list of configuration file names
     */
    private static ArrayList<String> getConfigFileNames() {
        ArrayList<String> configFileNames = new ArrayList<>();
        for (String key: System.getProperties().stringPropertyNames()) {
            if (key.startsWith("config.location")) {
                String[] fileNames = System.getProperties().getProperty(key)
                        .split(";");
                configFileNames.addAll(Arrays.asList(fileNames));
            }
        }
        return configFileNames;
    }

    /**
     * Add to propertyList properties from filePath.
     */
    private void fillProperties() {
        try (FileInputStream fileInputStream = new FileInputStream(
                "src/test/resources/properties.properties")) {
            Properties properties =new Properties();
            properties.load(fileInputStream);
            propertiesList.add(properties);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Gets parameter by its key from list of parameters holder.
     * @param key of parameter to find in configuration
     * @return parameter or empty string, if it is not found
     */
    public static String getProperty(final String key) {
        for (Properties properties: getInstance().propertiesList) {
            String result = properties.getProperty(key, null);
            if (result != null) {
                return result;
            }
        }
        return "";
    }
}
