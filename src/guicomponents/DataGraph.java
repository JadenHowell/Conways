import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.List;


public class DataGraph extends JFrame implements ActionListener {
    final int FRAMERATE = MainPanel.FRAMERATE;
    static int baseTime = 0;
    JFreeChart chart;

    public DataGraph() {
        initUI();
        new Timer(FRAMERATE, this).start(); //This updates the graph every FRAMERATE milliseconds
    }

    private void initUI() {
        XYDataset dataset = createDataset();
        chart = createChart(dataset);

        ChartPanel chartPanel = new ChartPanel(chart);
        //chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);
        add(chartPanel);
        URL iconURL = getClass().getResource("res/conwayIcon.png");
        ImageIcon image = new ImageIcon(iconURL);
        setIconImage(image.getImage());
        pack();
        setTitle("Line chart");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private XYDataset createDataset() {

        var series = new XYSeries("Cells");
        List<Integer> data = DataTracker.getInstance().getData();
        for(int i = 0; i < data.size(); i ++){
            series.add(i + baseTime, data.get(i));
        }

        var dataset = new XYSeriesCollection();
        dataset.addSeries(series);

        return dataset;
    }

    private JFreeChart createChart(XYDataset dataset) {

        JFreeChart chart = ChartFactory.createXYLineChart(
                "Population Size over time",
                "Time",
                "Num Cells",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        XYPlot plot = chart.getXYPlot();

        var renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesStroke(0, new BasicStroke(2.0f));

        plot.setRenderer(renderer);
        plot.setBackgroundPaint(Color.white);

        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.BLACK);

        plot.setDomainGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.BLACK);

        chart.getLegend().setFrame(BlockBorder.NONE);

        chart.setTitle(new TextTitle("Number of Cells alive",
                        new Font("Serif", java.awt.Font.BOLD, 18)
                )
        );

        return chart;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        chart.getXYPlot().setDataset(createDataset()); //changes the dataset by recalculating it, allows for more fine tuned tracking.
    }
}
