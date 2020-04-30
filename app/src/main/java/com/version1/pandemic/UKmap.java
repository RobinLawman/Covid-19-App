package com.version1.pandemic;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class UKmap extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ukmap);

        getWebsite();
    }

    private void getWebsite() {
        new Thread(new Runnable() {
            @Override
            public void run() {


                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //do the visual side in here
                    }
                });
            }
        }).start();
    }
}
