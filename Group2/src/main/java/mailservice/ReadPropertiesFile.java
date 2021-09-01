//Author : Akshay Garg

package mailservice;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadPropertiesFile {

	public static Properties readConfigPropertyFile(String configurationFile) throws IOException {
		Properties properties = new Properties();
		InputStream input = new FileInputStream(configurationFile);
		properties.load(input);
		return properties;
	}
}
