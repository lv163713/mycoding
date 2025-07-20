package day01.okfufu.studentSystem;

public class Main {
    public static void main(String[] args) {
        // 1.创建学生类，封装学生信息,信息包含姓名，性别，成绩
        // 2.准备学生数据，自己造一些测试类
        Student[] students = new Student[5];
        students[0] = new Student("张三", "男", 80);
        students[1] = new Student("王五", "女", 95);
        students[2] = new Student("赵六", "男", 40);
        students[3] = new Student("孙七", "女", 65);
        students[4] = new Student("周八", "男", 90);

        // 3.提供两套业务，支持灵活切换（解耦合），面向接口编程
        // 4. 创建一个接口，定义抽象方法，打印所有学生信息(printAllStudentsInformation)，打印平均分（printAverageScore）
        classDataInter cd1 = new classDataimpl1(students);
        cd1.printAllStudentsInformation();
        cd1.printAverageScore();
        System.out.println();
        classDataInter cd2 = new classDataimpl2(students);
        cd2.printAllStudentsInformation();
        cd2.printAverageScore();
    }
}
