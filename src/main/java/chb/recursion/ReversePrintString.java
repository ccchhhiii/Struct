package chb.recursion;

/**
 * 递归操作之反转字符串
 */
public class ReversePrintString {

    public static void f(int n,String str){
        if(n==str.length()){
            return;
        }
        f(n+1,str);
        System.out.println(str.charAt(n));
    }

    public static void main(String[] args) {
        f(0,"abcd");
    }
}
