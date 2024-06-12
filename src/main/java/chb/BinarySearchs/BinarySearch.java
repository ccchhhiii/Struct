package chb.BinarySearchs;

/**
 * @author chihb
 * @create-time 2024/6/7 20:46
 * @description
 */

/**
 * 二分查找的前提是有序序列
 */
public class BinarySearch {

    /**
     * 二分查找基础版
     * Params: a -待检查的升序数组
     * target -待查找的目标值
     * <p>
     * Returns: 找到返回索引值
     * 找不到返回-1
     */
    public static int binarySearchBasic(int[] a, int target) {
        int i = 0, j = a.length - 1;//设置指针和初值
        while (i <= j) {//范围内有东西
            //int m = (i + j) / 2;  因为java的的二进制整数具有最大值，当我们超过最大值时会变成负数，因为除2符号位不参与运算
            int m = (i + j) >>> 1;
            if (target < a[m]) {//目标在中间值的左边
                j = m - 1;
            } else if (a[m] < target) {//目标在中间值的右边
                i = m + 1;
            } else {//找到
                return m;
            }
        }
        return -1;
    }


    //二分查找改动版
    public static int binarySearchAlternative(int[] a, int target) {
        int i = 0, j = a.length;//设置指针和初值
        while (i < j) {//范围内有东西
            int m = (i + j) >>> 1;
            if (target < a[m]) {//目标在中间值的左边
                j = m;
            } else if (a[m] < target) {//目标在中间值的右边
                i = m + 1;
            } else {//找到
                return m;
            }
        }
        return -1;
    }

    //二分查找平衡版：比普通二分查找法最坏的情况快，比最好的情况慢
    public static int binarySearchBalance(int[] a, int target) {
        int i = 0, j = a.length;//设置指针和初值
        while (1 < j - i) {//待查找的元素个数
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m;
            } else {
                i = m;
            }
        }
        //当待查元素只剩1时
        if (a[i] == target) {
            return i;
        } else {
            return -1;
        }
    }

    /**
     * 二分查找法之返回元素最左侧的下标
     */
    public static int binarySearchLeft(int[] a, int target) {
        int i = 0, j = a.length - 1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target <= a[m]) {
                j = m - 1;
            } else if (a[m] < target) {
                i = m + 1;
            }
        }
        return i;
    }

    /**
     * 二分查找法之返回元素最右边的下标
     */
    public static int binarySearchRight(int[] a, int target) {
        int i = 0, j = a.length - 1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m - 1;
            } else if (a[m] <= target) {
                i = m + 1;
            }
        }
        return i-1;
    }
}