package kisinna.fileAnalyzer;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;

public class Client {
	private static final String PATH_EXAMPLE_3 = "text.txt";
	private static final String PATH_EXAMPLE_2 = "src\\kinna\\text2.txt";
	private static final String PATH_EXAMPLE_1 = "C:\\Users\\Admin\\Desktop\\text.txt";
	private static final String PRINT_PATH_MSG = "Введите относительный или абсолютный путь к файлу. Например:";
	private static final String WELCOME_MSG = "Программа подсчета статистики частоты слов в файле.";
	private static final String MAX_FREQ_WORD_MSG = "Слова с максимальной частотой(%dраз(а), %.2f%%)";
	private static final String THE_WORD_COUNT = "%-20s\t-\t%3d раз(а)";
	private static final String WORDS_COUNT_MSG = "Файл содержит %s слов:";
	private static final String NO_WORDS = "Файл не содержит слов.";
	private static final String ENCODING = "UTF-8";
	private PrintStream out;
	private Scanner in;

	public Client() throws UnsupportedEncodingException {
		out = new PrintStream(System.out, true, ENCODING);
		in = new Scanner(System.in);
	}

	public void handleMap(Map<String, Integer> vocabulary) {
		int count = 0;
		for (Integer value : vocabulary.values()) {
			count += value;
		}
		if (count == 0) {
			out.println(NO_WORDS);
			return;
		}
		out.println(String.format(WORDS_COUNT_MSG, count));
		vocabulary.forEach((s, i) -> out.println(String.format(THE_WORD_COUNT, s, i)));
		Integer maxfreq = Collections.max(vocabulary.values());
		double percentFreq = (double) maxfreq / count * 100;
		out.println(String.format(MAX_FREQ_WORD_MSG, maxfreq, percentFreq));
		for (Map.Entry<String, Integer> entry : vocabulary.entrySet()) {
			if (entry.getValue() == maxfreq)
				out.println(entry.getKey());
		}
	}

	public String getPath() {
		out.println(WELCOME_MSG);
		out.println(PRINT_PATH_MSG);
		out.println(PATH_EXAMPLE_1);
		out.println(PATH_EXAMPLE_2);
		out.println(PATH_EXAMPLE_3);
		out.println();
		return in.next();
	}

	public void printInfo(String info) {
		out.println(info);
	}

}
