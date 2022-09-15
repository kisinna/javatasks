package kisinna.sweetBox.box;

import kisinna.sweetBox.sweet.Sweet;

/**
 * @author Inna
 * Интерфейс для коробки сладостей с методами: добавить, удалить (по индексу/либо последний) 
 * сладость, вывести вес, стоимость коробки, выдать всю информацию обо всех сладостях
 */
public interface SweetBox {
	public void add(Sweet conf);

	public void delete();

	public void delete(int index);

	public double getWeight();

	public double getPrice();

	public String getFullInfo();
}
