package kisinna.dataParser;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Client {
	private static final String DATA_JSON = "data.json";
	private static final String INCORRECT_CURRENCY = "Неверная валюта.";
	private static final String MAX_DATE = "2060-01-01";
	private static final String DATE_PATTERN = "[dd.MM.yyyy][dd.MM.yy][dd/MM/yyyy][dd/MM/yy]";
	private static final String INPUT_CURRENCY_MSG = "Введите валюту (RUB, USD, EU)";
	private static final String INCORRECT_DATE_MSG = "Неверный формат даты";
	private static final String FOUNDED_AFTER_MSG = "Организации, основанные после введенной даты";
	private static final String INPUT_DATE_MSG = "Введите дату (до 2060 года) в формате dd.MM.yyyy, dd.MM.yy, dd/MM/yyyy, dd/MM/yyyy";
	private static final String OVERDUE_SECURITIES_MSG = "Все ценные бумаги, которые просрочены на текущий день";
	private static final String FOUNDED_MSG = "\t-\t Дата основания:";
	private static final String ALL_COMPANIES_MSG = "Все имеющиеся компании";
	private static final String ULINE = "________________________________________________________";
	private static final String USD = "USD";
	private static final String EU = "EU";
	private static final String RUB = "RUB";
	private static final String ENCODING = "UTF-8";
	private static final List<String> currList = List.of(RUB, EU, USD);
	private PrintStream out;
	private Scanner in;
	private List<Company> data;

	public Client() {
		try {
			out = new PrintStream(System.out, true, ENCODING);
		} catch (UnsupportedEncodingException e) {
			out = new PrintStream(System.out);
		}
		in = new Scanner(System.in);
	}

	public void printAll() {
		out.println(ALL_COMPANIES_MSG);
		data.forEach(c -> out.println(c.getName() + FOUNDED_MSG + c.getFounded()));
		out.println(ULINE);
	}

	public void printOverdue() {
		out.println(OVERDUE_SECURITIES_MSG);
		List<Security> securities = new ArrayList<>();
		data.forEach(c -> {
			securities.addAll(c.getSecurities());
			securities.stream().filter(s -> s.getDate().isBefore(LocalDate.now())).collect(Collectors.toList())
					.forEach(s -> out.println(s.getCode() + "\t" + s.getDate() + "\t" + c.getName()+ "\t" + c.getAddress()));
		});
		out.println(ULINE);
		out.println("Всего "+securities.size() + " просроченных бумаг");
		out.println(ULINE);
	}

	public void printCompaniesByDate() {
		out.println(INPUT_DATE_MSG);	
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_PATTERN);
		try {
			LocalDate date = LocalDate.parse(in.next(), formatter);
			LocalDate newDate = date.isAfter(LocalDate.parse(MAX_DATE)) ? date.minusYears(100) : date;
			out.println(FOUNDED_AFTER_MSG);
			data.stream().filter(c -> c.getFounded().isAfter(newDate))
					.forEach(c -> out.println(c.getName() + "\t" + c.getFounded()));
		} catch (DateTimeParseException e) {
			out.println(INCORRECT_DATE_MSG);
		}
		out.println(ULINE);

	}

	public void printSecuritiesByCurrency() {
		out.println(INPUT_CURRENCY_MSG);
		String curr = in.next();
		if (currList.contains(curr)) {
			List<Security> securities = new ArrayList<>();
			data.forEach(c -> {
				securities.addAll(c.getSecurities());
				securities.stream().filter(s -> s.getCurrency().contains(USD)).collect(Collectors.toList())
						.forEach(s -> out.println(c.getId() + "\t" + s.getCode() + "\t" + s.getName()));
			});
		} else {
			out.println(INCORRECT_CURRENCY);
		}
		out.println(ULINE);
	}

	public static void main(String[] args) throws FileNotFoundException {
		Client client = new Client();
		client.setData(new JsonDataParser().getCompanyList(DATA_JSON));
		client.printAll();
		client.printOverdue();
		client.printCompaniesByDate();
		client.printSecuritiesByCurrency();
	}

	public List<Company> getData() {
		return data;
	}

	public void setData(List<Company> data) {
		this.data = data;
	}
}
