package com.cihangul.bilgiyarismasi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Sonuc extends AppCompatActivity {

    TextView dogru,yanlis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonuc);
        dogru=(TextView)findViewById(R.id.dogru);
        yanlis=(TextView)findViewById(R.id.yanlis);
        dogru.setText("Doğru Sayısı: "+MainActivity.dogru);
        yanlis.setText("Yanlış Sayısı: "+MainActivity.yanlis);
    }
}
