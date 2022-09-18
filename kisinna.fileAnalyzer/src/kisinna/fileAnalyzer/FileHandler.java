package kisinna.fileAnalyzer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;
import java.util.TreeMap;

public class FileHandler {
	private static final String SPLITTER = "[^a-zA-Zа-яА-Я]";

	public File getFileByPath(String strPath) {
		Path path = Path.of(strPath);
		if (!path.isAbsolute()) {
			path = path.toAbsolutePath();
		}
		return path.toFile();
	}

	public Map<String, Integer> getFreqMap(String strPath) throws FileNotFoundException, IOException {
		return getFreqMap(getFileByPath(strPath));
	}

	public Map<String, Integer> getFreqMap(File file) throws IOException, FileNotFoundException {
		Map<String, Integer> map = new TreeMap<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line;

			while ((line = reader.readLine()) != null) {
				String[] array = line.split(SPLITTER);
				for (String s : array) {
					s = s.trim().toLowerCase();
					if (s.isEmpty())
						continue;
					map.putIfAbsent(s, 0);
					map.put(s, map.get(s) + 1);
				}
			}
		}
		return map;
	}
}
