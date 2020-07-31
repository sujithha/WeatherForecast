package Common;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyReader {
	static  Properties properties= new Properties();
	static String filePath=System.getProperty("user.dir")+"\\src\\test\\resources\\Properties\\QA.properties";

	public void initialisePropertyFile(String environment){
		filePath=System.getProperty("user.dir")+"\\src\\test\\resources\\Properties\\"+environment.toUpperCase()+".properties";
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
