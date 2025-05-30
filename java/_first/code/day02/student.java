package  day02;
public class student {
    //1.private的变量说明：私有变量，只能在本类中访问，其他类不能访问    public String name;
    private int age;
    public String name;
    double chinese_score;
    double math_score;

    //2.如何合理暴露接口，使用public修饰get和set方法
    public void setAge(int age){
        //正确修饰age范围
        if (age >= 0 && age <= 120) {
            this.age = age;
        } else {
            System.out.println("输入的age有误");
        }
    }

    //取值
    public int getAge(){
        return age;
    }
    //求出总成绩
    public double get_total_score(){
        return chinese_score+math_score;
    }

    //求出平均成绩
    public double get_average_score(){
        return get_total_score()/2;
    }

    
}