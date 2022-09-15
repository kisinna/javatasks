package kisinna.sweetBox.sweet;

public abstract class Sweet {
	private static final String GENERAL_INFO = "Id: %06d \t Наименование: %30s \t Вес: %5.2f кг. \t Цена: %5.2f руб. \t ";
	private int id;
	private String name;
	private double weight;
	private double price;
	private static int idCounter;

	public abstract String getSpecialInfo();

	public Sweet() {
		generateId();
	}

	public Sweet(String name, double weight, double price) {
		generateId();
		setName(name);
		setWeight(weight);
		setPrice(price);
	}

	public String getFullInfo() {
		return getGeneralInfo() + getSpecialInfo();
	}

	public String getGeneralInfo() {
		return String.format(GENERAL_INFO, id, name, weight,
				price);
	}

	private void generateId() {
		id = ++idCounter;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
