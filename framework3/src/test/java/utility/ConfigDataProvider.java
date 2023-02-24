package utility;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {

	public Properties prop;

	public ConfigDataProvider(String configdatapath) {
		try {
			File fs = new File(configdatapath);
			FileInputStream fins = new FileInputStream(fs);
			prop = new Properties();
			prop.load(fins);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("If file not found :" + e);
		}
	}

	public String searchkey(String key) {
		return prop.getProperty(key);

	}

	public String getFromcity() {
		return prop.getProperty("Fromcity");

	}
	
	public String getTocity() {
		return prop.getProperty("Tocity");

	}

	public String getdate() {
		return prop.getProperty("date");

	}
	
	public String getday() {
		return prop.getProperty("day");

	}

	public String getURL() {
		return prop.getProperty("url");

	}
}
