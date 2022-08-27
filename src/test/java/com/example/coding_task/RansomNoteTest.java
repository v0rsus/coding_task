package com.example.coding_task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

class RansomNoteTest
{
    @Test
    void test()
    {
        Assertions.assertFalse(testImpl("a", "b"));
        Assertions.assertFalse(testImpl("aa", "ab"));
        Assertions.assertTrue(testImpl("aa", "aab"));
    }

    private boolean testImpl(String ransomNote, String magazine)
    {
        List<Character> magazineChars = magazine.chars().mapToObj(e->(char)e).collect(Collectors.toList());
        for(Character c : ransomNote.toCharArray())
        {
            if(!magazineChars.remove(c))
            {
                return false;
            }
        }
        return true;
    }
}
