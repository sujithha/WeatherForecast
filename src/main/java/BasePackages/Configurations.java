package BasePackages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

public class Configurations {
	
	public  void readBaseConfigurations(String environment) throws FileNotFoundException{
		Yaml yaml = new Yaml();
		File file =new File(System.getProperty("user.dir")+"/config.yaml");
		InputStream inputStream =  new FileInputStream(file);
				/*this.getClass()
		  .getClassLoader()
		  .getResourceAsStream(System.getProperty("user.dir")+"/config.yaml");*/
		Map<String, Map<String,Map<String,String>>> map = yaml.load(inputStream);
		System.out.println(map.get("environment").get("QA").get("url"));	
	}
	
	public static void main(String[] args) throws FileNotFoundException{
	Configurations configurations=new Configurations();
	configurations.readBaseConfigurations("QA");
	
}
	
}
