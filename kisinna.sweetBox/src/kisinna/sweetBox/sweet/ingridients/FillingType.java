package kisinna.sweetBox.sweet.ingridients;

public enum FillingType {
	chocolate("Шоколадная"), creamy("Сливочная"), nut("Ореховая"), fruit("Фруктовая"), berry("Ягодная");

	private String description;

	FillingType(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
