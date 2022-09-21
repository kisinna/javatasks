package kisinna.dataParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Paths;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

public class JsonDataParser {

	public List<Company> getCompanyList(String path) throws FileNotFoundException {
			
			JsonReader reader = new JsonReader(new FileReader(Paths.get(path).toAbsolutePath().toFile()));
			Gson gson = new GsonBuilder()
	        .registerTypeAdapter(FullData.class, new FullDataConverter())
	        .create();
	     
	    FullData companies = gson.fromJson(reader, FullData.class);
	    return companies.getCompanies();
	}

}
