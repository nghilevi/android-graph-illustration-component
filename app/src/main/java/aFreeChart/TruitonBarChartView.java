package aFreeChart;

/**
 * Created by Le on 3/13/14.
 */


        import org.afree.chart.ChartFactory;
        import org.afree.chart.AFreeChart;
        import org.afree.chart.axis.CategoryAxis;
        import org.afree.chart.axis.CategoryLabelPositions;
        import org.afree.chart.axis.NumberAxis;
        import org.afree.chart.plot.CategoryPlot;
        import org.afree.chart.plot.PlotOrientation;
        import org.afree.chart.renderer.category.BarRenderer;
        import org.afree.data.category.CategoryDataset;
        import org.afree.data.category.DefaultCategoryDataset;
        import org.afree.graphics.GradientColor;
        import org.afree.graphics.SolidColor;

        import android.content.Context;
        import android.graphics.Color;

public class TruitonBarChartView extends DemoView {

    /**
     * constructor
     * @param context
     */
    public TruitonBarChartView(Context context) {
        super(context);

        CategoryDataset dataset = createDataset();
        AFreeChart chart = createChart(dataset);

        setChart(chart);
    }

    /**
     * Returns a sample dataset.
     *
     * @return The dataset.
     */
    private static CategoryDataset createDataset() {

        // row keys...
        String series1 = "Sales";
        String series2 = "Expenses";

        // column keys...
        String category1 = "2010";
        String category2 = "2011";
        String category3 = "2012";
        String category4 = "2013";

        // create the dataset...
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dataset.addValue(1.0, series1, category1);
        dataset.addValue(4.0, series1, category2);
        dataset.addValue(3.0, series1, category3);
        dataset.addValue(8.0, series1, category4);

        dataset.addValue(5.0, series2, category1);
        dataset.addValue(7.0, series2, category2);
        dataset.addValue(6.0, series2, category3);
        dataset.addValue(5.0, series2, category4);

        return dataset;

    }

    /**
     * Creates a sample chart.
     *
     * @param dataset  the dataset.
     *
     * @return The chart.
     */
    private static AFreeChart createChart(CategoryDataset dataset) {

        // create the chart...
        AFreeChart chart = ChartFactory.createBarChart(
                "Truiton's Performance by AFreeChart Bar Chart",      // chart title
                "Year",               // domain axis label
                "Sales/Expenses",         // range axis label
                dataset,                  // data
                PlotOrientation.VERTICAL, // orientation
                true,                     // include legend
                true,                     // tooltips?
                false                     // URLs?
        );

        // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...

        // set the background color for the chart...
        chart.setBackgroundPaintType(new SolidColor(Color.WHITE));

        // get a reference to the plot for further customisation...
        CategoryPlot plot = (CategoryPlot) chart.getPlot();

        // set the range axis to display integers only...
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        // disable bar outlines...
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setDrawBarOutline(false);

        // set up gradient paints for series...
        GradientColor gp0 = new GradientColor(Color.BLUE, Color.rgb(51, 102, 204));
        GradientColor gp1 = new GradientColor(Color.RED, Color.rgb(255, 0, 0));
        renderer.setSeriesPaintType(0, gp0);
        renderer.setSeriesPaintType(1, gp1);

        CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryLabelPositions(
                CategoryLabelPositions.createUpRotationLabelPositions(
                        Math.PI / 6.0));
        // OPTIONAL CUSTOMISATION COMPLETED.

        return chart;

    }
}