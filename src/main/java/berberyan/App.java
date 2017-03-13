package berberyan;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {
	private static final Logger LOGGER = LogManager.getLogger(App.class); 
	
	private App(){}

	public static void main(String[] args) throws IOException {

		Reader file = ReadFile.fileToReader(args[0]);
		TextProcessor textMap = new TextProcessor();
		LeastUsedWordsFinder finder = new LeastUsedWordsFinder();

		List<String> words = finder.topLongestLeastUsed(textMap.getWords(file));

		for(String word : words){
			LOGGER.info(word);
		}
	}

}
