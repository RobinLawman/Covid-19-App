package com.version1.pandemic;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.IOException;

public class worldStats extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        findCountries();
    }

    public void findCountries() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Elements ct = new Elements();
                Elements totalCases = new Elements();

                try {
                    Document doc = Jsoup.connect("https://bit.ly/2VPPteX").get();
                    ct  = doc.select(".mt_a");
                    totalCases  = doc.select("td + td");

                } catch (IOException e) {
                }

                //System.out.println("-----------------------------------------"+ct.get(0).text());

                final Elements finalCt = ct;
                final Elements finalTotalCases = totalCases;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //System.out.println("-----------------------------------------"+ finalTotalCases.get(96).text());
                        createTable(finalCt, finalTotalCases);
                    }
                });
            }
        }).start();
    }

    public void createTable(Elements countries, Elements totalCases){
        //System.out.println("------------------"+countries.size()/2+"-----------------------");
        TableLayout stk = findViewById(R.id.table_main);
        int size = stk.getWidth()/5;

        Typeface boldTypeface = Typeface.defaultFromStyle(Typeface.BOLD);

        for (int i = 0; i < countries.size()/2; i++) {
            TableRow tbrow = new TableRow(this);
            TextView row1data = new TextView(this);
            row1data.setText(countries.get(i).text());
            row1data.setTextColor(Color.BLACK);
            row1data.setGravity(Gravity.CENTER);
            row1data.setTypeface(boldTypeface);
            tbrow.addView(row1data);

            TextView row2data = new TextView(this);
            row2data.setText(totalCases.get(96+(i*12)).text());
            row2data.setTextColor(Color.BLACK);
            row2data.setGravity(Gravity.CENTER);
            tbrow.addView(row2data);

            TextView row3data = new TextView(this);
            row3data.setText(totalCases.get(97+(i*12)).text());
            row3data.setTextColor(Color.BLACK);
            row3data.setGravity(Gravity.CENTER);
            tbrow.addView(row3data);

            TextView row4data = new TextView(this);
            row4data.setText(totalCases.get(98+(i*12)).text());
            row4data.setTextColor(Color.RED);
            row4data.setGravity(Gravity.CENTER);
            tbrow.addView(row4data);

            TextView row5data = new TextView(this);
            row5data.setText(totalCases.get(99+(i*12)).text());
            row5data.setTextColor(Color.RED);
            row5data.setGravity(Gravity.CENTER);
            tbrow.addView(row5data);

            if (i%2==1){
                tbrow.setBackgroundColor(Color.parseColor("#A8FEE3D4"));
            }

            row1data.setWidth(size);
            row2data.setWidth(size);
            row3data.setWidth(size);
            row4data.setWidth(size);
            row5data.setWidth(size);

            row1data.setTextSize(16);
            row2data.setTextSize(16);
            row3data.setTextSize(16);
            row4data.setTextSize(16);
            row5data.setTextSize(16);
            stk.addView(tbrow);
        }
    }
}

