package chb.recursion;

import java.util.Arrays;

/**
 * 递归之斐波那契数列
 */
public class E06Fibonacci {

    //普通的斐波那契数列
    public static int f(int n){
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        int x=f(n-1);
        int y=f(n-2);
        return x+y;
    }

    /**
     * 使用Memoization(记忆法，也称备忘录)改进
     * @param n
     */
    public static int fibonacci(int n){
        int[] cache=new int[n+1];
        Arrays.fill(cache,-1);//填充这个数组[-1,-1,-1,-1,-1,-1]
        cache[0]=0;
        cache[1]=1;//[0,1,-1,-1,-1,-1]
        return f1(n,cache);
    }
    public static int f1(int n,int[] cache){
        if(cache[n]!=-1){
            return cache[n];
        }
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        int x=f1(n-1,cache);
        int y=f1(n-2,cache);
        cache[n]=x+y;
        return cache[n];
    }

    public static void main(String[] args) {
        System.out.println(f(6));
    }


}
