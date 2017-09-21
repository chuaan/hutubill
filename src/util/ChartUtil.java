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
				sampleLabels[i] = String.valueOf(i + 1 + "日");
		}
		return sampleLabels;
	}
	public static Image getImage(int width, int height) {
		double[] sampleValues = sampleValues();
		//模拟样本数据
		String[] sampleLabels = sampleLabels();
		//下面显示的文字
		int max = max(sampleValues);
		//样本中的最大值
		
		Color[] sampleColors = new Color[] { ColorUtil.blueColor };
		//数据颜色
		
		BarChart chart = new BarChart();
		//柱状图
		
		chart.setSampleCount(sampleValues.length);
		//设置样本个数
		chart.setSampleValues(0, sampleValues);
		//设置样本数据
		chart.setSampleLabels(sampleLabels);
		//设置文字
		chart.setSampleColors(sampleColors);
		//设置样本颜色
		chart.setRange(0, max * 1.2);
		//设置取值范围
		chart.setValueLinesOn(true);
		//设置背景横线
		chart.setSampleLabelsOn(true);
		//显示文字
		chart.setSampleLabelStyle(Chart.BELOW);
		//把文字显示在下方
		
		chart.setFont("rangeLableFont", new Font("Arial", Font.BOLD, 12));
		//样本值的字体
		chart.setLegendOn(true);
		//显示图例说明
		chart.setLegendPosition(Chart.LEFT);
		//把图例说明放在左侧
		chart.setLegendLabels(new String[] {"月消费报表"});
		//图例说明中的文字
		chart.setFont("legendFont", new Font("Dialog", Font.BOLD, 13));
		//图例说明的字体
		chart.setFont("sampleLabelFont", new Font("Dialog", Font.BOLD, 13));
		//下方文字的字体
		chart.setChartBackground(Color.white);
		//图表中间背景颜色
		chart.setBackground(ColorUtil.backgroundColor);
		//图表整体背景颜色
		Image im = chart.getImage(width, height);
		//把图表转换为Image类型
		return im;
	}
	private static double[] sampleValues() {
		double[] result = new double[30];
		for (int i = 0; i < result.length; i++) {
			result[i] = (int)(Math.random() * 300);
		}
		return result;
	}
	//样品
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