package kisinna.sweetBox.sweet.comparator;

import java.util.Comparator;

import kisinna.sweetBox.sweet.Sweet;

public class PriceComparatorDesc implements Comparator<Sweet> {

	@Override
	public int compare(Sweet sweet1, Sweet sweet2) {
		if (sweet1.getPrice() == sweet2.getPrice()) {
			return 0;
		} else if (sweet1.getPrice() > sweet2.getPrice()) {
			return -1;
		} else {
			return 1;
		}
	}

}
