import javax.swing.table.AbstractTableModel;
import java.util.List;

public class EmployeeTableModel extends AbstractTableModel {
    private List<Employee> employees;
    private String[] columnNames = {"ID", "姓名", "性别", "职位", "薪水"};

    public EmployeeTableModel(List<Employee> employees) {
        this.employees = employees;
    }

    public void updateData(List<Employee> newData) {
        this.employees = newData;
        fireTableDataChanged();
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
    public Object getValueAt(int row, int column) {
        Employee emp = employees.get(row);
        return switch (column) {
            case 0 -> emp.getId();
            case 1 -> emp.getName();
            case 2 -> emp.getGender();
            case 3 -> emp.getPosition();
            case 4 -> emp.getSalary();
            default -> null;
        };
    }
}