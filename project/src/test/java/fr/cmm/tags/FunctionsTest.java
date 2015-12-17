package fr.cmm.tags;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class FunctionsTest {

    @Test
    public void replacementFunction() {
        assertEquals("a", Functions.replacement("a"));
        assertEquals("a<br>", Functions.replacement("a\n"));
        assertEquals("&a", Functions.replacement("&a"));
    }

}