package com.example.coding_task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Objects;

class AddTwoNumbersTest
{
    @Test
    void test()
    {
        Assertions.assertEquals(convert(new int[] {7,0,8}), testImpl(convert(new int[] {2,4,3}), convert(new int[] {5,6,4})));
        Assertions.assertEquals(convert(new int[] {0}), testImpl(convert(new int[] {0}), convert(new int[] {0})));
        Assertions.assertEquals(convert(new int[] {8,9,9,9,0,0,0,1}), testImpl(convert(new int[] {9,9,9,9,9,9,9}), convert(new int[] {9,9,9,9})));
    }

    private ListNode convert(int[] ints)
    {
        int i = ints.length -1;
        ListNode result = new ListNode(ints[i]);
        i--;
        while (i>=0)
        {
            result = new ListNode(ints[i], result);
            i--;
        }
        return result;
    }

    private ListNode testImpl(ListNode l1, ListNode l2)
    {
        ListNode result = new ListNode();
        sum(l1, l2, result, 0);
        return result;
    }

    private ListNode sum(ListNode l1, ListNode l2, ListNode result, int carry)
    {
        int sum = l1.val + l2.val + carry;
        int nextCarry = sum/10;
        result.val = sum % 10;
        if(l1.next == null && l2.next == null)
        {
            if(nextCarry>0)
            {
                result.next = new ListNode(nextCarry);
            }
            return result;
        }

        if(l1.next == null)
        {
            l1.next = new ListNode(0);
        }
        if(l2.next == null)
        {
            l2.next = new ListNode(0);
        }
        result.next = new ListNode();
        return sum(l1.next, l2.next, result.next, nextCarry);
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ListNode listNode = (ListNode) o;
            return val == listNode.val && Objects.equals(next, listNode.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, next);
        }
    }
}
