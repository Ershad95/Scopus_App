package scopus.raoufi.ershad.scopus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class Chart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);

        BarChart chart =(BarChart) findViewById(R.id.chart);

        ArrayList<String> label = new ArrayList<>();
        for(int year=1999;year<=2017;year+=2)
        {
            label.add(String.valueOf(year));
        }
        ArrayList<BarEntry> entries = new ArrayList<>();
        int i=0;
        for(int year=1999;year<=2017;year+=2)
        {
            i++;
            entries.add(new BarEntry((year),i));
        }
        BarDataSet dataset = new BarDataSet(entries,"Y");
        dataset.setColors(ColorTemplate.COLORFUL_COLORS);
        BarData data = new BarData(dataset);
        chart.setContentDescription("Ershad Raoufi");
        chart.animateY(2000);
        chart.setData(data);



    }
}
