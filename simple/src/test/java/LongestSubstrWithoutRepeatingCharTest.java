import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

class LongestSubstrWithoutRepeatingCharTest extends BaseStrInIntOutTest
{
	static Stream<Map<String, Integer>> input() {
		return Stream.of(
			Collections.singletonMap("abcabcbb", 3),
			Collections.singletonMap("bbbbb", 1),
			Collections.singletonMap("pwwkew", 3)
		);
	}

	@Override
	protected int testImpl(String s)
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
