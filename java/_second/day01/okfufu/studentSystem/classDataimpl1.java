package day01.okfufu.studentSystem;

public class classDataimpl1 implements classDataInter{
    private Student[] students;
    public classDataimpl1(Student[] students) {
        this.students = students;
    }
    @Override
    public void printAllStudentsInformation() {
        for (Student student : students) {
            System.out.println(student.getName() + " " + student.getSex() + " " + student.getScore());
        }
    }

    @Override
    public void printAverageScore() {
        double sum = 0;
        for (Student student : students) {
            sum += student.getScore();
        }
        System.out.println("平均分是：" + sum / students.length);
    }
}
