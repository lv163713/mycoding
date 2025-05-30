package day02;

import java.util.Scanner;

public class check {
    public static void main(String[] args) {
        
        //输入要指定的位数
        System.out.println("请输入要指定的位数：");
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();

        // 调用方法，生成一个指定位数的验证码，并返回
        String code = getCode(num);

        System.out.println("生成的验证码是：" + code);
        sc.close();
    }

    public static String getCode(int length) {
        String code = "";
        for (int i = 0; i < length; i++) {
            int num = (int) (Math.random() * 10);
            code += num;
        }
        return code;
    }
}
