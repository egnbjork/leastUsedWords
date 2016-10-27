package berberyan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.LinkedHashMap;
import java.util.Map;

public class TextProcessor {
	static Map<String,Integer> wordCounter;

	public Map<String,Integer> getWords(Reader text) throws IOException{
		String line;
		BufferedReader br = new BufferedReader(text);

		wordCounter = new LinkedHashMap<String,Integer>();
		while((line = br.readLine()) != null){
			String[] wordsOnly = line.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
			for(String word : wordsOnly){
				addWords(word);
			}
		}

		return wordCounter;
	}

	private static void addWords(String word){
		if(wordCounter.containsKey(word)){
			wordCounter.put(word, wordCounter.get(word)+1);
		}
		else{
			wordCounter.put(word, 1);
		}
	}
}
