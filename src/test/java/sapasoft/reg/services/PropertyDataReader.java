package sapasoft.reg.services;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class PropertyDataReader {
    private static Properties properties;

    private PropertyDataReader() {
    }

    public static Properties getProperties(String propertiesFileName) {
        try {
            new FileReader("src/test/resources/" + propertiesFileName + ".properties");
            properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream("src/test/resources/" + propertiesFileName + ".properties");
            properties.load(new InputStreamReader(fileInputStream, StandardCharsets.UTF_8));
        } catch (IOException e) {
            System.out.println();
        }
        return properties;
    }
}


