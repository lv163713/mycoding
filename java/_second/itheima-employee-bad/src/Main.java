import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // 先应用现代样式
        UIStyle.applyModernStyle();

        // 再启动登录界面
        SwingUtilities.invokeLater(() -> {
            new LoginFrame().setVisible(true);
        });
    }
}