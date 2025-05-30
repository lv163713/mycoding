package day02;

import java.util.Scanner;

class ez_calc {
    public static void main(String[] args) {
        //需求：简易板计算器开发
        // 1. 键盘录入两个数字
        int a = getNum();
        int b = getNum();

        // 2. 键盘录入一个运算符
        char op = getOp();

        // 3. 根据运算符，调用方法去计算两个数字的结果
        int result = calc(a, b, op);
        // 4. 输出结果，格式为a ** b = result
        System.out.println(a + " " + op + " " + b + " = " + result);
    }
    
    public static int getNum() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个数字：");
        int num = sc.nextInt();
        sc.close();
        return num;
    }

    public static char getOp() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个运算符：");
        char op = sc.next().charAt(0);
        //检查输入是否合法
        while (!(op == '+' || op == '-' || op == '*' || op == '/')) {
            System.out.println("输入有误，请重新输入：");
            op = sc.next().charAt(0);
        }
        sc.close();
        return op;
    }

    public static int calc(int a, int b, char op) {
        int result = 0;
        switch (op) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                result = a/ b;
        }
        return result;
    }
}