// 定义一个名为 Student 的类
class Student {
    // 定义私有属性，用于存储学生的姓名、年龄和学号
    private String name;
    private int age;
    private String studentId;

    // 构造方法，用于初始化学生对象的属性
    public Student(String name, int age, String studentId) {
        this.name = name;
        this.age = age;
        this.studentId = studentId;
    }

    // 获取学生姓名的方法
    public String getName() {
        return name;
    }

    // 设置学生姓名的方法
    public void setName(String name) {
        this.name = name;
    }

    // 获取学生年龄的方法
    public int getAge() {
        return age;
    }

    // 设置学生年龄的方法
    public void setAge(int age) {
        this.age = age;
    }

    // 获取学生学号的方法
    public String getStudentId() {
        return studentId;
    }

    // 设置学生学号的方法
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    // 显示学生信息的方法
    public void displayInfo() {
        System.out.println("姓名: " + name);
        System.out.println("年龄: " + age);
        System.out.println("学号: " + studentId);
    }

    // 主方法，程序的入口点
    public static void main(String[] args) {
        // 创建一个 Student 对象
        Student student = new Student("张三", 20, "2025001");
        // 调用 displayInfo 方法显示学生信息
        student.displayInfo();

        // 修改学生的年龄
        student.setAge(21);
        System.out.println("\n修改年龄后的信息:");
        // 再次调用 displayInfo 方法显示更新后的学生信息
        student.displayInfo();
    }
}    