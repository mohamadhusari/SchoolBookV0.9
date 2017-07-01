package SchoolAdmin;

import org.jfree.chart.ChartPanel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;


import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class LineChart_AWT extends ApplicationFrame {

	public LineChart_AWT( String applicationTitle , String chartTitle ,int [] ArrayCounter) {
		super(applicationTitle);
		JFreeChart lineChart = ChartFactory.createLineChart(
				chartTitle,
				"Grade","noStudents",
				createDataset(ArrayCounter),
				PlotOrientation.VERTICAL,
				true,true,false);

		ChartPanel chartPanel = new ChartPanel( lineChart );
		chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
		setContentPane( chartPanel );
	}

	
	private DefaultCategoryDataset createDataset(int [] ArrayCounter){
		DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
		for(int i=0;i<ArrayCounter.length;i++){
			dataset.addValue(ArrayCounter[i], "Grades", i+"");
		}
		
		return dataset;
	}

	
}