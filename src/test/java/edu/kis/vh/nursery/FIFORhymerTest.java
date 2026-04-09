package edu.kis.vh.nursery;

import org.junit.Assert;
import org.junit.Test;

public class FIFORhymerTest {

    public static final int TEST_VALUE1 = 1;
    public static final int TEST_VALUE2 = 2;
    public static final int TEST_VALUE3 = 3;
    public static final int EMPTY_STACK_VALUE = -1;
    public static final int STACK_CAPACITY = 12;

    @Test
    public void testCountOutEmpty() {
        FIFORhymer rhymer = new FIFORhymer();

        int result = rhymer.countOut();

        Assert.assertEquals(EMPTY_STACK_VALUE, result);
    }

    @Test
    public void testFIFOOrder() {
        FIFORhymer rhymer = new FIFORhymer();

        rhymer.countIn(TEST_VALUE1);
        rhymer.countIn(TEST_VALUE2);
        rhymer.countIn(TEST_VALUE3);

        int result1 = rhymer.countOut();
        int result2 = rhymer.countOut();
        int result3 = rhymer.countOut();

        Assert.assertEquals(TEST_VALUE1, result1);
        Assert.assertEquals(TEST_VALUE2, result2);
        Assert.assertEquals(TEST_VALUE3, result3);
    }

    @Test
    public void testSingleElement() {
        FIFORhymer rhymer = new FIFORhymer();

        rhymer.countIn(TEST_VALUE1);

        int result = rhymer.countOut();

        Assert.assertEquals(TEST_VALUE1, result);
    }

    @Test
    public void testCallCheck() {
        FIFORhymer rhymer = new FIFORhymer();

        boolean result = rhymer.callCheck();
        Assert.assertEquals(true, result);

        rhymer.countIn(TEST_VALUE1);

        result = rhymer.callCheck();
        Assert.assertEquals(false, result);

        rhymer.countOut();

        result = rhymer.callCheck();
        Assert.assertEquals(true, result);
    }

    @Test
    public void testIsFull() {
        FIFORhymer rhymer = new FIFORhymer();

        for (int i = 0; i < STACK_CAPACITY; i++) {
            rhymer.countIn(i);
        }

        boolean result = rhymer.isFull();

        Assert.assertEquals(true, result);
    }

    @Test
    public void testMixedOperationsFIFO() {
        FIFORhymer rhymer = new FIFORhymer();

        rhymer.countIn(TEST_VALUE1);
        rhymer.countIn(TEST_VALUE2);

        int result1 = rhymer.countOut();

        rhymer.countIn(TEST_VALUE3);

        int result2 = rhymer.countOut();
        int result3 = rhymer.countOut();

        Assert.assertEquals(TEST_VALUE1, result1);
        Assert.assertEquals(TEST_VALUE2, result2);
        Assert.assertEquals(TEST_VALUE3, result3);
    }
}