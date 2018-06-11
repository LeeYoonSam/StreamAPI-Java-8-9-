package TestCode;

import Algorithms.ZeroRightAlign;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class ZeroRightAlignTest {

    ArrayList<Integer> expectedResult1;
    ArrayList<Integer> expectedResult2;

    ArrayList<Integer> input1;
    ArrayList<Integer> input2;
    @Before
    public void setDatas() {
        input1 = new ArrayList<>(){{
            add(0);
            add(5);
            add(0);
            add(3);
            add(-1);
        }};

        input2 = new ArrayList<>(){{
            add(3);
            add(0);
            add(3);
        }};

        expectedResult1 = new ArrayList<>(){{
            add(5);
            add(3);
            add(-1);
            add(0);
            add(0);
        }};

        expectedResult2 = new ArrayList<>(){{
            add(3);
            add(3);
            add(0);
        }};
    }

    @Test
    public void moveZero() {
        ZeroRightAlign zeroRightAlign = new ZeroRightAlign();

        ArrayList<Integer> result1 = zeroRightAlign.moveZero(input1);
        ArrayList<Integer> result2 = zeroRightAlign.moveZero(input2);

        Assert.assertNotNull(result1);
        Assert.assertEquals(expectedResult1, result1);

        Assert.assertNotNull(result2);
        Assert.assertEquals(expectedResult2, result2);
    }
}