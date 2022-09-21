package kisinna.dataParser;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class CompanyConverter implements JsonDeserializer<Company>{

	private static final String SECURITIES = "securities";
	private static final String FOUNDED = "founded";
	private static final String INN = "inn";
	private static final String PHONE_NUMBER = "phoneNumber";
	private static final String ADDRESS = "address";
	private static final String NAME = "name";
	private static final String ID = "id";

	@Override
	public Company deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
		JsonObject object = json.getAsJsonObject();
		Integer id = object.get(ID).getAsInt();
		String name = object.get(NAME).getAsString();
		String address = object.get(ADDRESS).getAsString();
		String phoneNumber = object.get(PHONE_NUMBER).getAsString();
		String inn = object.get(INN).getAsString();
		LocalDate founded = LocalDate.parse(object.get(FOUNDED).getAsString(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
		JsonArray jsonSecurities = object.get(SECURITIES).getAsJsonArray();
		List<Security> securities = new ArrayList<>();
		for (JsonElement jsonSecurity : jsonSecurities) {
			securities.add(new SecurityConverter().deserialize(jsonSecurity, type, context));
		}
		return new Company(id, name, address, phoneNumber, inn, founded, securities);
	}

	
	

}
