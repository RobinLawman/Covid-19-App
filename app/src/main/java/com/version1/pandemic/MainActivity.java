package com.version1.pandemic;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Pie;
import com.anychart.palettes.RangeColors;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView infectedResult;
    private TextView deadResult;
    private TextView recoveredResult;
    private TextView activeResult;

    Handler handler = new Handler();
    Runnable refresh;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        infectedResult = findViewById(R.id.infectedResult);
        deadResult = findViewById(R.id.deadResult);
        recoveredResult = findViewById(R.id.recoveredResult);
        activeResult = findViewById(R.id.activeResult);

        IntroViewDialog alert = new IntroViewDialog();
        alert.showDialog(MainActivity.this, "Please respect that this app is for educational purposes ONLY. Through this app i hope to bring some reassurance and clarity to those who need it in this difficult time.\n\n" +
                "Information is key therefore i have ensured that all my sauces are reliable. I have included some helpful links in order to support, donate and inform you of the current situation.\n\n" +
                "Please respect that for some those numbers aren't just figures and please ensure you are taking care when talking about a sensitive subject as i hope i am. I wish you all the best, stay safe.");


        refresh = new Runnable() {
            public void run() {
                getWebsite();
                handler.postDelayed(refresh, 60000);
            }
        };
        handler.post(refresh);

        LinearLayout worldBut = findViewById(R.id.worldButton);
        worldBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, worldStats.class);
                startActivity(intent);
            }
        });

        LinearLayout symptomsBut = findViewById(R.id.symptomButton);
        symptomsBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, symptoms.class);
                startActivity(intent);
            }
        });

        LinearLayout preventionBut = findViewById(R.id.preventionButton);
        preventionBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, prevention.class);
                startActivity(intent);
            }
        });

        //LinearLayout ukBut = findViewById(R.id.ukButton);
        //ukBut.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View v) {
        //        Intent intent = new Intent(MainActivity.this, UKmap.class);
        //        startActivity(intent);
        //    }
        //});
    }

    private void getWebsite() {
        new Thread(new Runnable() {
            @Override
            public void run() {

                final StringBuilder infected = new StringBuilder();
                final StringBuilder dead = new StringBuilder();
                final StringBuilder recovered = new StringBuilder();
                final StringBuilder active = new StringBuilder();

                try {
                    Document doc = Jsoup.connect("https://bit.ly/2VPPteX").get();
                    Elements coCount  = doc.select("div.maincounter-number");
                    Elements actives = doc.select("div.number-table-main");

                    infected.append(coCount.get(0).text());
                    dead.append(coCount.get(1).text());
                    recovered.append(coCount.get(2).text());

                    active.append(actives.get(0).text());



                    //for (Element headline  : newsHeadlines) {
                    //    builder.append("\n").append(headline.child(0).text());
                    //}
                } catch (IOException e) {
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        infectedResult.setText(infected.toString());
                        deadResult.setText(dead.toString());
                        recoveredResult.setText(recovered.toString());
                        activeResult.setText(active.toString());

                        int activeCases = Integer.parseInt(active.toString().replaceAll(",",""));
                        int deaths = Integer.parseInt(dead.toString().replaceAll(",",""));
                        int Totrecovered = Integer.parseInt(recovered.toString().replaceAll(",",""));

                        Pie pie = AnyChart.pie();

                        RangeColors palette = RangeColors.instantiate();
                        palette.items("#FDFD96", "#F44336");
                        palette.count(4);
                        pie.palette(palette);

                        pie.background().fill("#445190");
                        pie.background().cornerType("round");
                        pie.background().corners(20,20,20,20);
                        List<DataEntry> data = new ArrayList<>();
                        data.add(new ValueDataEntry("Active Cases", activeCases ));
                        data.add(new ValueDataEntry("Total Recovered", Totrecovered ));
                        data.add(new ValueDataEntry("Total Deaths", deaths ));
                        pie.data(data);

                        pie.labels().position("outside");
                        pie.labels().fontColor("#fff");

                        pie.normal().outline().enabled(true);
                        pie.normal().outline().width("5%");
                        pie.normal().fontColor("#000");

                        pie.hovered().outline().width("10%");
                        pie.selected().outline().width("3");
                        pie.selected().outline().fill("#455a64");
                        pie.selected().outline().stroke(null);
                        pie.selected().outline().offset(2);
                        pie.normal().fontColor("#000");

                        AnyChartView anyChartView = findViewById(R.id.any_chart_view);
                        anyChartView.setChart(pie);
                    }
                });
            }
        }).start();
    }

}