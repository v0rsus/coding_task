import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

class UniqueMorseCodeWordsTest
{
	static Stream<Map<List<String>, Integer>> input() {
		return Stream.of(
			Collections.singletonMap(Arrays.asList("gin","zen","gig","msg"), 2),
			Collections.singletonMap(Collections.singletonList("a"), 1)
		);
	}

	@ParameterizedTest
	@MethodSource("input")
	void test(Map<List<String>, Integer> input)
	{
		input.forEach((k, v) -> Assertions.assertEquals(v, testImpl(k)));
	}

	private int testImpl(List<String> words)
	{
		Map<Character, String> morseAlphabet = new HashMap<>();
		morseAlphabet.put('a', ".-");
		morseAlphabet.put('b', "-...");
		morseAlphabet.put('c', "-.-.");
		morseAlphabet.put('d', "-..");
		morseAlphabet.put('e', ".");
		morseAlphabet.put('f', "..-.");
		morseAlphabet.put('g', "--.");
		morseAlphabet.put('h', "....");
		morseAlphabet.put('i', "..");
		morseAlphabet.put('j', ".---");
		morseAlphabet.put('k', "-.-");
		morseAlphabet.put('l', ".-..");
		morseAlphabet.put('m', "--");
		morseAlphabet.put('n', "-.");
		morseAlphabet.put('o', "---");
		morseAlphabet.put('p', ".--.");
		morseAlphabet.put('q', "--.-");
		morseAlphabet.put('r', ".-.");
		morseAlphabet.put('s', "...");
		morseAlphabet.put('t', "-");
		morseAlphabet.put('u', "..-");
		morseAlphabet.put('v', "...-");
		morseAlphabet.put('w', ".--");
		morseAlphabet.put('x', "-..-");
		morseAlphabet.put('y', "-.--");
		morseAlphabet.put('z', "--..");

		Map<String, String> morseToWord = new HashMap<>();
		for(String word : words)
		{
			StringBuilder morse = new StringBuilder();
			for(int i=0;i<word.length();i++)
			{
				morse.append(morseAlphabet.get(word.charAt(i)));
			}
			morseToWord.put(morse.toString(), word);
		}
		return morseToWord.size();
	}
}