import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginFrame extends JFrame {
    public LoginFrame() {
        setTitle("员工管理系统 - 登录");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2, 10, 10));

        JLabel userLabel = new JLabel("用户名:");
        JTextField userField = new JTextField();
        JLabel passLabel = new JLabel("密码:");
        JPasswordField passField = new JPasswordField();
        JButton loginButton = new JButton("登录");

        // 设置样式
        userLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        passLabel.setFont(new Label().getFont());
        loginButton.setBackground(new Color(0, 150, 255));
        loginButton.setForeground(Color.WHITE);

        add(userLabel);
        add(userField);
        add(passLabel);
        add(passField);
        add(new JLabel()); // 空占位
        add(loginButton);

        loginButton.addActionListener(e -> {
            String user = userField.getText();
            String pass = new String(passField.getPassword());

            if ("admin".equals(user) && "123456".equals(pass)) {
                dispose();
                new EmployeeMainFrame();
            } else {
                JOptionPane.showMessageDialog(this, "用户名或密码错误", "错误", JOptionPane.ERROR_MESSAGE);
            }
        });

        setVisible(true);
    }
}