package kisinna.fileAnalyzer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Main {

	private static final String IO_EXC_MSG = "Ошибка доступа к файлу: %s";
	private static final String NOT_FOUND_EXC_MSG = "Не найден файл: %s";

	public static void main(String[] args) throws UnsupportedEncodingException {
		FileHandler fileHandler = new FileHandler();
		Client client = new Client();
		String path = client.getPath();
		try {
			client.handleMap(fileHandler.getFreqMap(path));
		} catch (FileNotFoundException e) {
			client.printInfo(String.format(NOT_FOUND_EXC_MSG, path));
		} catch (IOException e) {
			client.printInfo(String.format(IO_EXC_MSG, path));
		}

	}

}
