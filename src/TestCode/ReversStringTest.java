package TestCode;

import Algorithms.ReversString;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ReversStringTest {

    String input;
    String[] wordAry;

    String correctResult = "cba 321 elppa";

    @Before
    public void setInput() {
        input = "abc 123 apple";

        wordAry = input.split(" ");
    }

    @Test
    public void checkInput() {
        Assert.assertNotNull(wordAry);
        Assert.assertTrue(wordAry.length == 3);
        Assert.assertEquals("abc", wordAry[0]);
        Assert.assertEquals("123", wordAry[1]);
        Assert.assertEquals("apple", wordAry[2]);
    }

    @Test
    public void getReverseString() {
        Assert.assertNotNull(wordAry);
        String result = ReversString.convertToReverse(wordAry);

        Assert.assertEquals(correctResult, result);
    }
}