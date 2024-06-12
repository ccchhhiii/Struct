package chb.recursion;

/**
 * @author chihb
 * @create-time 2024/6/9 22:15
 * @description
 */
public class E05InsertionSort {
    //插入排序普通版
//    这个算法的工作原理是，它首先取数组中的下一个元素（从第二个元素开始），然后与前面的元素进行比较。如果前面的元素大于当前元素，就将其向右移动一位。
//    然后，将当前元素放到合适的位置。这个过程会重复进行，直到所有的元素都被排序。
//    插入排序的工作原理是将每一个元素插入到其正确的位置，因此，它很适合于小型的数组或者部分排序的数组。然而，对于大型的随机数组，插入排序的性能可能不是很好，因为它的时间复杂度是O(n^2)。
    public void insertionSort(int[] arr){
        for(int i=1;i<arr.length;i++){
            int key=arr[i];
            int j=i-1;
            // 将大于key的元素向右移动一位
            while (j>=0&&arr[j]>key){
                arr[j+1]=arr[j];
                j=j-1;
            }
            arr[j+1]=key;
        }
    }

    //递归插入排序
    public static void sort(int[] a){
        insertion(a,1);
    }
    // low未排序区的下边界
    public static void insertion(int[] a,int low){
        if(low==a.length){
            return;
        }

        int t=a[low];
        int i=low-1;//已排序区指针
        while (i>=0&&a[i]>t){//没有找到插入位置
            a[i+1]=a[i];//比插入元素大就右移，空出位置
            i--;
        }
        //找到了插入位置
        if(i+1!=low){//这个if是当干好要排在low的位置
            a[i+1]=t;
        }
        insertion(a,low+1);
    }
}
