package leastUsedWords;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import berberyan.TextProcessor;

public class TextProcessorTest {

	Map<String, Integer> actual;
	Map<String,Integer> expected;
	
	@Before
	public void init(){
		expected = new HashMap<String,Integer>();
	}
	
	@Test
	public void getWords_singleWordString() throws IOException{
		String singleWord= "test";
		Reader sr = new StringReader(singleWord);
		TextProcessor textProcessor = new TextProcessor();
		
		actual = textProcessor.getWords(sr);

		expected.put(singleWord, 1);
		assertEquals(expected,actual);
	}

	@Test
	public void getWords_sentenceWithoutPunctuation() throws IOException{
		String singleWord= "He skipped";
		Reader sr = new StringReader(singleWord);
		TextProcessor textProcessor = new TextProcessor();
		
		actual = textProcessor.getWords(sr);

		expected.put("he", 1);
		expected.put("skipped", 1);
		assertEquals(expected,actual);
	}

	@Test
	public void getWords_sentenceWithPunctuation() throws IOException{
		String singleWord= "He skipped";
		Reader sr = new StringReader(singleWord);
		TextProcessor textProcessor = new TextProcessor();
		
		actual = textProcessor.getWords(sr);

		expected.put("he", 1);
		expected.put("skipped", 1);
		assertEquals(expected,actual);
	}

	@Test
	public void getWords_twoSameWords() throws IOException{
		String singleWord= "Skipped skipped";
		Reader sr = new StringReader(singleWord);
		TextProcessor textProcessor = new TextProcessor();
		
		actual = textProcessor.getWords(sr);

		expected.put("skipped", 2);
		assertEquals(expected,actual);
	}
}
