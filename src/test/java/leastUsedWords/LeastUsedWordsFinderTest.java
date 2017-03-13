package leastUsedWords;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Test;

import berberyan.LeastUsedWordsFinder;
import berberyan.TextProcessor;

public class LeastUsedWordsFinderTest {

	@Test
	public void topLongestLeastUsed_null(){

		LeastUsedWordsFinder finder = new LeastUsedWordsFinder();

		List<String> actual = finder.topLongestLeastUsed(null);
		
		assertEquals(new ArrayList<String>(),actual);
	}
	
	@Test
	public void topLongestLeastUsed_WordsSameSizeCompareByUseCount() throws IOException{
		String text = "word first word frist word";
		TextProcessor textProcessor = new TextProcessor();
		Map<String, Integer> dictionary = textProcessor.getWords(new StringReader(text));
		LeastUsedWordsFinder finder = new LeastUsedWordsFinder();

		List<String> actual = finder.topLongestLeastUsed(dictionary);
		
		Map<String, Integer> expected = new LinkedHashMap<>();
		expected.put("first", 1);
		expected.put("frist", 1);
		expected.put("word", 2);
		List<String> expectedOrdered = mapToList(expected);
				
		assertEquals(expectedOrdered, actual);
	}

	@Test
	public void topLongestLeastUsed_WordsSameLengthCompareByFrequency() throws IOException{
		String text = "bfirst, alonge, bfirst cthird";
		TextProcessor textProcessor = new TextProcessor();
		Map<String, Integer> dictionary = textProcessor.getWords(new StringReader(text));
		LeastUsedWordsFinder finder = new LeastUsedWordsFinder();

		List<String> actual = finder.topLongestLeastUsed(dictionary);
				
		Map<String, Integer> expected = new LinkedHashMap<>();
		expected.put("alonge", 1);
		expected.put("cthird", 1);
		expected.put("bfirst", 2);
		List<String> expectedOrdered = mapToList(expected);
				
		assertEquals(expectedOrdered, actual);
	}

	@Test
	public void topLongestLeastUsed_WordsSameFreqCompareByLength() throws IOException{
		String text = "first, longer, first- longer biggest biggest";
		TextProcessor textProcessor = new TextProcessor();
		Map<String, Integer> dictionary = textProcessor.getWords(new StringReader(text));
		LeastUsedWordsFinder finder = new LeastUsedWordsFinder();

		List<String> actual = finder.topLongestLeastUsed(dictionary);
		
		Map<String, Integer> expected = new LinkedHashMap<>();
		expected.put("biggest", 2);
		expected.put("longer", 2);
		expected.put("first", 2);
		
		List<String> expectedOrdered = mapToList(expected);
		
		assertEquals(expectedOrdered, actual);
	}
	
	@Test
	public void topLongestLeastUsed_threeWordsSameLengthCompareByFrequency() throws IOException{
		String text = "bfirst, alonge, bfirst, singme, alonge, alonge";
		TextProcessor textProcessor = new TextProcessor();
		Map<String, Integer> dictionary = textProcessor.getWords(new StringReader(text));
		LeastUsedWordsFinder finder = new LeastUsedWordsFinder();

		List<String> actual = finder.topLongestLeastUsed(dictionary);
		
		Map<String, Integer> expected = new LinkedHashMap<>();
		expected.put("singme", 1);
		expected.put("bfirst", 2);
		expected.put("alonge", 3);
		
		List<String> expectedOrdered = mapToList(expected);
		
		assertEquals(expectedOrdered, actual);
	}

	@Test
	public void topLongestLeastUsed_threeWordsSameFreqCompareByLength() throws IOException{
		String text = "first, longerr, first- longerr, thebiggest, thebiggest";
		TextProcessor textProcessor = new TextProcessor();
		Map<String, Integer> dictionary = textProcessor.getWords(new StringReader(text));
		LeastUsedWordsFinder finder = new LeastUsedWordsFinder();

		List<String> actual = finder.topLongestLeastUsed(dictionary);
		
		Map<String, Integer> expected = new LinkedHashMap<>();
		expected.put("thebiggest", 2);
		expected.put("longerr", 2);
		expected.put("first", 2);
		
		List<String> expectedOrdered = mapToList(expected);
		
		assertEquals(expectedOrdered, actual);
	}
	
		
	@Test
	public void topLongestLeastUsed_threeWordsDiffFreqCompareDiffLength() throws IOException{
		String text = "first, longerr, thebiggest first- longerr,  longerr";
		TextProcessor textProcessor = new TextProcessor();
		Map<String, Integer> dictionary = textProcessor.getWords(new StringReader(text));
		LeastUsedWordsFinder finder = new LeastUsedWordsFinder();

		List<String> actual = finder.topLongestLeastUsed(dictionary);
		
		Map<String, Integer> expected = new LinkedHashMap<>();

		expected.put("thebiggest", 1);
		expected.put("first", 2);
		expected.put("longerr", 3);
		
		List<String> expectedOrdered = mapToList(expected);
		
		assertEquals(expectedOrdered, actual);
	}
	
	@Test
	public void sortByLength_threeWordsDiffLength() throws IOException{
		String text = "first thebiggest , longerr, ";
		TextProcessor textProcessor = new TextProcessor();
		Map<String, Integer> dictionary = textProcessor.getWords(new StringReader(text));
		LeastUsedWordsFinder finder = new LeastUsedWordsFinder();

		List<String> actual = finder.topLongestLeastUsed(dictionary);
		
		Map<String, Integer> expected = new LinkedHashMap<>();
		expected.put("thebiggest", 1);
		expected.put("longerr", 1);
		expected.put("first", 1);
		
		List<String> expectedOrdered = mapToList(expected);
		
		assertEquals(expectedOrdered, actual);
	}
		
	private List<String> mapToList(Map<String, Integer> words){
		return words.entrySet().stream().map(n->n.getKey()).collect(Collectors.toList());
	}
}
