package kisinna.orgDataParser;

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

public class SecurityConverter implements JsonDeserializer<Security> {

	@Override
	public Security deserialize(JsonElement json, Type type, JsonDeserializationContext context)
			throws JsonParseException {
		JsonObject object = json.getAsJsonObject();
		String name = object.get("name").getAsString();
		JsonArray jsonCurrencies = object.get("currency").getAsJsonArray();
		List<String> currencies = new ArrayList<>();
		for (JsonElement jsonCurrency : jsonCurrencies) {
			currencies.add(jsonCurrency.getAsString());
		}
		String code = object.get("code").getAsString();
		LocalDate date = LocalDate.parse(object.get("date").getAsString(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
		return new Security(name, currencies, code, date);
	}

}
