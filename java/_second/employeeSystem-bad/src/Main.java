import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // 设置美化主题（Nimbus）
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        new LoginFrame();
    }
}