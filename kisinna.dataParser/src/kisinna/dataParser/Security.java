package kisinna.dataParser;

import java.time.LocalDate;
import java.util.List;

public class Security {
	private String name;
	private List<String> currencies;
	private String code;
	private LocalDate date;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Security(String name, List<String> currency, String code, LocalDate date) {
		super();
		this.name = name;
		this.currencies = currency;
		this.code = code;
		this.date = date;
	}
	public List<String> getCurrency() {
		return currencies;
	}
	public void setCurrency(List<String> currency) {
		this.currencies = currency;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}

}
