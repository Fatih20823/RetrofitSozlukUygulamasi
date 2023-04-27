package com.example.szlk;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetayActivity extends AppCompatActivity {
    private TextView textTurkce,textingilizce;
    private Kelimeler kelime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detay);

        textingilizce = findViewById(R.id.textViewingilizce);
        textTurkce = findViewById(R.id.textViewturkce);

        kelime = (Kelimeler) getIntent().getSerializableExtra("nesne");

        textingilizce.setText(kelime.getIngilizce());
        textTurkce.setText(kelime.getTurkce());

    }
}