import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeMainFrame extends JFrame {
    private JTable table;
    private EmployeeTableModel tableModel;
    private List<Employee> employees;

    public EmployeeMainFrame() {
        setTitle("员工管理系统");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // 初始化数据
        employees = EmployeeDAO.loadEmployees();
        tableModel = new EmployeeTableModel(employees);
        table = new JTable(tableModel);

        // 设置表格样式
        table.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        table.setRowHeight(25);
        table.getTableHeader().setFont(new Font("微软雅黑", Font.BOLD, 14));
        table.getTableHeader().setBackground(new Color(0, 150, 255));
        table.getTableHeader().setForeground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // 右键菜单
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem editItem = new JMenuItem("编辑");
        JMenuItem deleteItem = new JMenuItem("删除");
        popupMenu.add(editItem);
        popupMenu.add(deleteItem);

        table.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    int row = table.rowAtPoint(e.getPoint());
                    table.setRowSelectionInterval(row, row);
                    popupMenu.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });

        editItem.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow >= 0) {
                Employee emp = employees.get(selectedRow);
                new EditEmployeeDialog(EmployeeMainFrame.this, emp, selectedRow).setVisible(true);
            }
        });

        deleteItem.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow >= 0) {
                employees.remove(selectedRow);
                tableModel.fireTableDataChanged();
                EmployeeDAO.saveEmployees(employees);
            }
        });

        // 搜索功能
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        JTextField searchField = new JTextField(20);
        JButton searchButton = new JButton("搜索");
        searchButton.setBackground(new Color(0, 150, 255));
        searchButton.setForeground(Color.WHITE);

        searchPanel.add(new JLabel("搜索："));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        searchButton.addActionListener(e -> {
            String keyword = searchField.getText().trim();
            List<Employee> filtered = employees.stream()
                    .filter(emp -> emp.getId().contains(keyword) || emp.getName().contains(keyword))
                    .collect(Collectors.toList());
            tableModel.updateData(filtered);
        });

        add(searchPanel, BorderLayout.NORTH);

        setVisible(true);
    }
}