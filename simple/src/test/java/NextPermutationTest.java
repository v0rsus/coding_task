import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class NextPermutationTest
{
    @Test
    void test()
    {
        int[] input_0 = new int[] {1,2,3};
        testImpl(input_0);
        Assertions.assertArrayEquals(new int[] {1,3,2}, input_0);
        int[] input_1 = new int[] {3,2,1};
        testImpl(input_1);
        Assertions.assertArrayEquals(new int[] {1,2,3}, input_1);
        int[] input_2 = new int[] {1,1,5};
        testImpl(input_2);
        Assertions.assertArrayEquals(new int[] {1,5,1}, input_2);
    }

    private void testImpl(int[] nums)
    {
        int i = nums.length-1;
        while (i>0 && nums[i]<=nums[i-1])
        {
            i--;
        }
        if(i>0)
        {
            int firstDecreasingElementIndex = i-1;
            int firstLargerThenDecElemIndex = nums.length-1;
            while(nums[firstDecreasingElementIndex]>=nums[firstLargerThenDecElemIndex])
            {
                firstLargerThenDecElemIndex--;
            }
            swap(nums, firstDecreasingElementIndex, firstLargerThenDecElemIndex);
        }
        reverse(nums, i);
    }

    private void swap(int[] nums, int i, int j)
    {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int[] nums, int fromIdx)
    {
        int[] copyNums = Arrays.copyOf(nums, nums.length);
        for(int i=fromIdx, j=nums.length-1;i<nums.length;i++, j--)
        {
            nums[i] = copyNums[j];
        }
    }
}
