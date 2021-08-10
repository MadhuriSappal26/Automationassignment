package report;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URLDecoder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class AllureProperties {
private final static Logger log = LogManager.getLogger("AllureProperties");
	
	/**
	 * This method create environment.properties file to add envrionment properties to the allure report
	 * 
	 */
	public static void createAllurePropertiesFile() {
		try {
			String path = System.getProperty("user.dir")+"\\target\\allure-results\\environment.properties";
			String decodedPath = URLDecoder.decode(path, "UTF-8");
			File file = new File(decodedPath);
			if (file.createNewFile())
			{
			    FileWriter writer = new FileWriter(file);
			    String browser = "Browser="+System.getProperty("browser")+"\n";
				writer.write(browser);
				writer.write("Environment=QA\n");
				writer.write("URL=http://34.250.22.163/maximo/\n");
				writer.close();
			} else {
			    log.debug("envrionment.properties already exists.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
