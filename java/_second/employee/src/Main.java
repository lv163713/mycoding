import dao.MemoryEmployeeDAO;
import service.AuthService;
import service.EmployeeService;
import view.LoginFrame;

public class Main {
    public static void main(String[] args) {
        // 初始化服务层
        EmployeeService employeeService = new EmployeeService(new MemoryEmployeeDAO());
        AuthService authService = new AuthService();

        // 使用SwingUtilities确保GUI创建在事件调度线程上
        javax.swing.SwingUtilities.invokeLater(() -> {
            LoginFrame loginFrame = new LoginFrame(authService, employeeService);
            loginFrame.setVisible(true);
        });
    }
}
