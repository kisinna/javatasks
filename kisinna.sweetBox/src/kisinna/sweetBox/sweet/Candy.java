package kisinna.sweetBox.sweet;

import kisinna.sweetBox.sweet.ingridients.FillingType;
import kisinna.sweetBox.sweet.ingridients.SweetType;

/**
 * Кондитерское изделие: конфеты
 * 
 * @author Inna
 */
public class Candy extends Sweet {
	private static final String SPECIAL_INFO = "Корпус: %s \t Начинка: %s \t";
	private static final String CANDY_NAME = "Конфеты \"%s\"";
	private SweetType bodyType;
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
	public Candy(String name, double weight, double price, SweetType bodyType, FillingType fillingType) {
		super(String.format(CANDY_NAME, name), weight, price);
		setBodyType(bodyType);
		setFillingType(fillingType);
	}

	public SweetType getBodyType() {
		return bodyType;
	}

	public void setBodyType(SweetType bodyType) {
		this.bodyType = bodyType;
	}

	public FillingType getFillingType() {
		return fillingType;
	}

	public void setFillingType(FillingType fillingType) {
		this.fillingType = fillingType;
	}

	@Override
	public String getSpecialInfo() {
		return String.format(SPECIAL_INFO, bodyType.getDescription(), fillingType.getDescription());
	}

}
