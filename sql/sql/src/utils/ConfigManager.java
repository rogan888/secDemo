package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {
	private static ConfigManager configManager = new ConfigManager();// 饿汉模式

	private Properties properties;

	private ConfigManager() {
		properties = new Properties();
		InputStream is = ConfigManager.class.getClassLoader().getResourceAsStream("database.properties");
		try {
			properties.load(is);
			is.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public static ConfigManager getInstance() {
		return configManager;
	}

	public String getValue(String key) {
		return properties.getProperty(key);
	}
}
