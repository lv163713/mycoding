import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class EmployeeTable extends AbstractTableModel {
    private List<Employee> employees = new ArrayList<>();
    private String[] columnNames = {"ID", "姓名", "性别", "职位", "工资"};

    // 构造函数，初始化一些示例员工数据
    public EmployeeTable() {
        // 初始化示例员工数据
        addEmployee(new Employee("1", "张三", "男", "经理", 8000));
        addEmployee(new Employee("2", "李四", "女", "程序员", 6000));
        addEmployee(new Employee("3", "王五", "男", "设计师", 7000));
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
        fireTableRowsInserted(employees.size() - 1, employees.size() - 1);
    }

    public void refreshData() {
        this.employees.clear();
        fireTableDataChanged();
    }

    public void searchData(String keyword) {
        // 搜索员工的方法
    }

    @Override
    public int getRowCount() {
        return employees.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Employee employee = employees.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return employee.getId();
            case 1:
                return employee.getName();
            case 2:
                return employee.getGender();
            case 3:
                return employee.getPosition();
            case 4:
                return employee.getSalary();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public Object[][] getData() {
        Object[][] data = new Object[employees.size()][columnNames.length];
        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            data[i][0] = employee.getId();
            data[i][1] = employee.getName();
            data[i][2] = employee.getGender();
            data[i][3] = employee.getPosition();
            data[i][4] = employee.getSalary();
        }
        return data;
    }

    public String[] getColumnNames() {
        return columnNames;
    }
}