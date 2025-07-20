package view;

import model.Employee;
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class EmployeeTableModel extends AbstractTableModel {
    private final List<Employee> employees;
    private final String[] columnNames = {"ID", "姓名", "性别", "年龄", "职位", "部门"};

    public EmployeeTableModel(List<Employee> employees) {
        this.employees = employees;
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
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Employee employee = employees.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> employee.getId();
            case 1 -> employee.getName();
            case 2 -> employee.getGender();
            case 3 -> employee.getAge();
            case 4 -> employee.getPosition();
            case 5 -> employee.getDepartment();
            default -> null;
        };
    }
}
