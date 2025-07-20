import javax.swing.*;
import java.awt.*;

public class EditEmployeeDialog extends JDialog {
    private Employee employee;
    private int row;

    public EditEmployeeDialog(JFrame parent, Employee employee, int row) {
        super(parent, "编辑员工信息", true);
        this.employee = employee;
        this.row = row;
        setSize(400, 300);
        setLocationRelativeTo(parent);
        setLayout(new GridLayout(5, 2, 10, 10));

        JLabel idLabel = new JLabel("ID:");
        JTextField idField = new JTextField(employee.getId());
        JLabel nameLabel = new JLabel("姓名:");
        JTextField nameField = new JTextField(employee.getName());
        JLabel genderLabel = new JLabel("性别:");
        JComboBox<String> genderCombo = new JComboBox<>(new String[]{"男", "女"});
        genderCombo.setSelectedItem(employee.getGender());
        JLabel positionLabel = new JLabel("职位:");
        JTextField positionField = new JTextField(employee.getPosition());
        JLabel salaryLabel = new JLabel("薪水:");
        JTextField salaryField = new JTextField(String.valueOf(employee.getSalary()));

        JButton saveButton = new JButton("保存");
        JButton cancelButton = new JButton("取消");

        add(idLabel); add(idField);
        add(nameLabel); add(nameField);
        add(genderLabel); add(genderCombo);
        add(positionLabel); add(positionField);
        add(salaryLabel); add(salaryField);
        add(new JLabel()); add(saveButton);
        add(new JLabel()); add(cancelButton);

        saveButton.addActionListener(e -> {
            employee.setId(idField.getText());
            employee.setName(nameField.getText());
            employee.setGender((String) genderCombo.getSelectedItem());
            employee.setPosition(positionField.getText());
            employee.setSalary(Double.parseDouble(salaryField.getText()));
            ((EmployeeTableModel) ((JTable) ((JScrollPane) ((EmployeeMainFrame) getParent()).getComponent(0)).getViewport().getView()).getModel()).updateData(EmployeeDAO.loadEmployees());
            EmployeeDAO.saveEmployees(EmployeeDAO.loadEmployees());
            dispose();
        });

        cancelButton.addActionListener(e -> dispose());
    }
}