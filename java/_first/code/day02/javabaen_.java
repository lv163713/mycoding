package day02;

public class javabaen_ {
    //实体类，搞清楚实体类是什么，基本作用和应用场景
    // 作用：封装数据，提高安全性，方便维护和修改
    public static void main(String[] args) {
        //创建对象
        student_1 s1=new student_1();
        //调用方法get
        s1.setName("伏灵");
        s1.setAge(19);
        s1.setChina_score(100);
        s1.setMath_score(60);
        // 调用有参构造器
        // student_1 s2=new student_1("小明",18,100,60);
        // System.out.println(s2.getName()+" "+s2.getAge()+" "+s2.getChina_score()+" "+s2.getMath_score());

        // 实体类的应用场景：实体类对象只负责数据的存和取，不参与业务逻辑处理
        // 对数据的处理交给其他类，是一个分层的思想 

    }
}

