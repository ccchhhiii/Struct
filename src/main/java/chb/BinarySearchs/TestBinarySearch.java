package chb.BinarySearchs;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertEquals;

public class TestBinarySearch {
    @Test
    @DisplayName("binarySearchBasic 找到")
    public void test1(){
        int[] a={7,13,21,30,38,44,52,53};
        Assert.assertEquals(0, BinarySearch.binarySearchBasic(a,7));
        Assert.assertEquals(1, BinarySearch.binarySearchBasic(a,13));
        Assert.assertEquals(2, BinarySearch.binarySearchBasic(a,21));
        Assert.assertEquals(3, BinarySearch.binarySearchBasic(a,30));
        Assert.assertEquals(4, BinarySearch.binarySearchBasic(a,38));
        Assert.assertEquals(5, BinarySearch.binarySearchBasic(a,44));
        Assert.assertEquals(6, BinarySearch.binarySearchBasic(a,52));
        Assert.assertEquals(7, BinarySearch.binarySearchBasic(a,53));

    }
    @Test
    @DisplayName("binarySearchBasic 未找到")
    public void test2(){
        int[] a={7,13,21,30,38,44,52,53};
        Assert.assertEquals(-1, BinarySearch.binarySearchBasic(a,0));
        Assert.assertEquals(-1, BinarySearch.binarySearchBasic(a,15));
        Assert.assertEquals(-1, BinarySearch.binarySearchBasic(a,60));
    }
}
