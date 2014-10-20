/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication2;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;



public class PieChart extends JFrame {

  Manipulacao m = new Manipulacao();
    
  public PieChart(String applicationTitle, String chartTitle) throws ClassNotFoundException, SQLException, IOException {
        super(applicationTitle);
        PieDataset dataset = createDataset();
        JFreeChart chart = createChart(dataset, chartTitle);
        ChartPanel chartPanel = new ChartPanel(chart);
        //ChartUtilities.saveChartAsJPEG(new File("C:/Users/Public/Pictures/Piechart.jpg"), chart, 400, 300);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(chartPanel);
        this.setExtendedState(BarChart3D.MAXIMIZED_BOTH);       
    }

    private  PieDataset createDataset() throws ClassNotFoundException, SQLException {
        m.calculoSatisfacao();
        DefaultPieDataset result = new DefaultPieDataset();
        result.setValue("Satisfeito", m.getsatisfeito());
        result.setValue("Insatisfeito", m.getinsatisfeito());
        return result;        
    }

    private JFreeChart createChart(PieDataset dataset, String title) {
        
        JFreeChart chart = ChartFactory.createPieChart3D(title, dataset, true, true, false);
        PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setStartAngle(290);
        plot.setDirection(Rotation.CLOCKWISE);
        plot.setForegroundAlpha(0.5f);
        return chart;  
    }
} 