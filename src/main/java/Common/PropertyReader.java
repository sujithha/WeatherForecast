package Common;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyReader {
	static  Properties properties= new Properties();
	static String filePath=null;

	public void initialisePropertyFile(){
		try {

			String environment=System.getProperty("environment");
			if(environment!=null){
				filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\" + environment.toUpperCase() + ".properties";

			}
			else {
				filePath=System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\QA.properties";
			}
			}
		catch (Exception e){
			filePath=System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\QA.properties";
		}

		}

	public  String readProperty(String value) throws Exception {
	    String str=null;
	    try {
	        FileInputStream input= new FileInputStream(filePath);
	        properties.load(input);
	        str=properties.getProperty(value);

	    }
	    catch (Exception e){
        throw new Exception("Property "+value+" not found in "+filePath);
	    }
	    return  str;
	}

}
