package day02;

public class capsulation {
    //目标：封装,如何合理隐藏，合理暴露。
    //现在在java中，常见的代码风格就是用get和set设置和输出变量
    public static void main(String[] args) {
        student s1=new student();
        s1.name="星见雅";
        s1.setAge(18);  //赋值
        System.out.println(s1.getAge());

    }
}
