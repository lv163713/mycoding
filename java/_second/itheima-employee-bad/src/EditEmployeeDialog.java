import javax.swing.*;
import java.awt.*;

public class EditEmployeeDialog extends JDialog {
    private JTextField idField;
    private JTextField nameField;
    private JComboBox<String> genderCombo;
    private JTextField positionField;
    private JTextField salaryField;
    private JButton saveButton;
    private JButton cancelButton;

    public EditEmployeeDialog(Frame owner, String title, boolean modal, Employee employee, SaveCallback callback) {
        super(owner, title, modal);
        setSize(400, 300);
        setLocationRelativeTo(owner);

        // 初始化组件
        JPanel panel = new JPanel(new GridLayout(6, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panel.add(new JLabel("ID："));
        idField = new JTextField();
        panel.add(idField);

        panel.add(new JLabel("姓名："));
        nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("性别："));
        genderCombo = new JComboBox<>(new String[]{"男", "女"});
        panel.add(genderCombo);

        panel.add(new JLabel("职位："));
        positionField = new JTextField();
        panel.add(positionField);

        panel.add(new JLabel("薪水："));
        salaryField = new JTextField();
        panel.add(salaryField);

        // 按钮面板
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 10));

        saveButton = new JButton("保存");
        cancelButton = new JButton("取消");

        saveButton.addActionListener(e -> {
            if (validateInput()) {
                Employee updatedEmployee = new Employee(
                        idField.getText(),
                        nameField.getText(),
                        genderCombo.getSelectedItem().toString(),
                        positionField.getText(),
                        Double.parseDouble(salaryField.getText())
                );
                callback.onSave(updatedEmployee);
                dispose();
            }
        });

        cancelButton.addActionListener(e -> dispose());

        buttonPanel.add(saveButton);
        buttonPanel.add(cancelButton);

        add(panel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // 如果是编辑模式，填充数据
        if (employee != null) {
            idField.setText(employee.getId());
            nameField.setText(employee.getName());
            genderCombo.setSelectedItem(employee.getGender());
            positionField.setText(employee.getPosition());
            salaryField.setText(String.valueOf(employee.getSalary()));
            idField.setEditable(false); // ID 不能修改
        } else {
            // 如果是添加模式，生成新 ID
            idField.setText(generateNewId());
        }
    }

    // 验证输入
    private boolean validateInput() {
        if (nameField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "请输入姓名！", "错误", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (positionField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "请输入职位！", "错误", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            Double.parseDouble(salaryField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "请输入有效的薪水！", "错误", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    // 生成新 ID（简单示例）
    private String generateNewId() {
        return String.format("%03d", (int)(Math.random() * 999));
    }

    // 保存回调接口
    public interface SaveCallback {
        void onSave(Employee employee);
    }
}