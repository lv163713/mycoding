package day02;

//实体类
public class student_1 {
    //私有化成员变量
    private String name;
    private int age;
    private int china_score;
    private int math_score;

    // 提供一个无参构造方法
    public student_1() {
    }
    
    public student_1(String name, int age, int china_score, int math_score) {
        this.name = name;
        this.age = age;
        this.china_score = china_score;
        this.math_score = math_score;
    }
    // 用公开的get和set方法设置和输出变量，右键源代码编辑
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getChina_score() {
        return china_score;
    }
    public void setChina_score(int china_score) {
        this.china_score = china_score;
    }
    public int getMath_score() {
        return math_score;
    }
    public void setMath_score(int math_score) {
        this.math_score = math_score;
    }
    
}
