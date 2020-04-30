package com.version1.pandemic;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;

public class symptoms extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptoms);

        final LinearLayout feverBut = findViewById(R.id.fever);
        feverBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewDialog alert = new ViewDialog();
                alert.showDialog(symptoms.this, "88% of cases had symptoms a fever, this is when your body is over 37.8 Degrees Celcius. This is the most common symptom of the current virus.");
            }
        });

        final LinearLayout coughBut = findViewById(R.id.dryCough);
        coughBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewDialog alert = new ViewDialog();
                alert.showDialog(symptoms.this, "This is the second most common symptom of current virus with 68% of cases showing this symptom \"dry cough\" means it's tickly and doesn't produce any phlegm (thick mucus).");
            }
        });

        final LinearLayout tiredBut = findViewById(R.id.tired);
        tiredBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewDialog alert = new ViewDialog();
                alert.showDialog(symptoms.this, "You know the deep exhaustion that can hit during the flu, feeling exhausted, either mentally, physically, or both? This feels the same, and about 38% of people with the current virus experience it.");
            }
        });

        final LinearLayout coughBut2 = findViewById(R.id.cus);
        coughBut2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewDialog alert = new ViewDialog();
                alert.showDialog(symptoms.this, "Coughing is a natural reflex. It’s your body’s way of clearing your airways. Occurring in 33% of cases, this mix of saliva and mucus is coughed up from the respiratory tract.");
            }
        });

        final LinearLayout shortBut = findViewById(R.id.breath);
        shortBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewDialog alert = new ViewDialog();
                alert.showDialog(symptoms.this, "This was reported in about 18% of cases. Is often described as an intense tightening in the chest, air hunger, difficulty breathing, breathlessness or a feeling of suffocation. If you have a hard time breathing while doing daily activities that don’t typically cause an issue. Then it might be current virus-related. ");
            }
        });

        final LinearLayout jointBut = findViewById(R.id.muscle);
        jointBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewDialog alert = new ViewDialog();
                alert.showDialog(symptoms.this, " Joint or Muscle aches happen in 14.8% of cases. Which joints or muscles? Again, what impacts you might not impact someone else, so if you have joint pain with other symptoms listed here, it might be the current virus (though, of course, it might be the flu or a common cold). ");
            }
        });

        final LinearLayout throatBut = findViewById(R.id.throat);
        throatBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewDialog alert = new ViewDialog();
                alert.showDialog(symptoms.this, " This is typical throat pain, like the kind you might have with a cold. About 14% of people with current virus had a sore throat.");
            }
        });

        final LinearLayout headBut = findViewById(R.id.headache);
        headBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewDialog alert = new ViewDialog();
                alert.showDialog(symptoms.this, " Feels like your basic headache—your head just hurts, and hurts bad—and it’s coupled with other current virus signs, so you’d know it’s not just a stress headache from all the bad news. 13% of cases include headaches as a symptom. ");
            }
        });

        final LinearLayout noseBut = findViewById(R.id.nose);
        noseBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewDialog alert = new ViewDialog();
                alert.showDialog(symptoms.this, " Stuffy noses can happen with the current virus, but they’re not as typical as other symptoms, occurring in nearly 5% of cases studied. ");
            }
        });

        final LinearLayout bloodBut = findViewById(R.id.blood);
        bloodBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewDialog alert = new ViewDialog();
                alert.showDialog(symptoms.this, " This is an awful one. It’s when you cough up blood or blood-stained mucus from the bronchi, larynx, trachea, or lungs. It occurs in 0.9% of cases. Seek help immediately. ");
            }
        });

        final LinearLayout honorBut = findViewById(R.id.honor);
        honorBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewDialog alert = new ViewDialog();
                alert.showDialog(symptoms.this, "Loss of sense of smell and taste\n " +
                        "Diarrhea\n" +
                        "Chills\n" +
                        "Nausea or vomiting\n" +
                        "Runny nose\n" +
                        "Toe bumps");
            }
        });
    }

}
