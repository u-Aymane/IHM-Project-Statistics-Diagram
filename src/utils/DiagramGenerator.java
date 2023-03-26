package utils;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.*;
import java.util.List;

public class DiagramGenerator {

    public JFreeChart createBarChart(String title, String xAxisLabel, String yAxisLabel, List<Double> dataPoints) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < dataPoints.size(); i++) {
            dataset.setValue(dataPoints.get(i), "", "Value " + (i + 1));
        }
        JFreeChart chart = ChartFactory.createBarChart(title, xAxisLabel, yAxisLabel, dataset, PlotOrientation.VERTICAL,
                false, true, false);
        CategoryPlot plot = chart.getCategoryPlot();
        ((CategoryPlot) plot).setRangeGridlinePaint(Color.BLACK);
        ChartUtils ChartUtilities = null;
        ChartUtils.applyCurrentTheme(chart);
        return chart;
    }

}
