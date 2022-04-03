package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class GetPropertyValue {

    private final Properties properties;

    public GetPropertyValue() {
        BufferedReader reader;
        String propertyFilePath = "./src/test/resources/config.properties";
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public String getChromedriver() {
        String driverPath = properties.getProperty("chromedriver");
        if (driverPath != null) return driverPath;
        else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
    }

    public String getApplicationUrl() {
        String url = properties.getProperty("url");
        if (url != null) return url;
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }

    public String getEmail() {
        String phoneNumber = properties.getProperty("email");
        if (phoneNumber != null) return phoneNumber;
        else throw new RuntimeException("email not specified in the Configuration.properties file.");
    }

    public String getPassword() {
        String password = properties.getProperty("password");
        if (password != null) return password;
        else throw new RuntimeException("password not specified in the Configuration.properties file.");
    }
}
