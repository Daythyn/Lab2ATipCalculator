package com.example.lab2atipcalc;


import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.lab2atipcalc.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        binding.calButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try{
                    double bill = Double.parseDouble(String.valueOf(binding.billDoubleField.getText()));
                    int tipPerc = Integer.parseInt(String.valueOf(binding.percIntField.getText()));
                    int numP = Integer.parseInt(String.valueOf(binding.peopleIntField.getText()));

                    double tip = (bill * (double) tipPerc / 100);
                    double tipPP = tip / (double) numP;

                    StringBuilder tipFinal = new StringBuilder();
                    tipFinal.append(getResources().getString(R.string.tPPersonF)).append(String.format("%.2f", tipPP));

                    StringBuilder billFinal = new StringBuilder();
                    billFinal.append(getResources().getString(R.string.billFinalF)).append(String.format("%.2f", (bill + tip)));

                    binding.tipTotalText.setText(tipFinal);
                    binding.billFinalText.setText(billFinal);


                } catch (NumberFormatException e) {
                    binding.tipTotalText.setText(getResources().getString(R.string.tPPerson));
                    binding.billFinalText.setText(getResources().getString(R.string.failure));
                }
            }
        });
    }
}