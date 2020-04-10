package com.ailk.listener.uilistener;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MyFrame extends JFrame {
    public static void main(String[] args) {
        //创建小的窗口对象
        MyFrame myFrame = new MyFrame();
        //设置窗口的宽和高
        myFrame.setBounds(0,0,200,100);
        //3、设置窗口显示
        myFrame.setVisible(true);

        //在事件源上绑定监听器
        myFrame.addWindowListener(new MyWindowListener());
    }
    static class MyWindowListener implements WindowListener{

        @Override
        public void windowOpened(WindowEvent e) {

        }

        @Override
        public void windowClosing(WindowEvent e) {
            System.out.println("窗口关闭");
            System.exit(0);
        }

        @Override
        public void windowClosed(WindowEvent e) {

        }

        @Override
        public void windowIconified(WindowEvent e) {

        }

        @Override
        public void windowDeiconified(WindowEvent e) {

        }

        @Override
        public void windowActivated(WindowEvent e) {

        }

        @Override
        public void windowDeactivated(WindowEvent e) {

        }
    }
}
