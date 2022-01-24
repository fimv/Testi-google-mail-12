package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {
    private static PropertyManager instance;
    private static String driverPath;
    private static String url;
    private static String login;
    private static String passw;
    private static String whoom;
    private static String topic; 
    private static String topicForCount;        

    public static PropertyManager getInstance() {
        if (instance == null) {
            instance = new PropertyManager();
            instance.loadData();
        }
        return instance;
    }

    private void loadData() {
        final Properties prop = new Properties();

        try {
            FileInputStream file = new FileInputStream(".\\src\\test\\resources\\application.properties");
            prop.load(file);
        } catch (IOException e) {
            System.out.println("Не найден файл с пропертями");
        }
        driverPath = prop.getProperty("webdriver.chrome.driver");
        url = prop.getProperty("webdriver.url");
        login = prop.getProperty("login");
    	passw = prop.getProperty("password");
    	whoom = prop.getProperty("whoom");
    	topic = prop.getProperty("topic");
    	topicForCount = prop.getProperty("topicForCount");
    }

    public String getDriverPath() {         
    	return driverPath;
    }
    public String getUrl() {         
    	return url;    	
    }
    public String getLogin() {         
    	return login;    	
    }
    public String getPassword() {         
    	return passw;
    }
    public String getWhoom() {         
    	return whoom;    	
    }
    public String getTopic() {         
    	return topic;
    }
    public String getTopicForCount() {         
        return topicForCount;      
    }    
}




