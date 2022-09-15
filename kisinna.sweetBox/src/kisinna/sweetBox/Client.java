package kisinna.sweetBox;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Scanner;

import kisinna.sweetBox.box.OptimalBox;
import kisinna.sweetBox.sweet.Sweet;

public class Client {
	private static final String PRICE_MSG = "Введите желаемую стоимость коробки";
	private static final String OPTIMIZED_MSG = "Оптимизация завершена";
	private static final String POSITIVE_NUMBER_MSG = "Введите положительное число";
	private static final String WEIGHT_MSG = "Введите желаемый вес коробки";
	private static final String DELETED_MSG = "Удаление завершено.";
	private static final String DELETE_MSG = "Введите номер позиции, которую хотите удалить";
	private static final String INCORRECT_NUMBER_MSG = "Введено не допустимое значение.";
	private static final String COMPLETED_MSG = "Формирование коробки завершено. Спасибо за сотрудничество.";
	private static final String NOT_FOUND_MSG = "Введенная позиция отсутствует.";
	private static final String COMPLETE_4_MSG = "Введите 4 чтобы завершить формирование коробки";
	private static final String OPT_PRICE_3_MSG = "Введите 3 чтобы оптимизировать коробку по цене";
	private static final String OPT_WEIGHT_2_MSG = "Введите 2 чтобы оптимизировать коробку по весу";
	private static final String ADD_1_MSG = "Введите 1 чтобы вернуться к добавлению товаров";
	private static final String DELETE_0_MSG = "Введите 0 чтобы удалить товары из коробки";
	private static final String ADDED_MSG = "Добавлено: %s";
	private static final String IS_COMPLETE_MSG = "Формирование коробки завершено";
	private static final String INCORRECT_DATA_MSG = "Введено не числовое значение.";
	private static final String COMPLETE_MSG = "Введите 0(ноль) чтобы завершить.";
	private static final String ADD_POSITION_MSG = "Введите номер позиции чтобы добавить в коробку.";
	private static final String ASSORTMENT_MSG = "Ассортимент:";
	private static final String WELCOME_MSG = "Соберите оптимальную коробку сладостей!";
	private static final String ENCODING = "UTF-8";
	private PrintStream out;
	private Scanner in;
	private OptimalBox box = new OptimalBox();
	private HashMap<Integer, Sweet> assortment = new HashMap<>();

	public Client() throws UnsupportedEncodingException {
		out = new PrintStream(System.out, true, ENCODING);
		in = new Scanner(System.in);
	}

	public static void main(String[] args) throws UnsupportedEncodingException {
		Client view = new Client();
		view.showAssortment();
		view.fillBox();
		view.handleBox();
	}

	private void showAssortment() {
		out.println(WELCOME_MSG);
		out.println(ASSORTMENT_MSG);
		assortment = new AssortmentHelper().getAssortment();
		assortment.forEach((key, value) -> out.println(value.getFullInfo()));
	}

	private void fillBox() {
		while (true) {
			out.println(ADD_POSITION_MSG);
			out.println(COMPLETE_MSG);
			if (!in.hasNextInt()) {
				out.println(INCORRECT_DATA_MSG);
				continue;
			}
			int key = in.nextInt();
			if (key == 0) {
				out.println(IS_COMPLETE_MSG);
				out.println(box.getFullInfo());
				return;
			}
			if (!assortment.containsKey(key)) {
				out.println(NOT_FOUND_MSG);
				continue;
			}
			Sweet sweet = assortment.get(key);
			box.add(sweet);
			out.println(String.format(ADDED_MSG, sweet.getGeneralInfo()));
		}
	}

	private void deleteFromBox() {
		out.println(box.getFullInfo());
		while (true) {
			out.println(DELETE_MSG);
			out.println(COMPLETE_MSG);
			if (!in.hasNextInt()) {
				out.println(INCORRECT_DATA_MSG);
				continue;
			}
			int key = in.nextInt();
			if (key == 0) {
				out.println(IS_COMPLETE_MSG);
				out.println(box.getFullInfo());
				return;
			}

			box.delete(key);
			out.println(DELETED_MSG);
			out.println(box.getFullInfo());
		}
	}

	private void optimizeWeight() {
		out.println(WEIGHT_MSG);
		if (!in.hasNextDouble()) {
			out.println(INCORRECT_DATA_MSG);
			return;
		}
		double max = in.nextDouble();
		if (max <= 0) {
			out.println(POSITIVE_NUMBER_MSG);
			return;
		}
		box.optimizeWeight(max);
		out.println(OPTIMIZED_MSG);
		out.println(box.getFullInfo());
	}

	private void optimizePrice() {
		out.println(PRICE_MSG);
		if (!in.hasNextDouble()) {
			out.println(INCORRECT_DATA_MSG);
			return;
		}
		double max = in.nextDouble();
		if (max <= 0) {
			out.println(POSITIVE_NUMBER_MSG);
			return;
		}
		box.optimizePrice(max);
		out.println(OPTIMIZED_MSG);
		out.println(box.getFullInfo());
	}

	private void handleBox() {
		while (true) {
			out.println(DELETE_0_MSG);
			out.println(ADD_1_MSG);
			out.println(OPT_WEIGHT_2_MSG);
			out.println(OPT_PRICE_3_MSG);
			out.println(COMPLETE_4_MSG);
			if (!in.hasNextInt()) {
				out.println(INCORRECT_DATA_MSG);
				continue;
			}
			int choise = in.nextInt();
			switch (choise) {
			case 0: {
				deleteFromBox();
				break;
			}
			case 1: {
				fillBox();
				break;
			}
			case 2: {
				optimizeWeight();
				break;
			}
			case 3: {
				optimizePrice();
				break;
			}
			case 4: {
				out.println(box.getFullInfo());
				out.println(COMPLETED_MSG);
				return;
			}
			default: {
				out.println(INCORRECT_NUMBER_MSG);
				continue;
			}
			}

		}
	}

}
