package chb.recursion;

//递归操作之阶乘
public class Factorial {
    public static int f(int n) {
        if (n == 1) {
            return 1;
        }
        return n * f(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(f(5));
    }
}
