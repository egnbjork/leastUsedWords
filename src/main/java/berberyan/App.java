package berberyan;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class App {

	public static void main(String[] args) throws IOException {

		Reader file = ReadFile.fileToReader(args[0]);
		TextProcessor textMap = new TextProcessor();
		LeastUsedWordsFinder finder = new LeastUsedWordsFinder();

		List<String> words = finder.topLongestLeastUsed(textMap.getWords(file));

		for(String word : words){
			System.out.println(word);
		}
	}

}
