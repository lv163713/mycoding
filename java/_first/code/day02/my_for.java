package day02;

public class my_for {
    public static void main(String[] args) {
        //调用一个方法，从键盘上获取两个数字
        int a = getNum();
        int b = getNum();
        //调用一个方法，求这两个数之间的前缀和
        int sum = getSum(a, b);
        System.out.println("sum = " + sum);
    }

    public static int getNum() {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.println("请输入数字：");
        int num = sc.nextInt();
        sc.close();
        return num;
    }

    public static int getSum(int a, int b) {
        int sum = 0;
        for (int i = a; i <= b; i++) {
            sum += i;
        }
        return sum;
    }
 
}
