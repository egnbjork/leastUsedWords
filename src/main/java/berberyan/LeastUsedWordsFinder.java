package berberyan;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class LeastUsedWordsFinder {

	public List<String> topLongestLeastUsed(Map<String,Integer> dictionary){
		if(dictionary == null){
			return null;
		}
		
		return	dictionary.entrySet().stream()
			.sorted(Map.Entry.<String, Integer>comparingByValue().thenComparing(LeastUsedWordsFinder::sortByLength))
			.limit(10)
			.map(n->n.getKey())
			.collect(Collectors.toList());
	}

	public static int sortByLength(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2){
		if(e1.getValue() == e2.getValue()){
			return e2.getKey().length() - e1.getKey().length();		
		}
		return 0;
	}

}
