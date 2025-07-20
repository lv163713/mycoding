package service;

import dao.EmployeeDAO;
import model.Employee;

import java.util.List;

/**
 * 员工业务逻辑服务
 * 封装与员工相关的业务操作
 */
public class EmployeeService {
    private final EmployeeDAO employeeDAO;

    public EmployeeService(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    /**
     * 添加新员工
     * @param employee 员工对象
     */
    public void addEmployee(Employee employee) {
        employeeDAO.addEmployee(employee);
    }

    /**
     * 获取所有员工
     * @return 员工列表
     */
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    /**
     * 根据ID获取员工
     * @param id 员工ID
     * @return 员工对象
     */
    public Employee getEmployeeById(int id) {
        return employeeDAO.getEmployeeById(id);
    }

    /**
     * 更新员工信息
     * @param employee 更新后的员工对象
     */
    public void updateEmployee(Employee employee) {
        employeeDAO.updateEmployee(employee);
    }

    /**
     * 根据ID删除员工
     * @param id 员工ID
     */
    public void deleteEmployee(int id) {
        employeeDAO.deleteEmployee(id);
    }

    /**
     * 验证员工信息是否完整
     * @param employee 员工对象
     * @return 是否有效
     */
    // ... existing code ...

    public boolean validateEmployee(Employee employee) {
        return
                // 姓名验证
                employee.getName() != null && !employee.getName().isEmpty() &&

                        // 性别验证
                        employee.getGender() != null && !employee.getGender().isEmpty() &&

                        // 年龄验证（必须大于0）
                        employee.getAge() > 0 &&

                        // 职位验证
                        employee.getPosition() != null && !employee.getPosition().isEmpty() &&

                        // 部门验证
                        employee.getDepartment() != null && !employee.getDepartment().isEmpty();
    }


// ... existing code ...

}
