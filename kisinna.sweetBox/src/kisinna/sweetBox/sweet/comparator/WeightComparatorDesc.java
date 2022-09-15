package kisinna.sweetBox.sweet.comparator;

import java.util.Comparator;

import kisinna.sweetBox.sweet.Sweet;

public class WeightComparatorDesc implements Comparator<Sweet> {

	@Override
	public int compare(Sweet sweet1, Sweet sweet2) {
		if (sweet1.getWeight() == sweet2.getWeight()) {
			return 0;
		} else if (sweet1.getWeight() > sweet2.getWeight()) {
			return -1;
		} else {
			return 1;
		}
	}

}
