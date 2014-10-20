/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication2;

import java.io.IOException;
import java.sql.SQLException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class BarChart3D extends ApplicationFrame
{
    Manipulacao m = new Manipulacao();
    private JFreeChart chart;
    public BarChart3D(String applicationTitle , String chartTitle) throws ClassNotFoundException, SQLException, IOException {
        super(applicationTitle);
      JFreeChart barChart = ChartFactory.createBarChart3D(
         chartTitle,
         "Notas","Porcentagem de votos.",
         createDataset(),
         PlotOrientation.VERTICAL,
         true,true,false);
      CategoryPlot plot = barChart.getCategoryPlot();
      plot.getRangeAxis().setRange(0, 100);
      ChartPanel chartPanel = new ChartPanel( barChart );
      chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
      setContentPane( chartPanel );
      this.setExtendedState(BarChart3D.MAXIMIZED_BOTH);
      //ChartUtilities.saveChartAsJPEG(new File("C:/Users/Public/Pictures/Barchart.jpg"), barChart, 956, 538);
   }

   private  DefaultCategoryDataset createDataset( ) throws ClassNotFoundException, SQLException
   {
      m.calculoNotas();
      DefaultCategoryDataset dataset = new  DefaultCategoryDataset(); 
      dataset.addValue( m.getnota1() , "Nota 1" , "Nota 1" );
      dataset.addValue( m.getnota2() , "Nota 2" , "Nota 2" );
      dataset.addValue( m.getnota3() , "Nota 3" , "Nota 3" );
      dataset.addValue( m.getnota4() , "Nota 4" , "Nota 4" );
      dataset.addValue( m.getnota5() , "Nota 5" , "Nota 5" );
      return dataset;
   }
   public static void main( String[ ] args ) throws ClassNotFoundException, SQLException, InterruptedException, Throwable
   {
      Manipulacao m = new Manipulacao();
      m.manipulaTempo();
   }
}
