package util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.objectplanet.chart.BarChart;
import com.objectplanet.chart.Chart;

public class ChartUtil {
	public static int max(double[] sampleValues) {
		int max = 0;
		for (double v : sampleValues) {
			if (v > max)
				max = (int) v;
		}
		return max;
	}
	private static String[] sampleLabels() {
		String[] sampleLabels = new String[30];
		for (int i = 0; i < sampleLabels.length; i++) {
			if (0 == i%5)
				sampleLabels[i] = String.valueOf(i + 1 + "��");
		}
		return sampleLabels;
	}
	public static Image getImage(int width, int height) {
		double[] sampleValues = sampleValues();
		//ģ����������
		String[] sampleLabels = sampleLabels();
		//������ʾ������
		int max = max(sampleValues);
		//�����е����ֵ
		
		Color[] sampleColors = new Color[] { ColorUtil.blueColor };
		//������ɫ
		
		BarChart chart = new BarChart();
		//��״ͼ
		
		chart.setSampleCount(sampleValues.length);
		//������������
		chart.setSampleValues(0, sampleValues);
		//������������
		chart.setSampleLabels(sampleLabels);
		//��������
		chart.setSampleColors(sampleColors);
		//����������ɫ
		chart.setRange(0, max * 1.2);
		//����ȡֵ��Χ
		chart.setValueLinesOn(true);
		//���ñ�������
		chart.setSampleLabelsOn(true);
		//��ʾ����
		chart.setSampleLabelStyle(Chart.BELOW);
		//��������ʾ���·�
		
		chart.setFont("rangeLableFont", new Font("Arial", Font.BOLD, 12));
		//����ֵ������
		chart.setLegendOn(true);
		//��ʾͼ��˵��
		chart.setLegendPosition(Chart.LEFT);
		//��ͼ��˵���������
		chart.setLegendLabels(new String[] {"�����ѱ���"});
		//ͼ��˵���е�����
		chart.setFont("legendFont", new Font("Dialog", Font.BOLD, 13));
		//ͼ��˵��������
		chart.setFont("sampleLabelFont", new Font("Dialog", Font.BOLD, 13));
		//�·����ֵ�����
		chart.setChartBackground(Color.white);
		//ͼ���м䱳����ɫ
		chart.setBackground(ColorUtil.backgroundColor);
		//ͼ�����屳����ɫ
		Image im = chart.getImage(width, height);
		//��ͼ��ת��ΪImage����
		return im;
	}
	private static double[] sampleValues() {
		double[] result = new double[30];
		for (int i = 0; i < result.length; i++) {
			result[i] = (int)(Math.random() * 300);
		}
		return result;
	}
	//��Ʒ
	public static void main(String[] args) {
		JPanel p = new JPanel();
		JLabel l = new JLabel();
		Image img = ChartUtil.getImage(400, 300);
		Icon icon = new ImageIcon(img);
		l.setIcon(icon);
		p.add(l);
		GUIUtil.showPanel(p);
	}
}