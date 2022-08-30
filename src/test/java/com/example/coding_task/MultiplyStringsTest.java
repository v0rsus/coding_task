package com.example.coding_task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MultiplyStringsTest {

    @Test
    void test() {
        Assertions.assertEquals("6", testImpl("2", "3"));
        Assertions.assertEquals("56088", testImpl("123", "456"));
        Assertions.assertEquals("419254329864656431168468", testImpl("498828660196", "840477629533"));
    }

    private String testImpl(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        StringBuilder sbNum1 = new StringBuilder(num1).reverse();
        StringBuilder sbNum2 = new StringBuilder(num2).reverse();

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < sbNum1.length() + sbNum2.length(); i++) {
            result.append('0');
        }

        for (int i = 0; i < sbNum2.length(); i++) {
            int number2 = sbNum2.charAt(i) - '0';
            for (int j = 0; j < sbNum1.length(); j++) {
                int number1 = sbNum1.charAt(j) - '0';

                int position = i + j;
                int carry = result.charAt(position) - '0';
                int multiplication = number1 * number2 + carry;
                result.setCharAt(position, (char) (multiplication % 10 + '0'));

                int nextValue = (result.charAt(position + 1) - '0') + (multiplication / 10);
                result.setCharAt(position + 1, (char) (nextValue + '0'));
            }
        }

        if (result.charAt(result.length()-1) == '0')
        {
            result.deleteCharAt(result.length()-1);
        }

        return result.reverse().toString();
    }
}

