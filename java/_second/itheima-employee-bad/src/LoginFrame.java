// LoginFrame.java - 修改版
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

public class LoginFrame extends JFrame {
    // 初始化组件
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;
    private JLabel titleLabel;
    private JPanel panel;

    // 模拟数据库
    private Map<String, String> userDatabase = new HashMap<>();

    public LoginFrame() {
        // 初始化测试用户
        userDatabase.put("admin", "123456");
        userDatabase.put("user", "password");

        // 设置窗口属性
        setTitle("黑马人事管理系统 - 登录");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // 居中显示

        // 创建面板
        panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // 标题
        titleLabel = new JLabel("黑马人事管理系统", SwingConstants.CENTER);
        titleLabel.setFont(new Font("微软雅黑", Font.BOLD, 20));
        panel.add(titleLabel, BorderLayout.NORTH);

        // 表单面板
        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10));

        formPanel.add(new JLabel("用户名："));
        usernameField = new JTextField();
        formPanel.add(usernameField);

        formPanel.add(new JLabel("密码："));
        passwordField = new JPasswordField();
        formPanel.add(passwordField);

        // 按钮面板
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 10));

        loginButton = new JButton("登录");
        registerButton = new JButton("注册");

        // 登录按钮事件
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                // 验证用户
                if (authenticate(username, password)) {
                    JOptionPane.showMessageDialog(LoginFrame.this, "登录成功！");
                    // 跳转到员工管理界面
                    new MainFrame(username).setVisible(true);
                    dispose(); // 关闭登录窗口
                } else {
                    JOptionPane.showMessageDialog(LoginFrame.this, "用户名或密码错误！", "错误", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // 注册按钮事件
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegisterFrame(userDatabase, () -> {
                    setVisible(true); // 返回登录界面
                }).setVisible(true);
                dispose(); // 关闭当前窗口
            }
        });

        buttonPanel.add(loginButton);
        buttonPanel.add(registerButton);

        panel.add(formPanel, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        add(panel);
    }

    // 用户验证
    private boolean authenticate(String username, String password) {
        return userDatabase.containsKey(username) &&
                userDatabase.get(username).equals(password);
    }

    public static void main(String[] args) {
        // 启动界面
        SwingUtilities.invokeLater(() -> {
            new LoginFrame().setVisible(true);
        });
    }
}