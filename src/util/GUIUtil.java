package util; //打包作为工具使用		

import java.awt.Color; //提供用于颜色空间的类
import java.awt.Dimension; //对象的组件宽度高度
import java.io.File; //文件io

import javax.swing.ImageIcon; //图片
import javax.swing.JButton; //按钮
import javax.swing.JComponent;  //子类组件
import javax.swing.JFrame; //基本容器
import javax.swing.JOptionPane; //对话框
import javax.swing.JPanel; //面板容器
import javax.swing.JTextField; //文本框

public class GUIUtil{
	private static String imageFolder = "C:/Users/wangzhou0102/eclipse-workspace/hutubill";
	//设置图片地址imageFolder
	public static void setImageIcon(JButton b,String fileName, String tip) {
		ImageIcon i = new ImageIcon(new File(imageFolder, fileName).getAbsolutePath());
		b.setIcon(i);
		b.setPreferredSize(new Dimension(61,81));
		b.setToolTipText(tip);
		b.setVerticalTextPosition(JButton.BOTTOM);
		b.setHorizontalTextPosition(JButton.CENTER);
		b.setText(tip);
	}
	//给按钮设置图表和文本以及提示文字
	public static void setColor(Color color, JComponent... cs) {
		for (JComponent c : cs) {
			c.setForeground(color);
		}
	}
	//设置颜色
	public static void showPanel(JPanel p,double strech) {
		GUIUtil.useLNF();
		JFrame f = new JFrame();
		f.setSize(500, 500);
		f.setLocationRelativeTo(null);
		CenterPanel cp = new CenterPanel(strech);
		f.setContentPane(cp);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		cp.show(p);
	}
	public static void showPanel(JPanel p) {
		showPanel(p,0.85);
	}
	//设置测试Panle 直接调用GUIUtil.showPanel()即可
	public static boolean checkNumber(JTextField tf, String input) {
		if (!chekEmpty(tf, input))
			return false;
		String text = tf.getText().trim();
		try {
			Integer.parseInt(text);
			return true;
		} catch(NumberFormatException e1) {
			JOptionPane.showMessageDialog(null, input+"需要的是整数");
			tf.grabFocus();
			return false;
		}
	}
	//检测是否为整数
	public static boolean checkZero(JTextField tf, String input) {
		if (!checkNumber(tf, input))
			return false;
		String text = tf.getText().trim();
		if (0 ==Integer.parseInt(text)) {
			JOptionPane.showConfirmDialog(null, input+"不能为0");
			tf.grabFocus();
			return false;
		}
		return true;
	}
	//检测是否为0
	public static boolean chekEmpty(JTextField tf, String input) {
		String text = tf.getText().trim();
		if (0 == text.length()) {
			JOptionPane.showMessageDialog(null, input+"不能为空");
			tf.grabFocus();
			return false;
		}
		return true;
	}
	//检测是否为空
	public static int getInt(JTextField tf) {
		return Integer.parseInt(tf.getText());
	}
	//获得int值
	public static void useLNF() {
		try {
			javax.swing.UIManager.setLookAndFeel("com.birsof.liquid.liquidLookAndFeel");	
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}
	//使用水晶皮肤
}

