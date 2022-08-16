package com.example.coding_task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

class LongestSubstrWithoutRepeatingCharTest
{
	static Stream<Map<String, Integer>> input() {
		return Stream.of(
			Collections.singletonMap("abcabcbb", 3),
			Collections.singletonMap("bbbbb", 1),
			Collections.singletonMap("pwwkew", 3)
		);
	}

	@ParameterizedTest
	@MethodSource("input")
	void test(Map<String, Integer> input)
	{
		input.forEach((k, v) -> Assertions.assertEquals(v, lengthOfLongestSubstring(k)));
	}

	public int lengthOfLongestSubstring(String s)
	{
		int result = 0;
		int length = s.length();
		for(int i=0;i<length;i++)
		{
			Map<Character, Integer> freq = new HashMap<>();
			int j = 0;
			while (i+j < length && freq.putIfAbsent(s.charAt(i+j), 1) == null)
			{
				j++;
			}
			result = Math.max(result, j);
		}
		return result;
	}
}
