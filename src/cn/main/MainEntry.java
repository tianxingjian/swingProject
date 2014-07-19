package cn.main;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;

import cn.pane.CreditPanel;
import cn.util.ConstDef;

public class MainEntry {
	

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {
				JFrame mainFrame = new JFrame("baicai");
				CreditPanel contenPanel = new CreditPanel();
				contenPanel.init();
				mainFrame.setContentPane(contenPanel);
				mainFrame.setSize(ConstDef.DEFAULT_WIDTH, ConstDef.DEFAULT_HEIGHT);
				MainEntry.setLocation(mainFrame);
				mainFrame.setVisible(true);
				mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
			}

		});

	}
	
	private static void setLocation(JFrame jf) {
		Toolkit kit = Toolkit.getDefaultToolkit(); // 定义工具包
		Dimension screenSize = kit.getScreenSize(); // 获取屏幕的尺寸
		int screenWidth = screenSize.width / 2; // 获取屏幕的宽
		int screenHeight = screenSize.height / 2; // 获取屏幕的高
		int height = jf.getHeight();
		int width = jf.getWidth();
		jf.setLocation(screenWidth - width / 2, screenHeight - height / 2);
	}
}
