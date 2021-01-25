package integrationTest.integratioUtilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.imageio.IIOException;

public class PropertiesManager {

	private static final String PROPERTIES_NAME_STRING = "environment.properties";
	
	static String getEnvironmentProperty(String property) {
		try {
			return readProperty(property);
		} catch (IIOException e) {
			throw new RuntimeException("property file '" + PROPERTIES_NAME_STRING + "'not found in the classpath");
		}
	}
	
	private static String readProperty(String property) throws IIOException {
		String value = System.getProperty(property);
		if (value == null) {
			return readProperty(property);
		}else {
			return value;
		}
	}
	
	private static String readFromResource(String property) throws IOException {
		InputStream inputStream = PropertiesManager.class.getClassLoader().getResourceAsStream(PROPERTIES_NAME_STRING);
		Properties properties = new Properties();
		properties.load(inputStream);
		return properties.getProperty(property);
	}
}
