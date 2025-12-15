package com.demo1;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class StringFunctionsTest {

    @Test
    void testFindLength() {
        assertEquals(6, StringFunctions.findLength("reshni"));
        assertEquals(6, StringFunctions.findLength(" r es h ni "));
        assertEquals(0, StringFunctions.findLength("     "));
        assertEquals(2, StringFunctions.findLength("hi"));
    }

    @Test
    void testWordCount() {
        assertEquals(2, StringFunctions.wordCount("hello world"));
        assertEquals(2, StringFunctions.wordCount("  hello    world  "));
        assertEquals(0, StringFunctions.wordCount(""));
        assertEquals(0, StringFunctions.wordCount("      "));
        assertEquals(2, StringFunctions.wordCount("Java training"));
    }

    @Test
    void testReverse() {
        assertEquals("olleh", StringFunctions.reverse("hello"));
        assertEquals("321", StringFunctions.reverse("123"));
        assertEquals("", StringFunctions.reverse(""));
        assertEquals("a", StringFunctions.reverse("a"));
    }

    @Test
    void testCharFreq() {
        Map<Character, Integer> map = StringFunctions.charFreq("banana");
        assertEquals(3, map.get('a'));
        assertEquals(2, map.get('n'));
        assertEquals(1, map.get('b'));
        assertFalse(map.containsKey('z')); 
    }
}
