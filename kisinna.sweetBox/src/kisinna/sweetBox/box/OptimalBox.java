package kisinna.sweetBox.box;

import java.util.ArrayList;
import java.util.Collections;

import kisinna.sweetBox.sweet.Sweet;
import kisinna.sweetBox.sweet.comparator.PriceComparatorDesc;
import kisinna.sweetBox.sweet.comparator.WeightComparatorDesc;

public class OptimalBox implements SweetBox {
	private static final String BOX_CONTENT_MSG = "Ваша коробка: \n";
	private static final String PRICE_MSG = "Цена коробки: %.2f руб. \n";
	private static final String WEIGHT_MSG = "Вес коробки: %.2f кг. \n";
	private ArrayList<Sweet> sweets = new ArrayList<>();
	private double weight;
	private double price;

	@Override
	public void add(Sweet sweet) {
		sweets.add(sweet);
		weight += sweet.getWeight();
		price += sweet.getPrice();
	}

	@Override
	public void delete() {
		if (!sweets.isEmpty()) {
			int key = sweets.size() - 1;
			weight -= sweets.get(key).getWeight();
			price -= sweets.get(key).getPrice();
			sweets.remove(key);
		}
	}

	@Override
	public void delete(int index) {
		int key = -1;
		for (Sweet sweet : sweets) {
			if (sweet.getId() == index) {
				key = sweets.indexOf(sweet);
				break;
			}
		}
		if (key == -1)
			return;
		weight -= sweets.get(key).getWeight();
		price -= sweets.get(key).getPrice();
		sweets.remove(key);
	}

	@Override
	public double getWeight() {
		return weight;
	}

	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public String getFullInfo() {
		StringBuilder builder = new StringBuilder();
		builder.append(BOX_CONTENT_MSG);
		for (Sweet sweet : sweets) {
			builder.append(sweet.getFullInfo());
			builder.append("\n");
		}
		builder.append(String.format(WEIGHT_MSG, weight));
		builder.append(String.format(PRICE_MSG, price));
		return builder.toString();
	}

	public void optimizeWeight(double weight) {
		Collections.sort(sweets, new WeightComparatorDesc());
		while (this.weight > weight) {
			delete();
		}
	}

	public void optimizePrice(double weight) {
		Collections.sort(sweets, new PriceComparatorDesc());
		while (this.weight > weight) {
			delete();
		}
	}

}
