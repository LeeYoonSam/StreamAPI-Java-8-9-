package TestCode;

import Algorithms.SecondLargest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SecondLargestTest {

    SecondLargest secondLargest;

    @Before
    public void setSecondLargest() {
        this.secondLargest = new SecondLargest();
    }

    @Test
    public void findSecondLargest() {
        String[] nums1 = {"1", "2", "3", "4", "5"};
        String[] nums2 = {"-1", "-2", "-3", "-4", "-5"};
        String[] nums3 = {"10", "-2", "1", "9", "-20"};
        String[] nums4 = {"-20", "-10", "-5", "-1", "0"};
        String[] nums5 = {"1", "1", "1"};
        String[] nums6 = {"1"};
        String[] nums7 = {"1", "2"};
        String[] nums8 = null;

        Assert.assertEquals("4", secondLargest.findSecondLargest(nums1));
        Assert.assertEquals("-2", secondLargest.findSecondLargest(nums2));
        Assert.assertEquals("9", secondLargest.findSecondLargest(nums3));
        Assert.assertEquals("-1", secondLargest.findSecondLargest(nums4));
        Assert.assertEquals(SecondLargest.NOT_EXIST_MESSAGE, secondLargest.findSecondLargest(nums5));
        Assert.assertEquals(SecondLargest.NOT_EXIST_MESSAGE, secondLargest.findSecondLargest(nums6));
        Assert.assertEquals("1", secondLargest.findSecondLargest(nums7));
        Assert.assertEquals(SecondLargest.NOT_EXIST_MESSAGE, secondLargest.findSecondLargest(nums8));
    }
}