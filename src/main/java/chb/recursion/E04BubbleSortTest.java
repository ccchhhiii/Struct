package chb.recursion;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * 递归操作之递归二分查找法
 */

public class E04BubbleSortTest {
    @Test
    public void test(){
        int[] expected={1,2,3,4,5};
        int[] a1={5,1,2,4,3};
        E04BubbleSort.sort2(a1);
        assertArrayEquals(expected,a1);
    }
}
