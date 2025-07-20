package model;

/**
 * 员工实体类
 * 包含员工的基本属性：ID、姓名、性别、年龄、职位、部门
 */
public class Employee {
    private int id;          // 员工ID
    private String name;     // 姓名
    private String gender;   // 性别
    private int age;         // 年龄
    private String position; // 职位
    private String department; // 部门

    // 无参构造方法
    public Employee() {
    }

    // 包含ID的构造方法（用于编辑操作）
    public Employee(int id, String name, String gender, int age, String position, String department) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.position = position;
        this.department = department;
    }

    // 不包含ID的构造方法（用于新增操作）
    public Employee(String name, String gender, int age, String position, String department) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.position = position;
        this.department = department;
    }

    // Getter和Setter方法
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", position='" + position + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
