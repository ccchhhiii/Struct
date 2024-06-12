package chb.recursion;

/**
 * 使用递归算法，容易出现暴栈问题，因为每一次方法的调用都会在栈内存里存储数据而递归方法在执行结束前都不会结束方法
 * 解决方法可以使用尾调用和普通的for循环来解决
 */




//递归求和
public class E06Sum {

    public static long sum(int n){
        if(n==1){
            return 1;
        }
        return  sum(n-1)+n;
    }


    public static void main(String[] args) {
        System.out.println(sum(10));
    }
}
