package com.example.coding_task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AddBinaryTest
{
    @Test
    void test() {
        Assertions.assertEquals("100", testImpl("11", "1"));
        Assertions.assertEquals("10101", testImpl("1010", "1011"));
    }

    private String testImpl(String a, String b)
    {
        StringBuilder result = new StringBuilder();
        int sum = 0;
        int aLength = a.length()-1;
        int bLength = b.length()-1;

        while(aLength >= 0  || bLength >= 0)
        {
            if(aLength >= 0)
            {
                sum += a.charAt(aLength) - '0';
            }
            if(bLength >= 0)
            {
                sum += b.charAt(bLength) - '0';
            }

            result.append(sum % 2);
            sum /= 2;

            aLength--;
            bLength--;
        }

        if(sum > 0)
        {
            result.append('1');
        }

        return result.reverse().toString();
    }
}
