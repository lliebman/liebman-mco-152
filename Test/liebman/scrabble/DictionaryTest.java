package liebman.scrabble;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class DictionaryTest {

    @Test
    public void validateWordThatExists() throws IOException {
        //given
        Dictionary dictionary = new Dictionary();

        //when
        Boolean retVal = dictionary.validateWord("PUL");

        //then
        assertEquals(true, retVal);
    }

    @Test
    public void validateWordThatDoesNotExists() throws IOException {
        //given
        Dictionary dictionary = new Dictionary();

        //when
        Boolean retVal = dictionary.validateWord("ADJ");

        //then
        assertEquals(false, retVal);
    }

    @Test
    public void validateCaseInensitivity() throws IOException {
        //given
        Dictionary dictionary = new Dictionary();

        //when
        Boolean retVal = dictionary.validateWord("Aa");

        //then
        assertEquals(true, retVal);
    }
}
