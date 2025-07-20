package view;

import model.Employee;
import service.EmployeeService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class MainFrame extends JFrame {
    private final EmployeeService employeeService;
    private JTable employeeTable;
    private EmployeeTableModel tableModel;

    public MainFrame(EmployeeService employeeService) {
        this.employeeService = employeeService;
        initializeUI();
        loadEmployeeData();
    }

    private void initializeUI() {
        setTitle("员工管理系统");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // 创建菜单栏
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("文件");
        JMenuItem exitItem = new JMenuItem("退出");
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        // 创建工具栏
        JToolBar toolBar = new JToolBar();
        JButton addButton = new JButton("添加员工");
        addButton.addActionListener(this::showAddEmployeeDialog);

        JButton editButton = new JButton("编辑员工");
        editButton.addActionListener(this::showEditEmployeeDialog);

        JButton deleteButton = new JButton("删除员工");
        deleteButton.addActionListener(this::deleteSelectedEmployee);

        JButton refreshButton = new JButton("刷新");
        refreshButton.addActionListener(e -> loadEmployeeData());

        toolBar.add(addButton);
        toolBar.add(editButton);
        toolBar.add(deleteButton);
        toolBar.add(refreshButton);
        add(toolBar, BorderLayout.NORTH);

        // 创建员工表格
        employeeTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(employeeTable);
        add(scrollPane, BorderLayout.CENTER);

        // 状态栏
        JLabel statusLabel = new JLabel("就绪");
        add(statusLabel, BorderLayout.SOUTH);
    }

    private void loadEmployeeData() {
        List<Employee> employees = employeeService.getAllEmployees();
        tableModel = new EmployeeTableModel(employees);
        employeeTable.setModel(tableModel);
    }

    private void showAddEmployeeDialog(ActionEvent e) {
        EmployeeEditDialog dialog = new EmployeeEditDialog(this, null);
        dialog.setSaveActionListener(evt -> {
            Employee newEmployee = dialog.getEmployee();
            if (employeeService.validateEmployee(newEmployee)) {
                employeeService.addEmployee(newEmployee);
                loadEmployeeData();
                dialog.dispose();
            } else {
                JOptionPane.showMessageDialog(this,
                        "请填写完整且有效的员工信息", "输入错误", JOptionPane.ERROR_MESSAGE);
            }
        });
        dialog.setVisible(true);
    }

    private void showEditEmployeeDialog(ActionEvent e) {
        int selectedRow = employeeTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this,
                    "请先选择一个员工", "未选择", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int employeeId = (int) tableModel.getValueAt(selectedRow, 0);
        Employee employee = employeeService.getEmployeeById(employeeId);

        EmployeeEditDialog dialog = new EmployeeEditDialog(this, employee);
        dialog.setSaveActionListener(evt -> {
            Employee updatedEmployee = dialog.getEmployee();
            if (employeeService.validateEmployee(updatedEmployee)) {
                employeeService.updateEmployee(updatedEmployee);
                loadEmployeeData();
                dialog.dispose();
            } else {
                JOptionPane.showMessageDialog(this,
                        "请填写完整且有效的员工信息", "输入错误", JOptionPane.ERROR_MESSAGE);
            }
        });
        dialog.setVisible(true);
    }

    private void deleteSelectedEmployee(ActionEvent e) {
        int selectedRow = employeeTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this,
                    "请先选择一个员工", "未选择", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this,
                "确定要删除这个员工吗？", "确认删除", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            int employeeId = (int) tableModel.getValueAt(selectedRow, 0);
            employeeService.deleteEmployee(employeeId);
            loadEmployeeData();
        }
    }
}
