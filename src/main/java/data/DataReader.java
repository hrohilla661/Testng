package data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.io.FileUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {
	
	 public List<HashMap<String, String>> getJsonDataToMap() throws IOException{
 
	 //read json to string 
//	String JsonContent=FileUtils.readFileToString(new File(System.getProperty("user.dir")+"\\src\\main\\java\\data\\NewReg.json")
//			,StandardCharsets.UTF_8);
//	
//		 System.out.println(System.getProperty("user.dir"));
	String path = "C:\\Users\\hrohi\\eclipse-workspace\\Niger\\src\\main\\resources\\NewReg.json";
	
	
	//String to hashmap (dependecy jackson databind)
	ObjectMapper mapper = new ObjectMapper();
	//Map<String, String> readValue = mapper.readValue(JsonContent,Map.class);
	List<HashMap<String, String>> data = mapper.readValue(path, new TypeReference<List<HashMap<String, String>>>(){
	});
	return data ;

}
}
