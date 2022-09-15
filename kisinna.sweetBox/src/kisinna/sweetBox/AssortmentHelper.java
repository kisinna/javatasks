package kisinna.sweetBox;

import java.util.HashMap;

import kisinna.sweetBox.sweet.Candy;
import kisinna.sweetBox.sweet.Sweet;
import kisinna.sweetBox.sweet.Waffle;
import kisinna.sweetBox.sweet.ingridients.FillingType;
import kisinna.sweetBox.sweet.ingridients.SweetType;

public class AssortmentHelper {
	private HashMap<Integer,Sweet> assortment = new HashMap<>();

	public HashMap<Integer,Sweet> getAssortment() {
		fillTestAssortment();
		return assortment;
	}

	private void fillTestAssortment() {
		Sweet sweet = new Candy("Ласточка", 1, 800, SweetType.chocolate, FillingType.chocolate);
		assortment.put(sweet.getId(), sweet);
		sweet = new Candy("Ласточка", 5, 1500, SweetType.chocolate, FillingType.chocolate);
		assortment.put(sweet.getId(), sweet);
		sweet = new Candy("Ласточка", 10, 2800, SweetType.chocolate, FillingType.chocolate);
		assortment.put(sweet.getId(), sweet);
		sweet = new Candy("Клубника со сливками", 10, 1700, SweetType.caramel, FillingType.berry);
		assortment.put(sweet.getId(), sweet);
		sweet = new Waffle("Привет", 0.5, 100, FillingType.creamy);
		assortment.put(sweet.getId(), sweet);
		sweet = new Waffle("Привет", 2, 350, FillingType.creamy);
		assortment.put(sweet.getId(), sweet);
		sweet = new Waffle("Чудо", 0.5, 90, FillingType.fruit);
		assortment.put(sweet.getId(), sweet);
		sweet = new Waffle("Чудо", 5, 800, FillingType.fruit);
		assortment.put(sweet.getId(), sweet);
	}

}
