package day02.oop;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void  main(String[] args){
        // 这里是创建一个窗口
        JFrame window = new JFrame("登入窗口");
        window.setSize(400, 300);
        // 居中显示
        window.setLocationRelativeTo(null);
        // 退出程序
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 创建一个桌板
        JPanel panel = new JPanel();
        window.add(panel);

        // 在桌板上创建一个按钮
        JButton button = new JButton("登入");
        panel.add(button);

        // 添加监听器
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("点击了按钮");
            }
        });

        // 显示窗口
        window.setVisible(true);
    }
}