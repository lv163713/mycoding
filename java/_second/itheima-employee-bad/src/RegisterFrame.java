// RegisterFrame.java - 修改版
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Map;

public class RegisterFrame extends JFrame {
    // 初始化组件
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JButton registerButton;
    private JButton backButton;
    private JLabel titleLabel;
    private JPanel panel;

    // 使用主界面的用户数据库
    private Map<String, String> userDatabase;
    private OnRegisterSuccessListener onRegisterSuccessListener;

    public interface OnRegisterSuccessListener {
        void onRegisterSuccess();
    }

    public RegisterFrame(Map<String, String> userDatabase, Runnable onBack) {
        this.userDatabase = userDatabase;

        // 设置窗口属性
        setTitle("黑马人事管理系统 - 注册");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // 居中显示

        // 创建面板
        panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // 标题
        titleLabel = new JLabel("用户注册", SwingConstants.CENTER);
        titleLabel.setFont(new Font("微软雅黑", Font.BOLD, 20));
        panel.add(titleLabel, BorderLayout.NORTH);

        // 表单面板
        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));

        formPanel.add(new JLabel("用户名："));
        usernameField = new JTextField();
        formPanel.add(usernameField);

        formPanel.add(new JLabel("密码："));
        passwordField = new JPasswordField();
        formPanel.add(passwordField);

        formPanel.add(new JLabel("确认密码："));
        confirmPasswordField = new JPasswordField();
        formPanel.add(confirmPasswordField);

        // 按钮面板
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 10));

        registerButton = new JButton("注册");
        backButton = new JButton("返回");

        // 注册按钮事件
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                String confirmPassword = new String(confirmPasswordField.getPassword());

                if (!password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(RegisterFrame.this, "两次输入的密码不一致！", "错误", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(RegisterFrame.this, "用户名和密码不能为空！", "错误", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (userDatabase.containsKey(username)) {
                    JOptionPane.showMessageDialog(RegisterFrame.this, "用户名已存在！", "错误", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // 注册用户
                userDatabase.put(username, password);
                JOptionPane.showMessageDialog(RegisterFrame.this, "注册成功！");

                // 触发注册成功回调
                if (onRegisterSuccessListener != null) {
                    onRegisterSuccessListener.onRegisterSuccess();
                }
            }
        });

        // 返回按钮事件
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onBack.run();
                dispose(); // 关闭当前窗口
            }
        });

        buttonPanel.add(registerButton);
        buttonPanel.add(backButton);

        panel.add(formPanel, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        add(panel);
    }

    // 设置注册成功回调
    public void setOnRegisterSuccessListener(OnRegisterSuccessListener listener) {
        this.onRegisterSuccessListener = listener;
    }
}