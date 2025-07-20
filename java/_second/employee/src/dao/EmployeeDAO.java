package dao;

import model.Employee;

import java.util.List;

/**
 * 员工数据访问接口
 * 定义对员工数据的CRUD操作
 */
public interface EmployeeDAO {
    /**
     * 添加新员工
     * @param employee 员工对象
     */
    void addEmployee(Employee employee);

    /**
     * 获取所有员工列表
     * @return 员工列表
     */
    List<Employee> getAllEmployees();

    /**
     * 根据ID获取员工
     * @param id 员工ID
     * @return 员工对象
     */
    Employee getEmployeeById(int id);

    /**
     * 更新员工信息
     * @param employee 更新后的员工对象
     */
    void updateEmployee(Employee employee);

    /**
     * 根据ID删除员工
     * @param id 员工ID
     */
    void deleteEmployee(int id);
}
