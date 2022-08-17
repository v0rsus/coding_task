package com.example.coding_task;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

class FirstUniqueCharTest extends BaseStrInIntOutTest
{
	static Stream<Map<String, Integer>> input() {
		return Stream.of(
			Collections.singletonMap("leetcode", 0),
			Collections.singletonMap("loveleetcode", 2),
			Collections.singletonMap("baabb", -1),
			Collections.singletonMap("aabb", -1)
		);
	}

	@Override
	protected int testImpl(String s)
	{
		Map<Character, Integer> cnt = new HashMap<>();
		for(int i=0;i<s.length();i++)
		{
			char c = s.charAt(i);
			cnt.put(c, cnt.getOrDefault(c, 0)+1);
		}

		for(int i=0;i<s.length();i++)
		{
			if(cnt.get(s.charAt(i)) == 1)
			{
				return i;
			}
		}
		return -1;
	}

//	public int firstUniqChar(String s)
//	{
//		int result = 0;
//		Map<Character, Integer> uniqueChars = new HashMap<>();
//		for(int i=s.length()-1;i>=0;i--)
//		{
//			if (uniqueChars.putIfAbsent(s.charAt(i), 1) == null)
//			{
//				result = i;
//			}
//		}
//
//		return result;
//	}
}
