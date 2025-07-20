public class Employee {
    private String id;
    private String name;
    private String gender;
    private String position;
    private double salary;

    public Employee(String id, String name, String gender, String position, double salary) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.position = position;
        this.salary = salary;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getGender() { return gender; }
    public String getPosition() { return position; }
    public double getSalary() { return salary; }

    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setGender(String gender) { this.gender = gender; }
    public void setPosition(String position) { this.position = position; }
    public void setSalary(double salary) { this.salary = salary; }
}