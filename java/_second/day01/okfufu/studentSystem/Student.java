package day01.okfufu.studentSystem;

public class Student {
    private String name;
    private String sex;
    private double score;

    public Student(String name, String sex, double score) {
        this.name = name;
        this.sex = sex;
        this.score = score;
    }

    public Student() {
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
