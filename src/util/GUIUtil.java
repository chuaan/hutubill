package util; //�����Ϊ����ʹ��		

import java.awt.Color; //�ṩ������ɫ�ռ����
import java.awt.Dimension; //����������ȸ߶�
import java.io.File; //�ļ�io

import javax.swing.ImageIcon; //ͼƬ
import javax.swing.JButton; //��ť
import javax.swing.JComponent;  //�������
import javax.swing.JFrame; //��������
import javax.swing.JOptionPane; //�Ի���
import javax.swing.JPanel; //�������
import javax.swing.JTextField; //�ı���

public class GUIUtil{
	private static String imageFolder = "C:/Users/wangzhou0102/eclipse-workspace/hutubill";
	//����ͼƬ��ַimageFolder
	public static void setImageIcon(JButton b,String fileName, String tip) {
		ImageIcon i = new ImageIcon(new File(imageFolder, fileName).getAbsolutePath());
		b.setIcon(i);
		b.setPreferredSize(new Dimension(61,81));
		b.setToolTipText(tip);
		b.setVerticalTextPosition(JButton.BOTTOM);
		b.setHorizontalTextPosition(JButton.CENTER);
		b.setText(tip);
	}
	//����ť����ͼ����ı��Լ���ʾ����
	public static void setColor(Color color, JComponent... cs) {
		for (JComponent c : cs) {
			c.setForeground(color);
		}
	}
	//������ɫ
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
	//���ò���Panle ֱ�ӵ���GUIUtil.showPanel()����
	public static boolean checkNumber(JTextField tf, String input) {
		if (!chekEmpty(tf, input))
			return false;
		String text = tf.getText().trim();
		try {
			Integer.parseInt(text);
			return true;
		} catch(NumberFormatException e1) {
			JOptionPane.showMessageDialog(null, input+"��Ҫ��������");
			tf.grabFocus();
			return false;
		}
	}
	//����Ƿ�Ϊ����
	public static boolean checkZero(JTextField tf, String input) {
		if (!checkNumber(tf, input))
			return false;
		String text = tf.getText().trim();
		if (0 ==Integer.parseInt(text)) {
			JOptionPane.showConfirmDialog(null, input+"����Ϊ0");
			tf.grabFocus();
			return false;
		}
		return true;
	}
	//����Ƿ�Ϊ0
	public static boolean chekEmpty(JTextField tf, String input) {
		String text = tf.getText().trim();
		if (0 == text.length()) {
			JOptionPane.showMessageDialog(null, input+"����Ϊ��");
			tf.grabFocus();
			return false;
		}
		return true;
	}
	//����Ƿ�Ϊ��
	public static int getInt(JTextField tf) {
		return Integer.parseInt(tf.getText());
	}
	//���intֵ
	public static void useLNF() {
		try {
			javax.swing.UIManager.setLookAndFeel("com.birsof.liquid.liquidLookAndFeel");	
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}
	//ʹ��ˮ��Ƥ��
}

