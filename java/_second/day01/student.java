package day01;

public class student {
    private String name;
    private String sex;
    private String id;
    private int age;
    private int score;

    
    public student(String name, String sex, String id, int age, int score) {
        this.name = name;
        this.sex = sex;
        this.id = id;
        this.age = age;
        this.score = score;
    }
    public student() {
        
    }
    public String getName() {
        return name;
    }
    public String getSex() {
        return sex;
    }
    public String getId() {
        return id;
    }
    public int getAge() {
        return age;
    }
    public int getScore() {
        return score;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setScore(int score) {
        this.score = score;
    }
    @Override
    public String toString() {
        return "student [name=" + name + ", sex=" + sex + ", id=" + id + ", age=" + age + ", score=" + score + "]";
    }

    
}
