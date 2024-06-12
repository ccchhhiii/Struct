package chb.recursion;

/**
 * 递归操作之冒号排序
 */
public class E04BubbleSort {
    //普通的冒号排序
    public static void sort1(int[] a){
        for(int i=0;i<a.length-1;i++){
            for(int j=0;j<a.length-i-1;j++){
                if(a[j]>a[j+1]){
                    int temp=a[j+1];
                    a[j]=temp;
                    a[j+1]=a[j];
                }
            }
        }
    }


    //使用递归的冒号排序      j代表为排序区域右边界
    private static void bubble(int[] a,int j){
        if(j==0){
            return;
        }
        //x是已排序和未排序的分界线，x是递归冒号排序的优化
        int x=0;
        for(int i=0;i<j;i++){
            if(a[i]>a[i+1]){
                int t=a[i];
                a[i]=a[i+1];
                a[i+1]=t;
                x=i;
            }
        }
        //最大的元素会被排到最右边
        bubble(a,x);
    }

    public static void sort2(int[] a){
        bubble(a,a.length-1);
    }
}
