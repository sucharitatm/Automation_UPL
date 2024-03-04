package reusableComponents;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

public class PropertiesOperations {

	static Properties prop = new Properties();// C:\selenium\Demo_practice\src\test\resources\testData

	public static String getPropertyValueByKey(String key) throws Exception {
		String propFilePath = System.getProperty("user.dir") + "\\src\\test\\resource\\testData\\config.properties";
		FileInputStream fis = new FileInputStream(propFilePath);
		prop.load(fis);

		// 2. read data
		String value = prop.get(key).toString();

		if (StringUtils.isEmpty(value)) {
			throw new Exception("Value is not specified for key: " + key + " in properties file.");
		}

		return value;
	}
}
