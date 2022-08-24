package com.example.coding_task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

class RemoveDuplicatesFromSortedArrayTest
{
    static Stream<Map<int[], Integer>> input() {
        return Stream.of(
                Collections.singletonMap(new int[] {1,1,2}, 2),
                Collections.singletonMap(new int[] {0,0,1,1,1,2,2,3,3,4}, 5)
        );
    }

    @ParameterizedTest
    @MethodSource("input")
    void test(Map<int[], Integer> input)
    {
        input.forEach((k, v) -> Assertions.assertEquals(v, testImpl(k)));
    }

//    private int testImpl(int[] nums)
//    {
//        Set<Integer> uniqSet = new LinkedHashSet<>();
//        for (int num : nums)
//        {
//            uniqSet.add(num);
//        }
//        Integer[] uniqArr = uniqSet.toArray(new Integer[0]);
//        for (int i=0;i<uniqSet.size();i++)
//        {
//            nums[i] = uniqArr[i];
//        }
//
//        for (int num : nums)
//        {
//            System.out.println(num);
//        }
//        return uniqArr.length;
//    }

    private int testImpl(int[] nums)
    {
        int start = 1;
        int curr = nums[0];
        int count = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=curr){
                nums[start] = nums[i];
                curr = nums[i];
                start++;
                count++;
            }
        }
        return count;
    }
}
