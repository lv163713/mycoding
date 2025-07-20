package day01.smartHomeSystem;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // 我接下来要创建一个智能家居系统
        JD[] jd = new JD[2];
        Scanner scanner = new Scanner(System.in);
        jd[0] = new Light("欧普",true);
        jd[1] = new Washer("美的",true);
        while(true){
            // 设置一个应用台操作界面,通过switch来选择操作的家电或者退出，再选择转换家电的状态
            System.out.println("请选择操作：1. 打开家电 2. 关闭家电 3. 打印家电状态 4. 退出");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("请选择家电：1. 灯 2. 洗衣机");
                    int choice1 = scanner.nextInt();
                    switch (choice1) {
                        case 1:
                            jd[0].press();
                            break;
                        case 2:
                            jd[1].press();
                            break;
                        default:
                            System.out.println("请输入正确的家电编号");
                    }
                    break;

            }

        }
    }
    // 打印目前全部的家电状态
    public static void printAll(JD[] jds){
        for (JD jd : jds) {
            System.out.println(jd.toString());
        }
    }

}
