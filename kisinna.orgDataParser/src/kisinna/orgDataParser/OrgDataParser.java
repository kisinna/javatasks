package kisinna.orgDataParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Paths;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

public class OrgDataParser {

	public List<Company> getCompanyList(String path) throws FileNotFoundException {
			
			JsonReader reader = new JsonReader(new FileReader(Paths.get(path).toAbsolutePath().toFile()));
			Gson gson = new GsonBuilder()
	        .registerTypeAdapter(Companies.class, new CompaniesParser())
	        .create();
	     
	    Companies companies = gson.fromJson(reader, Companies.class);
	    return companies.getCompanies();
	}

}
