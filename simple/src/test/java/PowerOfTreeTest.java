import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Stream;

class PowerOfTreeTest
{
    static Stream<Map<Integer, Boolean>> input() {
        return Stream.of(
                Collections.singletonMap(27, true),
                Collections.singletonMap(0, false),
                Collections.singletonMap(9, true)
        );
    }

    @ParameterizedTest
    @MethodSource("input")
    void test(Map<Integer, Boolean> input)
    {
        input.forEach((k, v) -> Assertions.assertEquals(v, testImpl(k)));
    }

    private boolean testImpl(int n)
    {
        return n>0 && divideByThree(n) == 1;
    }

    private int divideByThree(int n)
    {
        return n % 3 == 0 ?
                divideByThree(n/3) :
                n;
    }
}
