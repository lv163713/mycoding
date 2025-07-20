package day01.okfufu.studentSystem;

public class classDataimpl2 implements classDataInter{
    private Student[] students;
    public classDataimpl2(Student[] students) {
        this.students = students;
    }
    @Override
    public void printAllStudentsInformation() {
        // 加上男女人数
        int manNum = 0;
        int womanNum = 0;
        for (Student student : students) {
            if (student.getSex().equals("男")) {
                manNum++;
            } else {
                womanNum++;
            }
            System.out.println(student.getName() + " " + student.getSex() + " " + student.getScore());
        }
        System.out.println("共有" + manNum + "个男同学，" + womanNum + "个女同学");
    }

    @Override
    public void printAverageScore() {
        if (students == null || students.length <= 2) {
            System.out.println("学生数量不足，无法计算平均分。");
            return;
        }

        double sum = 0;
        double maxScore = students[0].getScore();
        double minScore = students[0].getScore();

        for (Student student : students) {
            double score = student.getScore();
            sum += score;
            if (score > maxScore) {
                maxScore = score;
            }
            if (score < minScore) {
                minScore = score;
            }
        }
        double average = (sum - maxScore - minScore) / (students.length - 2);
        System.out.println("去掉最高分和最低分后的平均分是：" + average);
}

}
