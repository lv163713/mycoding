package view;

import service.AuthService;
import service.EmployeeService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private final AuthService authService;
    private final EmployeeService employeeService;

    public LoginFrame(AuthService authService, EmployeeService employeeService) {
        this.authService = authService;
        this.employeeService = employeeService;
        initializeUI();
    }

    private void initializeUI() {
        setTitle("员工管理系统 - 登录");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // 居中显示

        JPanel panel = new JPanel(new GridLayout(3, 2, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // 用户名
        panel.add(new JLabel("用户名:"));
        usernameField = new JTextField();
        panel.add(usernameField);

        // 密码
        panel.add(new JLabel("密码:"));
        passwordField = new JPasswordField();
        panel.add(passwordField);

        // 登录按钮
        JButton loginButton = new JButton("登录");
        loginButton.addActionListener(this::performLogin);
        panel.add(loginButton);

        add(panel);
    }

    private void performLogin(ActionEvent e) {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (authService.authenticate(username, password)) {
            // 登录成功，打开主界面
            MainFrame mainFrame = new MainFrame(employeeService);
            mainFrame.setVisible(true);
            dispose(); // 关闭登录窗口
        } else {
            JOptionPane.showMessageDialog(this,
                    "用户名或密码错误", "登录失败", JOptionPane.ERROR_MESSAGE);
        }
    }
}
