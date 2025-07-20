package day01.payDome;
import java.util.Scanner;
//加油站支付小模块
public class Main {
    public static void main(String[] args) {
        // 1.创建卡片类，以便创建金卡银卡对象，封装卡片父类
        // 2.定义卡片父类，封装共同方法
        // 3.定义金卡类和银卡类，继承卡片父类，消费大于200打印洗车票
        // 4.编写办卡业务
        goldCard user1 = new goldCard("京A","曼巴","12345678",5000);
        pay(user1);
        silverCard user2 = new silverCard("京B","小王","12345678",2000);
        pay(user2);
    }

    public static void pay(card c){
        System.out.println("请输入消费金额：");
        Scanner sc = new Scanner(System.in);
        double money = sc.nextDouble();
        c.consume(money);
    }
     
}
