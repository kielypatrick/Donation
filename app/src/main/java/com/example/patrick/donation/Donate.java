package com.example.patrick.donation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.NumberPicker;
import android.widget.ProgressBar;
import android.widget.Toast;

public class Donate extends AppCompatActivity {

    private Button donateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);

        donateButton  = (Button)       findViewById(R.id.donateButton);
        paymentMethod = (RadioGroup)   findViewById(R.id.paymentMethod);
        progressBar   = (ProgressBar)  findViewById(R.id.progressBar);
        amountPicker  = (NumberPicker) findViewById(R.id.amountPicker);

        amountPicker.setMinValue(0);
        amountPicker.setMaxValue(1000);
        progressBar.setMax(10000);



    }

    public void donateButtonPressed (View view)
    {
        int amount = amountPicker.getValue();

        String method = paymentMethod.getCheckedRadioButtonId() == R.id.PayPal ? "PayPal" : "Direct";

        if (totalDonated < 10000) {

            totalDonated = totalDonated + amount;
            progressBar.setProgress(totalDonated);
            Log.v("Donate", "Current total " + totalDonated);
            Log.v("Donate", "Donate Pressed! with amount " + amount + ", method: " + method);

        }
        else {
            Toast toast = Toast.makeText(this, "Target Exceeded!", Toast.LENGTH_SHORT);
            toast.show();
            Log.v("Donate","Target Exceeded: " + totalDonated);

        }
    }

    private RadioGroup   paymentMethod;
    private ProgressBar  progressBar;
    private NumberPicker amountPicker;

    private int totalDonated;


}
