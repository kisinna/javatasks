package kisinna.orgDataParser;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class CompaniesParser implements JsonDeserializer<Companies>{

	@Override
	public Companies deserialize(JsonElement json, Type type, JsonDeserializationContext context)
			throws JsonParseException {
		JsonObject object = json.getAsJsonObject();
		JsonArray jsonCompanies = object.get("companies").getAsJsonArray();
		List<Company> companies = new ArrayList<>();
		for (JsonElement jsonCompany : jsonCompanies) {
			companies.add(new CompanyConverter().deserialize(jsonCompany, type, context));
		}
		return new Companies(companies);
	}

}
