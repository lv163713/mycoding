package dao;

import model.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 基于内存集合的员工数据访问实现
 * 使用HashMap存储员工数据，键为员工ID
 */
public class MemoryEmployeeDAO implements EmployeeDAO {
    private final Map<Integer, Employee> employees = new HashMap<>();
    private int nextId = 1;

    // 构造函数中初始化示例数据
    public MemoryEmployeeDAO() {
        initializeSampleData();
    }

    private void initializeSampleData() {
        // 添加初始员工数据
        addSampleEmployee("张三", "男", 30, "软件工程师", "技术部");
        addSampleEmployee("李四", "男", 28, "产品经理", "产品部");
        addSampleEmployee("王五", "女", 25, "UI设计师", "设计部");
        addSampleEmployee("赵六", "女", 32, "测试工程师", "质量保障部");
    }

    private void addSampleEmployee(String name, String gender, int age, String position, String department) {
        Employee employee = new Employee(name, gender, age, position, department);
        employee.setId(nextId++);
        employees.put(employee.getId(), employee);
    }

    @Override
    public void addEmployee(Employee employee) {
        employee.setId(nextId++);
        employees.put(employee.getId(), employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees.values());
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employees.get(id);
    }

    @Override
    public void updateEmployee(Employee updatedEmployee) {
        if (employees.containsKey(updatedEmployee.getId())) {
            employees.put(updatedEmployee.getId(), updatedEmployee);
        }
    }

    @Override
    public void deleteEmployee(int id) {
        employees.remove(id);
    }
}
