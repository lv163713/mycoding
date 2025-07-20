import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class MainFrame extends JFrame {
    private EmployeeTable employeeTable;
    private JTextField searchField;
    private String currentUsername;

    private void setTableStyle(JTable table) {
        // 表格内容字体颜色
        table.setForeground(Color.BLACK);

        // 表格内容背景颜色
        table.setBackground(Color.WHITE);

        // 表格交替行颜色
        table.setOpaque(true);
        table.setShowGrid(true);
        table.setGridColor(new Color(220, 220, 220));

        // 表头样式
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                label.setBackground(Color.WHITE); // 白色背景
                label.setForeground(Color.BLACK); // 黑色文字
                label.setFont(new Font("微软雅黑", Font.BOLD, 14)); // 加粗字体
                return label;
            }
        };

        // 应用表头样式
        table.getTableHeader().setDefaultRenderer(headerRenderer);
    }

    public MainFrame(String username) {
        this.currentUsername = username;

        // 设置窗口属性
        setTitle("黑马人事管理系统 - 员工管理 (" + username + ")");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // 居中显示

        // 设置外观风格
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 创建顶部面板
        JPanel topPanel = new JPanel(new BorderLayout(10, 10));
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // 标题
        JLabel titleLabel = new JLabel("员工管理", SwingConstants.LEFT);
        titleLabel.setFont(new Font("微软雅黑", Font.BOLD, 24));
        topPanel.add(titleLabel, BorderLayout.WEST);

        // 用户信息面板
        JPanel userInfoPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        JLabel userLabel = new JLabel("当前用户: " + username);
        JButton logoutButton = new JButton("退出登录");

        // 退出登录按钮事件
        logoutButton.addActionListener(e -> {
            int option = JOptionPane.showConfirmDialog(this, "确定要退出登录吗？", "退出登录", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                new LoginFrame().setVisible(true);
                dispose(); // 关闭当前窗口
            }
        });

        userInfoPanel.add(userLabel);
        userInfoPanel.add(logoutButton);

        topPanel.add(userInfoPanel, BorderLayout.EAST);

        // 搜索框
        searchField = new JTextField();
        searchField.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        searchField.setPreferredSize(new Dimension(250, 30));
        searchField.setText("输入姓名搜索...");
        searchField.setForeground(Color.GRAY);

        // 搜索框焦点监听
        searchField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (searchField.getText().equals("输入姓名搜索...")) {
                    searchField.setText("");
                    searchField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (searchField.getText().isEmpty()) {
                    searchField.setText("输入姓名搜索...");
                    searchField.setForeground(Color.GRAY);
                }
            }
        });

        // 搜索框内容变化监听
        searchField.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                searchEmployee();
            }
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                searchEmployee();
            }
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                searchEmployee();
            }
        });

        topPanel.add(searchField, BorderLayout.EAST);

        // 创建表格
        employeeTable = new EmployeeTable();

        // 创建表格组件
        JTable table = new JTable(employeeTable.getData(), employeeTable.getColumnNames());

        // 设置表格样式
        setTableStyle(table);

        // 创建滚动面板
        JScrollPane scrollPane = new JScrollPane(table);

        // 创建按钮面板
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));

        JButton addButton = new JButton("添加员工");
        JButton refreshButton = new JButton("刷新");

        // 添加员工按钮事件
        addButton.addActionListener(e -> {
            new EditEmployeeDialog(this, "添加员工", true, null, employeeTable::addEmployee);
        });

        // 刷新按钮事件
        refreshButton.addActionListener(e -> {
            employeeTable.refreshData();
        });

        buttonPanel.add(addButton);
        buttonPanel.add(refreshButton);

        // 组合所有组件
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
    }

    // 搜索员工方法
    private void searchEmployee() {
        String keyword = searchField.getText();
        if (keyword.isEmpty() || keyword.equals("输入姓名搜索...")) {
            employeeTable.refreshData();
        } else {
            employeeTable.searchData(keyword);
        }
    }

    // 新增方法，用于从登录界面跳转过来
    public static void showFrame(String username) {
        SwingUtilities.invokeLater(() -> {
            new MainFrame(username).setVisible(true);
        });
    }

    public static void main(String[] args) {
        // 测试用的入口
        SwingUtilities.invokeLater(() -> {
            new MainFrame("测试用户").setVisible(true);
        });
    }
}