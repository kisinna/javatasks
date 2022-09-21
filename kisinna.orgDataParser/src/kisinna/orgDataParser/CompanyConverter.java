package kisinna.orgDataParser;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class CompanyConverter implements JsonDeserializer<Company>{

	@Override
	public Company deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
		JsonObject object = json.getAsJsonObject();
		Integer id = object.get("id").getAsInt();
		String address = object.get("address").getAsString();
		String phoneNumber = object.get("phoneNumber").getAsString();
		String inn = object.get("inn").getAsString();
		LocalDate founded = LocalDate.parse(object.get("founded").getAsString(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
		JsonArray jsonSecurities = object.get("securities").getAsJsonArray();
		List<Security> securities = new ArrayList<>();
		for (JsonElement jsonSecurity : jsonSecurities) {
			securities.add(new SecurityConverter().deserialize(jsonSecurity, type, context));
		}
		return new Company(id, address, phoneNumber, inn, founded, securities);
	}

	
	

}
