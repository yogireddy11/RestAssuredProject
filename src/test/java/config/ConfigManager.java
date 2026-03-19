package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {

   static Properties properties = new Properties();

     static{
         try {
             FileInputStream stream = new FileInputStream("config.properties");
             properties.load(stream);
         } catch (IOException e) {
             throw new RuntimeException(e);
         }
     }
     public static String getBaseUrl(String url){
         return properties.getProperty(url);
     }
}
