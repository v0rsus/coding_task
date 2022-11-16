import java.util.Collections;
import java.util.Map;
import java.util.stream.Stream;

class AtoriTest extends BaseStrInIntOutTest
{
	static Stream<Map<String, Integer>> input() {
		return Stream.of(
			Collections.singletonMap("42", 42),
			Collections.singletonMap("   -42", -42),
			Collections.singletonMap("4193 with words", 4193),
			Collections.singletonMap("words first 4193", 0),
			Collections.singletonMap("only words and fans", 0),
			Collections.singletonMap("-91283472332", -2147483648),
			Collections.singletonMap("-", 0),
			Collections.singletonMap("+", 0),
			Collections.singletonMap("", 0),
			Collections.singletonMap(" ", 0)
		);
	}

	@Override
	protected int testImpl(String s)
	{
		int result = 0;
		if (s.isEmpty())
		{
			return result;
		}
		Character whitespace = ' ';
		Character plus = '+';
		Character minus = '-';
		int i = 0;
		while (i < s.length() && whitespace.equals(s.charAt(i)))
		{
			i++;
		}
		boolean isNegative = i < s.length()-1 && minus.equals(s.charAt(i)) && Character.isDigit(s.charAt(i + 1));
		if (i < s.length()-1 && (isNegative || plus.equals(s.charAt(i))))
		{
			i++;
		}
		while (i < s.length() && Character.isDigit(s.charAt(i)))
		{
			int digit = s.charAt(i) - '0';
			if (result > (Integer.MAX_VALUE - digit)/10)
			{
				return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
			}
			result = result * 10 + digit;
			i++;
		}

		return isNegative ? -result : result;
	}
}
