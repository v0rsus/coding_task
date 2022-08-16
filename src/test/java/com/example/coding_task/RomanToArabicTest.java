package com.example.coding_task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

class RomanToArabicTest
{
	@ParameterizedTest
	@MethodSource("input")
	void test(Map<String, Integer> input)
	{
		input.forEach((k, v) -> Assertions.assertEquals(v, romanToInt(k)));
	}

	private int romanToInt(String s) {
		Map<Character, Integer> alpabet = new HashMap<>();
		alpabet.put('I', 1);
		alpabet.put('V', 5);
		alpabet.put('X', 10);
		alpabet.put('L', 50);
		alpabet.put('C', 100);
		alpabet.put('D', 500);
		alpabet.put('M', 1000);


		int cnt = s.length()-1;
		int result = alpabet.get(s.charAt(cnt));
		while(cnt>0)
		{
			int current = alpabet.get(s.charAt(cnt));
			int next = alpabet.get(s.charAt(cnt-1));
			if(current<=next)
			{
				result+=next;
			}
			else
			{
				result-=next;
			}
			cnt--;
		}

		return result;
	}

	static Stream<Map<String, Integer>> input() {
		return Stream.of(
			Collections.singletonMap("III", 3),
			Collections.singletonMap("LVIII", 58),
			Collections.singletonMap("MCMXCIV", 1994)
		);
	}
}
