import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class ThreeSumTest
{
    static Stream input() {
        return Stream.of(
                Collections.singletonMap(new int[] {-1,0,1,2,-1,-4}, Arrays.asList(Arrays.asList(-1,-1,2), Arrays.asList(-1,0,1))),
                Collections.singletonMap(new int[] {0,1,1}, Collections.EMPTY_LIST),
                Collections.singletonMap(new int[] {0,0,0}, Arrays.asList(Arrays.asList(0,0,0)))
        );
    }

    @ParameterizedTest
    @MethodSource("input")
    void test(Map<int[] , List<List<Integer>>> input)
    {
        input.forEach((k, v) -> Assertions.assertEquals(v, testImpl(k)));
    }

    private List<List<Integer>> testImpl(int[] nums)
    {
        //Need to find List<{x, y, z}>
        Map<Integer, List<Integer>> result = new HashMap<>();

        Map<Integer, Integer> uniqNums = new HashMap<>();
        for (int k=0;k<nums.length;k++)
        {
            uniqNums.put(nums[k], k);
        }

        for(int i=0;i<nums.length;i++)
        {
            int x = nums[i];
            for(int j=i+1;j<nums.length;j++)
            {
                int y = nums[j];
                int z = -x-y;
                Integer zPosition = uniqNums.get(z);
                if(zPosition != null && zPosition != i && zPosition != j)
                {
                    List<Integer> found = Stream.of(x, y, z).sorted().collect(Collectors.toList());
                    result.put(found.hashCode(), found);
                }
            }
        }

        return new ArrayList<>(result.values());
    }
}