package TestCode;

import Algorithms.FibonacciQuiz;
import org.junit.Assert;
import org.junit.Test;

public class FibonacciQuizTest {

    @Test
    public void makeFibo() {
        Assert.assertEquals(44, FibonacciQuiz.fibonacciEvenSum(35));
        Assert.assertNotEquals(43, FibonacciQuiz.fibonacciEvenSum(35));
    }
}