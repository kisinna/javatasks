package kisinna.sweetBox.sweet;

import kisinna.sweetBox.sweet.ingridients.FillingType;

public class Waffle extends Sweet {
	private static final String SPECIAL_INFO = "Начинка: %s \t";
	private static final String WAFFLE_NAME = "Вафли \"%s\"";
	private FillingType fillingType;

	/**
	 * Создаем конфеты
	 * 
	 * @param name        наименование
	 * @param weight      вес упаковки
	 * @param price       цена упаковки
	 * @param bodyType    тип корпуса
	 * @param fillingType тип начинки
	 */
	public Waffle(String name, double weight, double price, FillingType fillingType) {
		super(String.format(WAFFLE_NAME, name), weight, price);
		setFillingType(fillingType);
	}

	public FillingType getFillingType() {
		return fillingType;
	}

	public void setFillingType(FillingType fillingType) {
		this.fillingType = fillingType;
	}

	@Override
	public String getSpecialInfo() {
		return String.format(SPECIAL_INFO, fillingType.getDescription());
	}
}
