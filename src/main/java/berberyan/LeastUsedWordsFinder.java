package berberyan;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LeastUsedWordsFinder {

	public List<String> topLongestLeastUsed(Map<String,Integer> dictionary){
		if(dictionary == null){
			return new ArrayList<>();
		}

		return	dictionary.entrySet().stream()
				.sorted(Map.Entry.<String, Integer>comparingByValue()
						.thenComparing(this::sortByLength))
				.limit(10)
				.map(Map.Entry::getKey)
				.collect(Collectors.toList());
	}

	public int sortByLength(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2){
		if(e1.getValue() == e2.getValue()){
			return e2.getKey().length() - e1.getKey().length();		
		}
		return 0;
	}

}
