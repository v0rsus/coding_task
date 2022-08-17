package com.example.coding_task;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

class RomanToArabicTest extends BaseStrInIntOutTest
{
	static Stream<Map<String, Integer>> input() {
		return Stream.of(
			Collections.singletonMap("III", 3),
			Collections.singletonMap("LVIII", 58),
			Collections.singletonMap("MCMXCIV", 1994)
		);
	}

	@Override
	protected int testImpl(String s) {
		Map<Character, Integer> alphabet = new HashMap<>();
		alphabet.put('I', 1);
		alphabet.put('V', 5);
		alphabet.put('X', 10);
		alphabet.put('L', 50);
		alphabet.put('C', 100);
		alphabet.put('D', 500);
		alphabet.put('M', 1000);


		int cnt = s.length()-1;
		int result = alphabet.get(s.charAt(cnt));
		while(cnt>0)
		{
			int current = alphabet.get(s.charAt(cnt));
			int next = alphabet.get(s.charAt(cnt-1));
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
}
