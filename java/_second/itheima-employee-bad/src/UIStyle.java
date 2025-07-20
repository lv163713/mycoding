import javax.swing.*;
import java.awt.*;

public class UIStyle {
    public static void applyModernStyle() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            try {
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        // 自定义颜色
        Color primaryColor = new Color(41, 128, 185);
        Color lightGray = new Color(245, 247, 250);
        Color darkGray = new Color(52, 73, 94);

        // 按钮样式
        UIManager.put("Button.background", primaryColor);
        UIManager.put("Button.foreground", Color.BLACK);
        UIManager.put("Button.font", new Font("微软雅黑", Font.BOLD, 14));
        UIManager.put("Button.border", BorderFactory.createEmptyBorder(10, 20, 10, 20));

        // 表格样式
        UIManager.put("Table.background", Color.WHITE);
        UIManager.put("Table.alternateRowColor", lightGray);
        UIManager.put("Table.gridColor", new Color(220, 220, 220));
        UIManager.put("TableHeader.background", primaryColor);
        UIManager.put("TableHeader.foreground", Color.WHITE);
        UIManager.put("TableHeader.cellBorder", BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        UIManager.put("TableHeader.font", new Font("微软雅黑", Font.BOLD, 14));
        UIManager.put("Table.foreground", Color.BLACK);
        UIManager.put("Table.font", new Font("微软雅黑", Font.PLAIN, 14));

        // 输入框样式
        UIManager.put("TextField.background", Color.WHITE);
        UIManager.put("TextField.foreground", Color.BLACK);

        // 面板样式
        UIManager.put("Panel.background", lightGray);

        // 窗口样式
        UIManager.put("Frame.background", lightGray);
        UIManager.put("Window.background", lightGray);
    }
}