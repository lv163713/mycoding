package view;

import model.Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeEditDialog extends JDialog {
    private final JTextField nameField;
    private final JComboBox<String> genderCombo;
    private final JSpinner ageSpinner;
    private final JTextField positionField;
    private final JTextField departmentField;
    private ActionListener saveActionListener;

    public EmployeeEditDialog(JFrame parent, Employee employee) {
        super(parent, employee == null ? "添加员工" : "编辑员工", true);
        setSize(400, 300);
        setLocationRelativeTo(parent);

        JPanel panel = new JPanel(new GridLayout(6, 2, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // 姓名
        panel.add(new JLabel("姓名:"));
        nameField = new JTextField();
        panel.add(nameField);

        // 性别
        panel.add(new JLabel("性别:"));
        genderCombo = new JComboBox<>(new String[]{"男", "女"});
        panel.add(genderCombo);

        // 年龄
        panel.add(new JLabel("年龄:"));
        SpinnerModel ageModel = new SpinnerNumberModel(25, 18, 65, 1);
        ageSpinner = new JSpinner(ageModel);
        panel.add(ageSpinner);

        // 职位
        panel.add(new JLabel("职位:"));
        positionField = new JTextField();
        panel.add(positionField);

        // 部门
        panel.add(new JLabel("部门:"));
        departmentField = new JTextField();
        panel.add(departmentField);

        // 按钮
        JButton saveButton = new JButton("保存");
        saveButton.addActionListener(e -> {
            if (saveActionListener != null) {
                saveActionListener.actionPerformed(
                        new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "save"));
            }
        });

        JButton cancelButton = new JButton("取消");
        cancelButton.addActionListener(e -> dispose());

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(saveButton);
        buttonPanel.add(cancelButton);

        add(panel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // 如果是编辑模式，填充现有数据
        if (employee != null) {
            populateFields(employee);
        }
    }

    public void setSaveActionListener(ActionListener listener) {
        this.saveActionListener = listener;
    }

    public Employee getEmployee() {
        return new Employee(
                nameField.getText(),
                (String) genderCombo.getSelectedItem(),
                (Integer) ageSpinner.getValue(),
                positionField.getText(),
                departmentField.getText()
        );
    }

    private void populateFields(Employee employee) {
        nameField.setText(employee.getName());
        genderCombo.setSelectedItem(employee.getGender());
        ageSpinner.setValue(employee.getAge());
        positionField.setText(employee.getPosition());
        departmentField.setText(employee.getDepartment());
    }
}
