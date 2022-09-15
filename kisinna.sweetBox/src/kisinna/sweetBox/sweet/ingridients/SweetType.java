package kisinna.sweetBox.sweet.ingridients;

public enum SweetType {
	chocolate("Шоколадные"), caramel("Карамель"), combined("Карамель в шоколадной глазури");

	private String description;

	SweetType(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
