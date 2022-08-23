package com.example.coding_task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

class PalindromeLinkedListTest
{
    static Stream<Map<ListNode, Boolean>> input()
    {
        return Stream.of(
                Collections.singletonMap(convert(new int[] {1, 2, 2, 1}), true),
                Collections.singletonMap(convert(new int[] {1, 2}), false)
        );
    }

    private static ListNode convert(int[] input)
    {
        ListNode result = new ListNode(input[input.length - 1]);
        for(int i=input.length-2;i>=0;i--)
        {
            result = new ListNode(input[i], result);
        }
        return result;
    }

    @ParameterizedTest
    @MethodSource("input")
    void test(Map<ListNode, Boolean> input)
    {
        input.forEach((k, v) -> Assertions.assertEquals(v, testImpl(k)));
    }

    protected boolean testImpl(ListNode head)
    {
        List<Integer> headAsList = new ArrayList<>();
        while (head != null)
        {
            headAsList.add(head.val);
            head = head.next;
        }
        int i = 0;
        int j = headAsList.size() - 1;
        while (i <= j)
        {
            if(!Objects.equals(headAsList.get(i), headAsList.get(j)))
            {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

private static class ListNode
{
    int val;
    ListNode next;

    ListNode()
    {

    }

    ListNode(int val)
    {
        this.val = val;
    }

    ListNode(int val, ListNode next)
    {
        this.val = val; this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}

}
